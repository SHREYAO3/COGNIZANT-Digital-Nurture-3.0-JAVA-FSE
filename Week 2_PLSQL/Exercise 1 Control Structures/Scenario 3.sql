DECLARE @LoanID INT, @CustomerID INT, @Name NVARCHAR(100), @EndDate DATE;

DECLARE cur CURSOR FOR
SELECT l.LoanID, l.CustomerID, c.Name, l.EndDate
FROM Loans l
JOIN Customers c ON l.CustomerID = c.CustomerID
WHERE l.EndDate BETWEEN GETDATE() AND DATEADD(DAY, 30, GETDATE());

OPEN cur;
FETCH NEXT FROM cur INTO @LoanID, @CustomerID, @Name, @EndDate;

WHILE @@FETCH_STATUS = 0
BEGIN
    -- Print a reminder message
    PRINT 'Reminder: Dear ' + @Name + ', your loan with LoanID ' + CAST(@LoanID AS NVARCHAR(10)) + ' is due on ' + CONVERT(VARCHAR, @EndDate, 23) + '.';

    FETCH NEXT FROM cur INTO @LoanID, @CustomerID, @Name, @EndDate;
END;

CLOSE cur;
DEALLOCATE cur;
