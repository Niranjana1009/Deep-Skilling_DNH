package AdapterPatternExample;

public class RazorPayAdapter implements PaymentProcessor {

    private RazorPayGateway razorpayGateway;

    public RazorPayAdapter(RazorPayGateway razorpayGateway) {
        this.razorpayGateway = razorpayGateway;
    }

    @Override
    public void processPayment(double amount) {
        razorpayGateway.payAmount(amount);
    }
}
