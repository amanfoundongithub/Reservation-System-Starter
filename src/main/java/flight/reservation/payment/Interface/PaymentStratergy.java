package flight.reservation.payment.Interface;

public interface PaymentStratergy {
    
    public boolean processPayment(double requested_amount) throws IllegalStateException;
    
}
