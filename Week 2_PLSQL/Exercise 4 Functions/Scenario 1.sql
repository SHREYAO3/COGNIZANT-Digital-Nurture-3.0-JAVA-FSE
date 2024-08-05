CREATE FUNCTION CalculateAge
(
    @DOB DATE
)
RETURNS INT
AS
BEGIN
    DECLARE @Age INT;
    -- Calculate age based on the current date and date of birth
    SET @Age = DATEDIFF(YEAR, @DOB, GETDATE()) 
               - CASE 
                   WHEN MONTH(@DOB) > MONTH(GETDATE()) 
                        OR (MONTH(@DOB) = MONTH(GETDATE()) AND DAY(@DOB) > DAY(GETDATE())) 
                   THEN 1 
                   ELSE 0 
                 END;
    RETURN @Age;
END;
