CREATE TRIGGER CheckTransactionRules
ON Transactions
INSTEAD OF INSERT
AS
BEGIN
    -- Check for invalid transactions
    IF EXISTS (SELECT 1
               FROM inserted i
               JOIN Accounts a ON i.AccountID = a.AccountID
               WHERE (i.TransactionType = 'Withdrawal' AND a.Balance < i.Amount)
                  OR (i.TransactionType = 'Deposit' AND i.Amount <= 0))
    BEGIN
        RAISERROR('Transaction violates business rules.', 16, 1);
        ROLLBACK TRANSACTION;
        RETURN;
    END

    -- Insert valid transactions
    INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
    SELECT TransactionID, AccountID, TransactionDate, Amount, TransactionType
    FROM inserted;

    -- Update the balance in the Accounts table
    UPDATE Accounts
    SET Balance = CASE 
                      WHEN t.TransactionType = 'Deposit' THEN a.Balance + t.Amount
                      WHEN t.TransactionType = 'Withdrawal' THEN a.Balance - t.Amount
                   END
    FROM Accounts a
    JOIN inserted t ON a.AccountID = t.AccountID
    WHERE t.TransactionType IN ('Deposit', 'Withdrawal');
END;
