CREATE PROCEDURE UpdateSalary
    @EmployeeID INT,
    @PercentageIncrease DECIMAL(5, 2)
AS
BEGIN
    BEGIN TRY
        BEGIN TRANSACTION;

        -- Check if the employee exists
        IF NOT EXISTS (SELECT 1 FROM Employees WHERE EmployeeID = @EmployeeID)
        BEGIN
            THROW 50002, 'Employee ID does not exist.', 1;
        END

        -- Update the salary
        UPDATE Employees
        SET Salary = Salary + (Salary * @PercentageIncrease / 100)
        WHERE EmployeeID = @EmployeeID;

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
