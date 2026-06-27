package StrategyPatternExample;
public class PaymentContext {
    private PaymentStrategy paymentStrategy;
    
    public PaymentContext() {
    }
    
    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.paymentStrategy = strategy;
    }
    
    public void makePayment(double amount) {
        if (paymentStrategy == null) {
            System.out.println("[ERROR] No payment strategy selected!");
            return;
        }
        paymentStrategy.pay(amount);
    }
}
