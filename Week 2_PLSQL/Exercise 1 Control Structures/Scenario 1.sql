DECLARE @CustomerID INT, @DOB DATE, @LoanID INT, @InterestRate FLOAT, @Age INT;

DECLARE cur CURSOR FOR
SELECT c.CustomerID, c.DOB, l.LoanID, l.InterestRate
FROM Customers c
JOIN Loans l ON c.CustomerID = l.CustomerID;

OPEN cur;
FETCH NEXT FROM cur INTO @CustomerID, @DOB, @LoanID, @InterestRate;

WHILE @@FETCH_STATUS = 0
BEGIN
    -- Calculate the age of the customer
    SET @Age = DATEDIFF(YEAR, @DOB, GETDATE());
    
    -- Check if the customer is above 60
    IF @Age > 60
    BEGIN
        -- Apply 1% discount to the current loan interest rate
        UPDATE Loans
        SET InterestRate = InterestRate - 1
        WHERE LoanID = @LoanID;
    END

    FETCH NEXT FROM cur INTO @CustomerID, @DOB, @LoanID, @InterestRate;
END;

CLOSE cur;
DEALLOCATE cur;
