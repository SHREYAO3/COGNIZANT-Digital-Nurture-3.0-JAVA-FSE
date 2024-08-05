CREATE SCHEMA CustomerManagement;
GO


-- Procedure to Add a New Customer
CREATE PROCEDURE CustomerManagement.AddNewCustomer
    @CustomerID INT,
    @Name NVARCHAR(100),
    @DOB DATE,
    @Balance DECIMAL(18, 2)
AS
BEGIN
    BEGIN TRY
        INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
        VALUES (@CustomerID, @Name, @DOB, @Balance, GETDATE());
    END TRY
    BEGIN CATCH
        PRINT 'Error adding customer: ' + ERROR_MESSAGE();
    END CATCH
END;
GO

-- Procedure to Update Customer Details
CREATE PROCEDURE CustomerManagement.UpdateCustomerDetails
    @CustomerID INT,
    @Name NVARCHAR(100) = NULL,
    @DOB DATE = NULL,
    @Balance DECIMAL(18, 2) = NULL
AS
BEGIN
    BEGIN TRY
        UPDATE Customers
        SET
            Name = ISNULL(@Name, Name),
            DOB = ISNULL(@DOB, DOB),
            Balance = ISNULL(@Balance, Balance),
            LastModified = GETDATE()
        WHERE CustomerID = @CustomerID;
    END TRY
    BEGIN CATCH
        PRINT 'Error updating customer: ' + ERROR_MESSAGE();
    END CATCH
END;
GO

-- Function to Get Customer Balance
CREATE FUNCTION CustomerManagement.GetCustomerBalance
(
    @CustomerID INT
)
RETURNS DECIMAL(18, 2)
AS
BEGIN
    DECLARE @Balance DECIMAL(18, 2);

    SELECT @Balance = Balance
    FROM Customers
    WHERE CustomerID = @CustomerID;

    RETURN @Balance;
END;
GO
