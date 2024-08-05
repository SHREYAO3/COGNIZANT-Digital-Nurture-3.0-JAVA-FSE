CREATE FUNCTION HasSufficientBalance
(
    @AccountID INT,
    @Amount DECIMAL(18, 2)
)
RETURNS BIT
AS
BEGIN
    DECLARE @Sufficient BIT;

    -- Check if the account has sufficient balance
    IF EXISTS (SELECT 1 
               FROM Accounts 
               WHERE AccountID = @AccountID AND Balance >= @Amount)
    BEGIN
        SET @Sufficient = 1;  -- True
    END
    ELSE
    BEGIN
        SET @Sufficient = 0;  -- False
    END

    RETURN @Sufficient;
END;
