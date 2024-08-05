DECLARE @CustomerID INT;
DECLARE @Name NVARCHAR(100);
DECLARE @TransactionDate DATE;
DECLARE @Amount DECIMAL(18, 2);
DECLARE @TransactionType NVARCHAR(10);

DECLARE c_monthly_statements CURSOR FOR
    SELECT c.CustomerID, c.Name, t.TransactionDate, t.Amount, t.TransactionType
    FROM Customers c
    JOIN Accounts a ON c.CustomerID = a.CustomerID
    JOIN Transactions t ON a.AccountID = t.AccountID
    WHERE MONTH(t.TransactionDate) = MONTH(GETDATE())
      AND YEAR(t.TransactionDate) = YEAR(GETDATE());

OPEN c_monthly_statements;

FETCH NEXT FROM c_monthly_statements INTO @CustomerID, @Name, @TransactionDate, @Amount, @TransactionType;

WHILE @@FETCH_STATUS = 0
BEGIN
    -- Print or process the statement
    PRINT 'Customer ID: ' + CAST(@CustomerID AS NVARCHAR(10));
    PRINT 'Name: ' + @Name;
    PRINT 'Transaction Date: ' + CONVERT(NVARCHAR(10), @TransactionDate, 120);
    PRINT 'Amount: ' + CAST(@Amount AS NVARCHAR(20));
    PRINT 'Transaction Type: ' + @TransactionType;
    PRINT '------------------------------------';

    FETCH NEXT FROM c_monthly_statements INTO @CustomerID, @Name, @TransactionDate, @Amount, @TransactionType;
END;

CLOSE c_monthly_statements;
DEALLOCATE c_monthly_statements;
