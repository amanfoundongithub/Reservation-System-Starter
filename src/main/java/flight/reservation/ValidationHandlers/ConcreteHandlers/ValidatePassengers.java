package flight.reservation.ValidationHandlers.ConcreteHandlers;

import java.util.List;

import flight.reservation.ValidationHandlers.Interface.ValidationInterface;

public class ValidatePassengers implements ValidationInterface{
    
    private boolean valid = true; 
    private List<String> noFlyList;
    private List<String> customerName;

    private ValidationInterface next = null;
    

    public ValidatePassengers(List<String> noFlyList, List<String> passengerNames){
        this.noFlyList = noFlyList;
        this.customerName = passengerNames;
    }

    public ValidatePassengers(List<String> noFlyList, List<String> passengerNames, boolean valid){
        this.noFlyList = noFlyList;
        this.customerName = passengerNames;
        this.valid = valid;
    }

    @Override
    public void setNext(ValidationInterface handler){
        this.next = handler;
    }

    @Override 
    public boolean handleValidation(){
        boolean val = this.customerName.stream().noneMatch(passenger -> noFlyList.contains(passenger));
        val = val && this.valid;
        if(this.next == null){
            return val;
        }
        else{ 
            return val && next.handleValidation();
        }
    }
}
