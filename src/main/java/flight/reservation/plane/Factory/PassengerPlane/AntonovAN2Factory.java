package flight.reservation.plane.Factory.PassengerPlane;

import flight.reservation.plane.Factory.PlaneFactory;
import flight.reservation.plane.models.Interface.AeroInterface;
import flight.reservation.plane.models.Models.PassengerPlane;

public class AntonovAN2Factory implements PlaneFactory{
    
    public AntonovAN2Factory(){

    }
    @Override
    public AeroInterface createPlane(){
        return new PassengerPlane("Antonov AN2", 15, 3);
    }
}
