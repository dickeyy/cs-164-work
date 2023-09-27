public class Passenger {
    private String name;
    private int flightNumber;
    private String seat;

    // passengerLine will be in the format "name-flightNumber-seat"
    public Passenger(String passengerLine){
        int firstHyphenIndex = passengerLine.indexOf("-");
        int secondHyphenIndex = passengerLine.indexOf("-", firstHyphenIndex+1);
        name = passengerLine.substring(0, firstHyphenIndex);
        flightNumber = Integer.parseInt(passengerLine.substring(firstHyphenIndex+1,secondHyphenIndex));
        seat = passengerLine.substring(secondHyphenIndex + 1);
    }

    public String getName(){
        return name;
    }

    public int getFlightNumber(){
        return flightNumber;
    }

    public String getSeat(){
        return seat;
    }

    public void setSeat(String newSeat){
        this.seat = newSeat;
    }

    public String toString(){
        return String.format("%s on flight #%d in seat %s", name, flightNumber, seat);
    }
}
