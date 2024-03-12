package flight.reservation.order;

import flight.reservation.Customer;
import flight.reservation.ValidationHandlers.ConcreteHandlers.ValidateCapacity;
import flight.reservation.ValidationHandlers.ConcreteHandlers.ValidateCustomer;
import flight.reservation.ValidationHandlers.ConcreteHandlers.ValidatePassengers;
import flight.reservation.flight.ScheduledFlightFolder.Class.ScheduledFlight;
import flight.reservation.payment.Context.PaymentSelector;
import flight.reservation.payment.Interface.PaymentStratergy;
import flight.reservation.payment.Models.CreditCard;
import flight.reservation.payment.Models.Paypal;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class FlightOrder extends Order {
    private final List<ScheduledFlight> flights;
    static List<String> noFlyList = Arrays.asList("Peter", "Johannes");

    private PaymentSelector paymentSelector = new PaymentSelector();

    public FlightOrder(List<ScheduledFlight> flights) {
        this.flights = flights;
    }

    public static List<String> getNoFlyList() {
        return noFlyList;
    }

    public List<ScheduledFlight> getScheduledFlights() {
        return flights;
    }

    private boolean isOrderValid(Customer customer, List<String> passengerNames, List<ScheduledFlight> flights) {

        ValidateCustomer   customerValidate   = new ValidateCustomer(passengerNames, customer.getName());
        ValidatePassengers passengersValidate = new ValidatePassengers(noFlyList, passengerNames);
        ValidateCapacity   capacityValidate   = new ValidateCapacity(passengerNames, flights);
        
        customerValidate.setNext(passengersValidate);
        passengersValidate.setNext(capacityValidate);

        return customerValidate.handleValidation();
    }


    public boolean processOrderWithCreditCard(String number, Date expirationDate, String cvv) throws IllegalStateException {
        CreditCard creditCard = new CreditCard(number, expirationDate, cvv);
        return processPayment(creditCard);
    }

    public boolean processOrderWithPayPal(String email,String password) throws IllegalStateException {
        Paypal payPal = new Paypal(email, password);
        return processPayment(payPal);
    }

    public boolean processPayment(PaymentStratergy paymentStratergy) throws IllegalStateException{
        if (isClosed()) {
            return true;
        }
        
        paymentSelector.setPaymentMethod(paymentStratergy);
        boolean isPaid = paymentSelector.pay(getPrice());

        if(isPaid){
            this.setClosed();
        }
        return isPaid;
    }

}
