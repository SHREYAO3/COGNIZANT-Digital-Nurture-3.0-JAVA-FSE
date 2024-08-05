CREATE FUNCTION CalculateMonthlyInstallment
(
    @LoanAmount DECIMAL(18, 2),
    @AnnualInterestRate DECIMAL(5, 2),
    @Years INT
)
RETURNS DECIMAL(18, 2)
AS
BEGIN
    DECLARE @MonthlyInstallment DECIMAL(18, 2);
    DECLARE @MonthlyInterestRate DECIMAL(5, 4);
    DECLARE @NumberOfPayments INT;

    -- Convert annual interest rate to monthly and calculate number of payments
    SET @MonthlyInterestRate = @AnnualInterestRate / 100 / 12;
    SET @NumberOfPayments = @Years * 12;

    -- Calculate the monthly installment using the formula
    SET @MonthlyInstallment = @LoanAmount * @MonthlyInterestRate 
                               / (1 - POWER(1 + @MonthlyInterestRate, -@NumberOfPayments));

    RETURN @MonthlyInstallment;
END;
