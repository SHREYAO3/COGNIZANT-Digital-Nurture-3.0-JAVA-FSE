CREATE SCHEMA EmployeeManagement;
GO


-- Function to Calculate Annual Salary
CREATE FUNCTION EmployeeManagement.CalculateAnnualSalary
(
    @EmployeeID INT
)
RETURNS DECIMAL(18, 2)
AS
BEGIN
    DECLARE @AnnualSalary DECIMAL(18, 2);

    -- Calculate annual salary
    SELECT @AnnualSalary = Salary * 12
    FROM Employees
    WHERE EmployeeID = @EmployeeID;

    RETURN @AnnualSalary;
END;
GO
