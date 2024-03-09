package flight.reservation.plane.Factory;

import flight.reservation.plane.models.Interface.AeroInterface;

public interface PlaneFactory {

    public AeroInterface createPlane(); 
    
}
