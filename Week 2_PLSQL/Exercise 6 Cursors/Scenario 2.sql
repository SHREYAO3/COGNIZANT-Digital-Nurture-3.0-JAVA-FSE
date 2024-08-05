DECLARE @AccountID INT;
DECLARE @Balance DECIMAL(18, 2);
DECLARE @AnnualFee DECIMAL(18, 2) = 50; -- Example annual fee

DECLARE c_accounts CURSOR FOR
    SELECT AccountID, Balance
    FROM Accounts;

OPEN c_accounts;

FETCH NEXT FROM c_accounts INTO @AccountID, @Balance;

WHILE @@FETCH_STATUS = 0
BEGIN
    -- Deduct annual fee
    UPDATE Accounts
    SET Balance = Balance - @AnnualFee
    WHERE AccountID = @AccountID;

    PRINT 'Account ID: ' + CAST(@AccountID AS NVARCHAR(10)) + ' - Annual fee applied. New Balance: ' + CAST((@Balance - @AnnualFee) AS NVARCHAR(20));

    FETCH NEXT FROM c_accounts INTO @AccountID, @Balance;
END;

CLOSE c_accounts;
DEALLOCATE c_accounts;
