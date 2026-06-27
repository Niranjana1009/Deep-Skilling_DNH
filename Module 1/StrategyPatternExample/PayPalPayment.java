package StrategyPatternExample;
public class PayPalPayment implements PaymentStrategy {
    
    public PayPalPayment() {
    }
    
    @Override
    public void pay(double amount) {
        System.out.println("[PAYPAL] Processing payment of $" + amount);
        System.out.println("  Status: Payment verified and completed!");
    }
}
