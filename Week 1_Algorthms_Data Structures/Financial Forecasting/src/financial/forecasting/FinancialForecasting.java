/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package financial.forecasting;

/**
 *
 * @author Anuradha
 */
public class FinancialForecasting {

     // Method to calculate future value using recursion
    public static double calculateFutureValue(double presentValue, double growthRate, int years) {
        // Base case: no more years to forecast
        if (years == 0) {
            return presentValue;
        }
        // Recursive case: calculate the future value for the next year
        return calculateFutureValue(presentValue * (1 + growthRate), growthRate, years - 1);
    }

    public static void main(String[] args) {
        double presentValue = 1000.0; // Example present value
        double growthRate = 0.05; // Example annual growth rate (5%)
        int years = 10; // Number of years into the future

        double futureValue = calculateFutureValue(presentValue, growthRate, years);
        System.out.println("Future Value after " + years + " years: $" + futureValue);
    }

    
}
