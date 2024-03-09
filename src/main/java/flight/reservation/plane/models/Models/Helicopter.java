package flight.reservation.plane.models.Models;

import flight.reservation.plane.models.Interface.AeroInterface;

public class Helicopter implements AeroInterface{
    private final String model; 
    private final int passengerCapacity;

    public Helicopter(String model, int passengerCapacity){
        this.model = model;
        this.passengerCapacity = passengerCapacity;
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
        return 2;
    }
}
