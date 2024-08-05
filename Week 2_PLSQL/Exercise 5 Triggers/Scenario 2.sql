CREATE TABLE AuditLog (
    AuditLogID INT IDENTITY(1,1) PRIMARY KEY,
    TransactionID INT,
    AccountID INT,
    TransactionDate DATETIME,
    Amount DECIMAL(18, 2),
    TransactionType VARCHAR(10),
    LogDate DATETIME
);


CREATE TRIGGER LogTransaction
ON Transactions
AFTER INSERT
AS
BEGIN
    -- Insert a record into AuditLog for each new transaction
    INSERT INTO AuditLog (TransactionID, AccountID, TransactionDate, Amount, TransactionType, LogDate)
    SELECT TransactionID, AccountID, TransactionDate, Amount, TransactionType, GETDATE()
    FROM inserted;
END;


