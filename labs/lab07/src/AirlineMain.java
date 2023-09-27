public class AirlineMain {
    //Use this main to test your code. Uncomment lines as you write the corresponding code.
    //Not all code is tested here, be sure to add your own tests to make sure your code works!
    
    public static void main(String[] args) {
        Passenger p1 = new Passenger("Alice-906-A5");
        Passenger p2 = new Passenger("Barney-906-B5");
        Passenger p3 = new Passenger("Alex-123-C27");
        
        PassengerList passengerList = new PassengerList();
        passengerList.addPassenger(p1);
        passengerList.addPassenger(p2);
        passengerList.addPassenger(p3);
        
        System.out.println(passengerList);
        System.out.println(passengerList.countPassengers(906));

        passengerList.swapSeats(p1, p2);
        System.out.print(passengerList);
    }
}
