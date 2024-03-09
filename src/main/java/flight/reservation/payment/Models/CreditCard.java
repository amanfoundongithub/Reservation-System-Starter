package flight.reservation.payment.Models;

import java.util.Date;

import flight.reservation.payment.Interface.PaymentStratergy;

/**
 * Dummy credit card class.
 */
public class CreditCard implements PaymentStratergy{
    private double amount;
    private String number;
    private Date date;
    private String cvv;
    private boolean valid;

    public CreditCard(String number, Date date, String cvv) {
        this.amount = 100000;
        this.number = number;
        this.date = date;
        this.cvv = cvv;
        this.setValid();
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid() {
        // Dummy validation
        this.valid = number.length() > 0 && date.getTime() > System.currentTimeMillis() && !cvv.equals("000");
    }

    @Override 
    public boolean processPayment(double requested_amount) throws IllegalStateException {
        if(isValid()){
            System.out.println("Paying " + requested_amount + " using Credit Card.");

            double remainingAmount = this.amount - requested_amount;
            if (remainingAmount < 0) {
                System.out.printf("Card limit reached - Balance: %f%n", remainingAmount);
                throw new IllegalStateException("Card limit reached");
            }
            this.setAmount(remainingAmount);
            return true;
        }
        else{
            throw new IllegalStateException("Payment information is not valid.");
        }
    }
}