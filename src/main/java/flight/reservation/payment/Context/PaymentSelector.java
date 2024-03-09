package flight.reservation.payment.Context;

import flight.reservation.payment.Interface.PaymentStratergy;

public class PaymentSelector {
    
    private PaymentStratergy stratergy;

    public PaymentSelector(){
        this.stratergy = null;
    }

    public void setPaymentMethod(PaymentStratergy stratergy){
        this.stratergy = stratergy;
    }

    public boolean pay(double requested_amount) throws IllegalStateException{
        if(stratergy== null){
            throw new IllegalStateException("No Parameter was passed...");
        }
        return stratergy.processPayment(requested_amount); 
    }
}
