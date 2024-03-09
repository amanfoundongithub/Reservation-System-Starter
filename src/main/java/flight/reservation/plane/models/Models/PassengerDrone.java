package flight.reservation.plane.models.Models;

import flight.reservation.plane.models.Interface.AeroInterface;

public class PassengerDrone implements AeroInterface{
    
    private String model;

    public PassengerDrone(String model){
        this.model = model;
    }

    @Override
    public String getModel(){
        return this.model;
    }

    @Override
    public int getPassengerCapacity(){
        return 0;
    }
    
    @Override 
    public int getCrewMemberCapacity(){
        return 0;
    }
}
