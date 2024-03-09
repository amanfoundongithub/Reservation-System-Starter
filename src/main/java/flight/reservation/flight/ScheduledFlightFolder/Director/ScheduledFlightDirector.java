package flight.reservation.flight.ScheduledFlightFolder.Director;

import java.util.Date;

import flight.reservation.flight.ScheduledFlightFolder.Builder.ScheduledFlightBuilder;

public class ScheduledFlightDirector {
    private ScheduledFlightBuilder builder; 

    public ScheduledFlightDirector(ScheduledFlightBuilder builder){
        this.builder = builder;
    }

    public void changeBuilder(ScheduledFlightBuilder builder){
        this.builder = builder;
    }

    public void makeScheduledFlightBasePrice(Date departurDate){
        builder.buildDeparture(departurDate);
    }

    public void makeScheduledFlight(Date departurDate, double cost){
        builder.buildDeparture(departurDate);
        builder.buildCurrentPrice(cost);
    }
    
}
