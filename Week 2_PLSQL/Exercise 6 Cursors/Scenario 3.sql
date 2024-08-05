DECLARE @LoanID INT;
DECLARE @OldInterestRate DECIMAL(5, 2);
DECLARE @NewInterestRate DECIMAL(5, 2);

DECLARE c_loans CURSOR FOR
    SELECT LoanID, InterestRate
    FROM Loans;

OPEN c_loans;

FETCH NEXT FROM c_loans INTO @LoanID, @OldInterestRate;

WHILE @@FETCH_STATUS = 0
BEGIN
    -- Example policy: Increase interest rate by 0.5%
    SET @NewInterestRate = @OldInterestRate + 0.5;

    -- Update the loan interest rate
    UPDATE Loans
    SET InterestRate = @NewInterestRate
    WHERE LoanID = @LoanID;

    PRINT 'Loan ID: ' + CAST(@LoanID AS NVARCHAR(10)) + ' - Interest rate updated from ' + CAST(@OldInterestRate AS NVARCHAR(20)) + ' to ' + CAST(@NewInterestRate AS NVARCHAR(20));

    FETCH NEXT FROM c_loans INTO @LoanID, @OldInterestRate;
END;

CLOSE c_loans;
DEALLOCATE c_loans;
