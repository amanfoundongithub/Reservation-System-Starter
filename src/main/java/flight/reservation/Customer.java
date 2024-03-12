package flight.reservation;

import flight.reservation.ValidationHandlers.ConcreteHandlers.ValidateCapacity;
import flight.reservation.ValidationHandlers.ConcreteHandlers.ValidateCustomer;
import flight.reservation.ValidationHandlers.ConcreteHandlers.ValidatePassengers;
import flight.reservation.flight.ScheduledFlightFolder.Class.ScheduledFlight;
import flight.reservation.order.FlightOrder;
import flight.reservation.order.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Customer {

    private String email;
    private String name;
    private List<Order> orders;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
        this.orders = new ArrayList<>();
    }

    public FlightOrder createOrder(List<String> passengerNames, List<ScheduledFlight> flights, double price) {
        if (!isOrderValid(passengerNames, flights)) {
            throw new IllegalStateException("Order is not valid");
        }
        FlightOrder order = new FlightOrder(flights);
        order.setCustomer(this);
        order.setPrice(price);
        List<Passenger> passengers = passengerNames
                .stream()
                .map(Passenger::new)
                .collect(Collectors.toList());
        order.setPassengers(passengers);
        order.getScheduledFlights().forEach(scheduledFlight -> scheduledFlight.addPassengers(passengers));
        orders.add(order);
        return order;
    }

    private boolean isOrderValid(List<String> passengerNames, List<ScheduledFlight> flights) {
        ValidateCustomer   customerValidate   = new ValidateCustomer(passengerNames, this.getName());
        ValidatePassengers passengersValidate = new ValidatePassengers(FlightOrder.getNoFlyList(), passengerNames);
        ValidateCapacity   capacityValidate   = new ValidateCapacity(passengerNames, flights);
        
        customerValidate.setNext(passengersValidate);
        passengersValidate.setNext(capacityValidate);

        return customerValidate.handleValidation();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

}
