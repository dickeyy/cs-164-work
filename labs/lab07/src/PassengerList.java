import java.util.ArrayList;

public class PassengerList {
    private ArrayList<Passenger> passengers;

    /**
    * Creates and ArrayList of Passenger
    */
    
    public PassengerList(){
        passengers = new ArrayList<Passenger>();
    }

    /**
     * 
     * @return passengers an ArrayList of passengers
     */
    public ArrayList<Passenger> getPassengers(){
        return passengers;
    }

    /**
     * Adds a passenger to the passengers ArrayList
     * @param passenger a Passenger object to add
     */
    public void addPassenger(Passenger passenger){
        passengers.add(passenger);
    }

    /* 
     * Explanation:
     * The method is currently iterating through the passengers ArrayList and checking if the passenger's name matches the nameToRemove.
     * If the name does match, the passenger is removed from the ArrayList.
     * if not, nothing happens.
    */


    public void removePassenger(String nameToRemove){

        for (Passenger passenger : passengers) {
            if (passenger.getName().equals(nameToRemove)) {
                passengers.remove(passenger);
            }
        }
    }

    /**
     * toString will convert the ArrayList of passengers to a String. The .toString() method in Passenger.java
     * will be helpful. Be sure to end each line with a new line character ("/n").
     * @return strList a String containing all passengers
     */
    public String toString(){
        String strList = "";

        for (Passenger passenger : passengers) {
            strList += passenger.toString() + "\n";
        }
        
        return strList;
    }

    /**
     * This method will count the number of passengers on a given flight. Check each passenger to see if
     * they are on the flight, then add to the count.
     * 
     * @param flightNumber the flightNumber to find passengers for
     * @return count the number of passengers on the flight
     */
    public int countPassengers(int flightNumber){
        int count = 0;
        for (Passenger passenger : passengers) {
            if (passenger.getFlightNumber() == flightNumber) {
                count++;
            }
        }
        return count;
    }

    /**
     * This method will swap the seats of the two passengers. Passenger's .setSeat() and .getSeat() will
     * be useful.
     * 
     * @param passengerOne the passenger to assign to passengerTwo's seat
     * @param passengerTwo the passenger to assign to passengerOne's seat
     */
    public void swapSeats(Passenger passengerOne, Passenger passengerTwo){
        
        String tempSeat = passengerOne.getSeat();
        passengerOne.setSeat(passengerTwo.getSeat());
        passengerTwo.setSeat(tempSeat);
        
    }
}
