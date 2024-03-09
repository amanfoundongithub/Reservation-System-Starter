package flight.reservation.plane.Factory.Helicopter;

import flight.reservation.plane.Factory.PlaneFactory;
import flight.reservation.plane.models.Interface.AeroInterface;
import flight.reservation.plane.models.Models.Helicopter;

public class H2Factory implements PlaneFactory{
    
    public H2Factory(){

    }

    @Override
    public AeroInterface createPlane(){
        return new Helicopter("H2", 6);
    }
}
