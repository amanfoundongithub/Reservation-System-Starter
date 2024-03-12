package flight.reservation.ValidationHandlers.Interface;

public interface ValidationInterface {

    public void setNext(ValidationInterface handler);

    public boolean handleValidation();
    
}
