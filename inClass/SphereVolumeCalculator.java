package inClass;

public class SphereVolumeCalculator {
    public static void main(String[] args) {
        double radius = 5.0;
        double volume = 4.0 / 3.0 * Math.PI * Math.pow(radius, 3);
        System.out.println("The volume of a sphere with radius " + radius + " is " + volume);
    }
}
