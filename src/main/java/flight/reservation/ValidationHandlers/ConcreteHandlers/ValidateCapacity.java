package flight.reservation.ValidationHandlers.ConcreteHandlers;

import java.util.List;

import flight.reservation.ValidationHandlers.Interface.ValidationInterface;
import flight.reservation.flight.ScheduledFlightFolder.Class.ScheduledFlight;

public class ValidateCapacity implements ValidationInterface{
    private boolean valid = true; 
    private List<String> passengerNames;
    private List<ScheduledFlight> flights;

    private ValidationInterface next = null;
    

    public ValidateCapacity(List<String> passengerNames, List<ScheduledFlight> flights){
        this.passengerNames = passengerNames;
        this.flights = flights;
    }

    public ValidateCapacity(List<String> passengerNames,List<ScheduledFlight> flights, boolean valid){
        this.passengerNames = passengerNames;
        this.flights = flights;
        this.valid = valid;
    }

    @Override
    public void setNext(ValidationInterface handler){
        this.next = handler;
    }

    @Override 
    public boolean handleValidation(){
        boolean val = flights.stream().allMatch(scheduledFlight -> {
            try {
                return scheduledFlight.getAvailableCapacity() >= passengerNames.size();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
                return false;
            }
        });

        val = val && this.valid;
        if(this.next == null){
            return val;
        }
        else{ 
            return val && next.handleValidation();
        }
    }
}
