import flight.reservation.Airport;
import flight.reservation.flight.Schedule;
import flight.reservation.flight.Flight;
import flight.reservation.plane.Factory.Helicopter.H1Factory;
import flight.reservation.plane.Factory.Helicopter.H2Factory;
import flight.reservation.plane.Factory.PassengerDrone.HypaHypeFactory;
import flight.reservation.plane.Factory.PassengerPlane.A350Factory;
import flight.reservation.plane.Factory.PassengerPlane.A380Factory;
import flight.reservation.plane.Factory.PassengerPlane.Embraer190Factory;
import flight.reservation.plane.models.Interface.AeroInterface;

import java.util.Arrays;
import java.util.List;

public class Runner {
    static List<Airport> airports = Arrays.asList(
            new Airport("Berlin Airport", "BER", "Berlin, Berlin"),
            new Airport("Frankfurt Airport", "FRA", "Frankfurt, Hesse"),
            new Airport("Madrid Barajas Airport", "MAD", "Barajas, Madrid"),
            new Airport("Guarulhos International Airport", "GRU", "Guarulhos (São Paulo)"),
            new Airport("John F. Kennedy International Airport", "JFK", "Queens, New York, New York"),
            new Airport("Istanbul Airport", "IST", "Arnavutköy, Istanbul"),
            new Airport("Dubai International Airport", "DXB", "Garhoud, Dubai"),
            new Airport("Chengdu Shuangliu International Airport", "CTU", "Shuangliu-Wuhou, Chengdu, Sichuan")
    );

    static List<AeroInterface> aircrafts = Arrays.asList(
            (new A380Factory()).createPlane(),
            (new A350Factory()).createPlane(),
            (new Embraer190Factory()).createPlane(),
            (new H2Factory()).createPlane(),
            (new H1Factory()).createPlane(),
            (new HypaHypeFactory()).createPlane()
    );

    static List<Flight> flights = Arrays.asList(
            new Flight(1, airports.get(0), airports.get(1), aircrafts.get(0)),
            new Flight(2, airports.get(1), airports.get(2), aircrafts.get(1)),
            new Flight(3, airports.get(2), airports.get(4), aircrafts.get(2)),
            new Flight(4, airports.get(3), airports.get(2), aircrafts.get(3)),
            new Flight(5, airports.get(4), airports.get(2), aircrafts.get(4)),
            new Flight(6, airports.get(5), airports.get(7), aircrafts.get(5))
    );

    static Schedule schedule;

    public static void main(String[] args) {
    }
}
