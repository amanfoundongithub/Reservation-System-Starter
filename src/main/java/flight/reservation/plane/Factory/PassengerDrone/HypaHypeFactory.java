package flight.reservation.plane.Factory.PassengerDrone;

import flight.reservation.plane.Factory.PlaneFactory;
import flight.reservation.plane.models.Interface.AeroInterface;
import flight.reservation.plane.models.Models.PassengerDrone;

public class HypaHypeFactory implements PlaneFactory{
    
    public HypaHypeFactory(){

    }

    @Override
    public AeroInterface createPlane(){
        return new PassengerDrone("HypaHype");
    }
}
