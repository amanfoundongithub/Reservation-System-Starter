package flight.reservation.plane.models.Models;

import flight.reservation.plane.models.Interface.AeroInterface;

public class PassengerPlane implements AeroInterface{
    
    private final String model; 
    private final int passengerCapacity; 
    private final int crewCapacity;

    // Constructor 
    public PassengerPlane(String model, int passengerCapacity, int crewCapacity){
        this.model = model; 
        this.passengerCapacity = passengerCapacity;
        this.crewCapacity = crewCapacity;
    }

    @Override
    public String getModel(){
        return this.model;
    }

    @Override
    public int getPassengerCapacity(){
        return this.passengerCapacity;
    }
    
    @Override 
    public int getCrewMemberCapacity(){
        return this.crewCapacity;
    }
}
