package flight.reservation.flight.ScheduledFlightFolder.Builder;

import java.util.Date;

import flight.reservation.Airport;
import flight.reservation.flight.Flight;
import flight.reservation.flight.ScheduledFlightFolder.Class.ScheduledFlight;
import flight.reservation.plane.models.Interface.AeroInterface;

public class ScheduledFlightBuilder {
    private final int number;
    private final Airport departure;
    private final Airport arrival;
    private final AeroInterface aircraft;
    private Date departureTime;
    private double currentPrice = 100;

    public ScheduledFlightBuilder(Flight flight) {
        this.number = flight.getNumber();
        this.departure = flight.getDeparture();
        this.arrival = flight.getArrival();
        this.aircraft = flight.getAircraft();
        this.departureTime = null;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public ScheduledFlight build() {
        if (departureTime == null) {
            throw new IllegalStateException("Departure time is required");
        }
        
        return new ScheduledFlight(number, departure,arrival, aircraft, departureTime, currentPrice);    
 }
}
   


