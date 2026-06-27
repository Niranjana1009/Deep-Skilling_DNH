package AdapterPatternExample;
public class TestClass {
    public static void main(String[] args) {
        PaymentProcessor paypal=new PayPalAdapter(new PayPalGateway());
        PaymentProcessor stripe=new StripeAdapter(new StripeGateway());
        PaymentProcessor razorpay=new RazorPayAdapter(new RazorPayGateway());
        paypal.processPayment(5000);
        stripe.processPayment(2500);
        razorpay.processPayment(1000);
    }
}
