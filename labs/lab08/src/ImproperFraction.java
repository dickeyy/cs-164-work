public class ImproperFraction {
    public int numerator;
    public int denominator;

    public ImproperFraction(int numerator, int denominator) {
        // Constructor for ImproperFraction taking numerator and denominator as parameters
        if (denominator == 0) {
            this.numerator = 0;
            this.denominator = 1;
        } else {
            this.numerator = numerator;
            this.denominator = denominator;
        }
    }

    public ImproperFraction(String fraction) {
        // Constructor for ImproperFraction taking a string as a parameter
        String[] parts = fraction.split("/");
        int num = Integer.parseInt(parts[0]);
        int den = Integer.parseInt(parts[1]);

        if (den == 0) {
            this.numerator = 0;
            this.denominator = 1;
        } else {
            this.numerator = num;
            this.denominator = den;
        }
    }

    public ProperFraction makeProper() {
        // Method to convert an ImproperFraction to a ProperFraction
        int whole = this.numerator / this.denominator;
        int newNumerator = this.numerator % this.denominator;
        return new ProperFraction(whole, newNumerator, this.denominator);
    }

    public void simplify() {
        // Method to simplify the fraction
        int gcd = findGCD(this.numerator, this.denominator);
        this.numerator /= gcd;
        this.denominator /= gcd;
    }

    private int findGCD(int a, int b) {
        // Helper method to find the greatest common divisor (GCD)
        if (b == 0) {
            return a;
        }
        return findGCD(b, a % b);
    }

    public String toString() {
        return numerator + "/" + denominator;
    }
}
