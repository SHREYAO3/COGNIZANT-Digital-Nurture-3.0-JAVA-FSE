CREATE PROCEDURE AddNewCustomer
    @CustomerID INT,
    @Name NVARCHAR(100),
    @DOB DATE,
    @Balance DECIMAL(18, 2)
AS
BEGIN
    BEGIN TRY
        BEGIN TRANSACTION;

        -- Check if the customer already exists
        IF EXISTS (SELECT 1 FROM Customers WHERE CustomerID = @CustomerID)
        BEGIN
            THROW 50003, 'Customer ID already exists.', 1;
        END

        -- Insert the new customer
        INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
        VALUES (@CustomerID, @Name, @DOB, @Balance, GETDATE());

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
