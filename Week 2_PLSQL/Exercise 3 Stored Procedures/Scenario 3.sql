CREATE PROCEDURE TransferFunds
    @FromAccountID INT,
    @ToAccountID INT,
    @Amount DECIMAL(18, 2)
AS
BEGIN
    BEGIN TRY
        BEGIN TRANSACTION;

        DECLARE @FromBalance DECIMAL(18, 2);

        -- Check the balance of the from account
        SELECT @FromBalance = Balance
        FROM Accounts
        WHERE AccountID = @FromAccountID;

        -- Ensure there are sufficient funds
        IF @FromBalance < @Amount
        BEGIN
            THROW 50004, 'Insufficient funds in the source account.', 1;
        END

        -- Deduct the amount from the from account
        UPDATE Accounts
        SET Balance = Balance - @Amount
        WHERE AccountID = @FromAccountID;

        -- Add the amount to the to account
        UPDATE Accounts
        SET Balance = Balance + @Amount
        WHERE AccountID = @ToAccountID;

        COMMIT TRANSACTION;
    END TRY
    BEGIN CATCH
        ROLLBACK TRANSACTION;

        -- Log the error
        DECLARE @ErrorMessage NVARCHAR(4000) = ERROR_MESSAGE();
        INSERT INTO ErrorLog (ErrorMessage, ErrorDate)
        VALUES (@ErrorMessage, GETDATE());

        -- Re-raise the error
        THROW;
    END CATCH;
END;
