package flight.reservation.plane.Factory.PassengerPlane;

import flight.reservation.plane.Factory.PlaneFactory;
import flight.reservation.plane.models.Interface.AeroInterface;
import flight.reservation.plane.models.Models.PassengerPlane;

public class A350Factory implements PlaneFactory{
    
    public A350Factory(){

    }
    @Override
    public AeroInterface createPlane(){
        return new PassengerPlane("A350", 320, 40);
    }
}
