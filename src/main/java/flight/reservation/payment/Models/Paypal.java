package flight.reservation.payment.Models;

import java.util.HashMap;
import java.util.Map;

import flight.reservation.payment.Interface.PaymentStratergy;

public class Paypal implements PaymentStratergy{
    public static final Map<String, String> DATA_BASE = new HashMap<>();

    static {
        DATA_BASE.put("amanda1985", "amanda@ya.com");
        DATA_BASE.put("qwerty", "john@amazon.eu");
    }

    private String email;
    private String password;
    public Paypal(String email, String password){
        
        this.email = email;
        this.password = password;
    }

    @Override 
    public boolean processPayment(double requested_amount) throws IllegalStateException{
        if (email == null || password == null || !email.equals(Paypal.DATA_BASE.get(password))) {
            throw new IllegalStateException("Payment information is not set or not valid.");
        }
        if(email.equals(DATA_BASE.get(password))){
            System.out.println("Paying " + requested_amount + " using PayPal.");
            return true;
        }
        else{ 
            return false;
        }
    }

}
