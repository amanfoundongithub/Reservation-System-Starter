package flight.reservation.ValidationHandlers.ConcreteHandlers;

import java.util.List;

import flight.reservation.ValidationHandlers.Interface.ValidationInterface;

public class ValidateCustomer implements ValidationInterface{
    
    private boolean valid = true; 
    private List<String> noFlyList;
    private String customerName;

    private ValidationInterface next = null;
    

    public ValidateCustomer(List<String> noFlyList, String customerName){
        this.noFlyList = noFlyList;
        this.customerName = customerName;
    }

    public ValidateCustomer(List<String> noFlyList, String customerName, boolean valid){
        this.noFlyList = noFlyList;
        this.customerName = customerName;
        this.valid = valid;
    }

    @Override
    public void setNext(ValidationInterface handler){
        this.next = handler;
    }

    @Override 
    public boolean handleValidation(){
        boolean val = this.noFlyList.contains(customerName);
        val = !val && this.valid;
        if(this.next == null){
            return val;
        }
        else{ 
            return val && next.handleValidation();
        }
    }

}
