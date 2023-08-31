import java.util.Scanner;

public class SeatCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the total seats *per row* ");
        double rowSize = scanner.nextDouble();

        System.out.print("Enter a seat number");
        double seatNumber = scanner.nextDouble();

        double row = Math.ceil(seatNumber / rowSize);
        double seat = seatNumber % rowSize;

        System.out.println("Row: " + row);
        System.out.println("Seat: " + seat);

        scanner.close();
    }
}
