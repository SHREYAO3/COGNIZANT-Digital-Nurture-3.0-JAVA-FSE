--CREATE SCHEMA AccountOperations;

-- Procedure to Open a New Account
CREATE PROCEDURE AccountOperations.OpenNewAccount
    @AccountID INT,
    @CustomerID INT,
    @AccountType NVARCHAR(20),
    @Balance DECIMAL(18, 2)
AS
BEGIN
    BEGIN TRY
        INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
        VALUES (@AccountID, @CustomerID, @AccountType, @Balance, GETDATE());
    END TRY
    BEGIN CATCH
        PRINT 'Error opening account: ' + ERROR_MESSAGE();
    END CATCH
END;
GO

-- Procedure to Close an Account
CREATE PROCEDURE AccountOperations.CloseAccount
    @AccountID INT
AS
BEGIN
    BEGIN TRY
        DELETE FROM Accounts
        WHERE AccountID = @AccountID;
    END TRY
    BEGIN CATCH
        PRINT 'Error closing account: ' + ERROR_MESSAGE();
    END CATCH
END;
GO

-- Function to Get Total Balance of a Customer
CREATE FUNCTION AccountOperations.GetTotalCustomerBalance
(
    @CustomerID INT
)
RETURNS DECIMAL(18, 2)
AS
BEGIN
    DECLARE @TotalBalance DECIMAL(18, 2);

    -- Calculate the total balance
    SELECT @TotalBalance = SUM(Balance)
    FROM Accounts
    WHERE CustomerID = @CustomerID;

    RETURN ISNULL(@TotalBalance, 0);
END;
GO


