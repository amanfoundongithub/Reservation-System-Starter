package flight.reservation.flight.ScheduledFlightFolder.Builder;

import java.util.Date;

import flight.reservation.flight.Flight;
import flight.reservation.flight.ScheduledFlightFolder.Class.ScheduledFlight;

public class ScheduledFlightBuilder {
    private ScheduledFlight scheduledFlight;
    
    public ScheduledFlightBuilder(Flight flight) {
        scheduledFlight = new ScheduledFlight(flight);
    }

    public void buildDeparture(Date departureTime){
        scheduledFlight.setDepartureTime(departureTime); 
    }

    public void buildCurrentPrice(double currentPrice){
        scheduledFlight.setCurrentPrice(currentPrice);
    }

    public ScheduledFlight build() {
        return scheduledFlight;    
    }
}
   


