package flight.reservation.flight.ScheduledFlightFolder.Class;

import flight.reservation.Airport;
import flight.reservation.Passenger;
import flight.reservation.flight.Flight;
import flight.reservation.plane.models.Interface.AeroInterface;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ScheduledFlight extends Flight{

    private final List<Passenger> passengers;
    private final Date departureTime;
    private double currentPrice = 100;

    public ScheduledFlight(int number, Airport departure, Airport arrival,AeroInterface aircraft, Date departureTime) {
        super(number, departure, arrival, aircraft);
        this.departureTime = departureTime;
        this.passengers = new ArrayList<>();
    }

    public ScheduledFlight(int number, Airport departure, Airport arrival,AeroInterface aircraft, Date departureTime, double currentPrice) {
        super(number, departure, arrival, aircraft);
        this.departureTime = departureTime;
        this.passengers = new ArrayList<>();
        this.currentPrice = currentPrice;
    }

    

    public void addPassengers(List<Passenger> passengers) {
        this.passengers.addAll(passengers);
    }

    public void removePassengers(List<Passenger> passengers) {
        this.passengers.removeAll(passengers);
    }
    
    public int getCrewMemberCapacity(){
        return this.aircraft.getCrewMemberCapacity();
    }

    public int getCapacity(){
        return this.aircraft.getPassengerCapacity();
    }

    public int getAvailableCapacity() throws NoSuchFieldException {
        return this.getCapacity() - this.passengers.size();
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }
}
