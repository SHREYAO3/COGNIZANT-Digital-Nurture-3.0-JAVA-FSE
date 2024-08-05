CREATE PROCEDURE ProcessMonthlyInterest
AS
BEGIN
    BEGIN TRY
        BEGIN TRANSACTION;

        -- Update the balance of all savings accounts with 1% interest
        UPDATE Accounts
        SET Balance = Balance + (Balance * 0.01)
        WHERE AccountType = 'Savings';

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
