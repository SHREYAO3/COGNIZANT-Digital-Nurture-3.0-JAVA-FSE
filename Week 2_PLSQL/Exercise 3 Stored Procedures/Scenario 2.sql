CREATE PROCEDURE UpdateEmployeeBonus
    @Department NVARCHAR(50),
    @BonusPercentage DECIMAL(5, 2)
AS
BEGIN
    BEGIN TRY
        BEGIN TRANSACTION;

        -- Update the salary of employees in the specified department by adding the bonus percentage
        UPDATE Employees
        SET Salary = Salary + (Salary * @BonusPercentage / 100)
        WHERE Department = @Department;

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
