package flight.reservation.plane.Factory.PassengerPlane;

import flight.reservation.plane.Factory.PlaneFactory;
import flight.reservation.plane.models.Interface.AeroInterface;
import flight.reservation.plane.models.Models.PassengerPlane;

public class A380Factory implements PlaneFactory{

    public A380Factory(){

    }
    @Override
    public AeroInterface createPlane(){
        return new PassengerPlane("A380", 500, 42);
    }
    
}
