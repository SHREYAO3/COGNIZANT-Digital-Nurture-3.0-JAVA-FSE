CREATE TRIGGER UpdateCustomerLastModified
ON Customers
AFTER UPDATE
AS
BEGIN
    -- Update LastModified column to current date and time
    UPDATE Customers
    SET LastModified = GETDATE()
    FROM Customers c
    INNER JOIN inserted i ON c.CustomerID = i.CustomerID;
END;
