package StrategyPatternExample;
public class GooglePayPayment implements PaymentStrategy {
    private String phoneNumber;
    
    public GooglePayPayment(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    @Override
    public void pay(double amount) {
        System.out.println("[GOOGLE PAY] Processing payment of $" + amount);
        System.out.println("  Mobile Number: " + phoneNumber);
        System.out.println("  Status: Authenticating with biometric...");
        System.out.println("  Status: Payment confirmed!");
    }
}
