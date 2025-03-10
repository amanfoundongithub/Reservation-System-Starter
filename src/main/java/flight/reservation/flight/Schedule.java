package flight.reservation.flight;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import flight.reservation.flight.ScheduledFlightFolder.Builder.ScheduledFlightBuilder;
import flight.reservation.flight.ScheduledFlightFolder.Class.ScheduledFlight;
import flight.reservation.flight.ScheduledFlightFolder.Director.ScheduledFlightDirector;


public class Schedule {

    private List<ScheduledFlight> scheduledFlights;


    public Schedule() {
        scheduledFlights = new ArrayList<>();
    }

    public List<ScheduledFlight> getScheduledFlights() {
        return scheduledFlights;
    }

    public void scheduleFlight(Flight flight, Date date) {
        // Call factory 
        ScheduledFlightBuilder builder = new ScheduledFlightBuilder(flight);
        ScheduledFlightDirector director = new ScheduledFlightDirector(builder);
        director.makeScheduledFlightWithoutPrice(date);

        // Call for the scheduled flight 
        ScheduledFlight scheduledFlight = builder.build();

        // Add to the flights 
        scheduledFlights.add(scheduledFlight);
    }

    public void removeFlight(Flight flight) {
        List<ScheduledFlight> tbr = new ArrayList<>();
        for (ScheduledFlight scheduledFlight : scheduledFlights) {
            if (scheduledFlight == flight ||
                    (flight.getArrival() == scheduledFlight.getArrival() &&
                            flight.getDeparture() == scheduledFlight.getDeparture() &&
                            flight.getNumber() == scheduledFlight.getNumber())) {
                tbr.add(scheduledFlight);
            }
        }
        scheduledFlights.removeAll(tbr);
    }

    public void removeScheduledFlight(ScheduledFlight flight) {
        scheduledFlights.remove(flight);
    }

    public ScheduledFlight searchScheduledFlight(int flightNumber) {
        return scheduledFlights.stream()
                .filter(f -> f.getNumber() == flightNumber)
                .findFirst()
                .orElse(null);
    }

    public void clear() {
        scheduledFlights.clear();
    }
}
