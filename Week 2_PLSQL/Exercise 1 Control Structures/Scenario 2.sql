ALTER TABLE Customers ADD IsVIP BIT;

DECLARE @CustomerID INT, @Balance FLOAT;

DECLARE cur CURSOR FOR
SELECT CustomerID, Balance FROM Customers;

OPEN cur;
FETCH NEXT FROM cur INTO @CustomerID, @Balance;

WHILE @@FETCH_STATUS = 0
BEGIN
    -- Check if the customer's balance is over $10,000
    IF @Balance > 10000
    BEGIN
        -- Set IsVIP to TRUE
        UPDATE Customers
        SET IsVIP = 1
        WHERE CustomerID = @CustomerID;
    END
    ELSE
    BEGIN
        -- Set IsVIP to FALSE
        UPDATE Customers
        SET IsVIP = 0
        WHERE CustomerID = @CustomerID;
    END

    FETCH NEXT FROM cur INTO @CustomerID, @Balance;
END;

CLOSE cur;
DEALLOCATE cur;
