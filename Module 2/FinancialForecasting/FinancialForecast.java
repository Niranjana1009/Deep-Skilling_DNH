public class FinancialForecast {

    public static double predictFutureValue(double currentValue, double growthRate, int years) {
        if (years == 0) {
            return currentValue;
        }
        return predictFutureValue(currentValue, growthRate, years - 1) * (1 + growthRate);
    }

    public static double predictFutureValueIterative(double currentValue, double growthRate, int years) {
        double result = currentValue;
        for (int i = 0; i < years; i++) {
            result *= (1 + growthRate);
        }
        return result;
    }

    public static double predictFutureValueFormula(double currentValue, double growthRate, int years) {
        return currentValue * Math.pow(1 + growthRate, years);
    }

    public static void main(String[] args) {
        double presentValue = 10000;
        double growthRate = 0.10;
        int years = 5;

        System.out.println("Recursive Prediction: ₹" + predictFutureValue(presentValue, growthRate, years));
        System.out.println("Iterative Prediction: ₹" + predictFutureValueIterative(presentValue, growthRate, years));
        System.out.println("Formula Prediction: ₹" + predictFutureValueFormula(presentValue, growthRate, years));
    }
}
