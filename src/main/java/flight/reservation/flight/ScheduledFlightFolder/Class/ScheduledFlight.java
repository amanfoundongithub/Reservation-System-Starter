package flight.reservation.flight.ScheduledFlightFolder.Class;

import flight.reservation.Passenger;
import flight.reservation.flight.Flight;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ScheduledFlight extends Flight{

    private List<Passenger> passengers = new ArrayList<>();
    private Date departureTime;
    private double currentPrice = 100;

    public ScheduledFlight(Flight flight){
        super(flight.getNumber(), 
              flight.getDeparture(), 
              flight.getArrival(), 
              flight.getAircraft());
    }

    public void setDepartureTime(Date departurDate){
        this.departureTime = departurDate;
    }

    public void setPrice(double price){
        this.currentPrice = price;
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
