package StrategyPatternExample;
public class CreditCardPayment implements PaymentStrategy {
    
    public CreditCardPayment() {
    }
    
    @Override
    public void pay(double amount) {
        System.out.println("[CREDIT CARD] Processing payment of $" + amount);
        System.out.println("  Status: Payment successful!");
    }
}
