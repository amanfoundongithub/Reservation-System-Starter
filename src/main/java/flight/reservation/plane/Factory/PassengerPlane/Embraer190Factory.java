package flight.reservation.plane.Factory.PassengerPlane;

import flight.reservation.plane.Factory.PlaneFactory;
import flight.reservation.plane.models.Interface.AeroInterface;
import flight.reservation.plane.models.Models.PassengerPlane;

public class Embraer190Factory implements PlaneFactory{

    public Embraer190Factory(){

    }
    @Override
    public AeroInterface createPlane(){
        return new PassengerPlane("Embraer 190", 25, 5);
    }
}
