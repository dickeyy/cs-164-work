public class ProperFraction {
    public int wholeNumber;
    public int numerator;
    public int denominator;

    public ProperFraction(int wholeNumber, int numerator, int denominator) {
        if (denominator == 0) {
            this.wholeNumber = 0;
            this.numerator = 0;
            this.denominator = 1;
        } else {
            this.wholeNumber = wholeNumber;
            this.numerator = numerator;
            this.denominator = denominator;
            simplify(); // Simplify the fraction
        }
    }

    public ProperFraction(String fraction) {
        String[] parts = fraction.split(" ");
        if (parts.length == 1) {
            this.wholeNumber = 0;
            String[] fracParts = parts[0].split("/");
            int num = Integer.parseInt(fracParts[0]);
            int den = Integer.parseInt(fracParts[1]);
            if (den == 0) {
                this.numerator = 0;
                this.denominator = 1;
            } else {
                this.numerator = num;
                this.denominator = den;
                simplify(); // Simplify the fraction
            }
        } else {
            this.wholeNumber = Integer.parseInt(parts[0]);
            String[] fracParts = parts[1].split("/");
            int num = Integer.parseInt(fracParts[0]);
            int den = Integer.parseInt(fracParts[1]);
            if (den == 0) {
                this.wholeNumber = 0; // Set wholeNumber to 0 if denominator is 0
                this.numerator = 0;
                this.denominator = 1;
            } else {
                this.numerator = num;
                this.denominator = den;
                simplify(); // Simplify the fraction
            }
        }
    }

    public ImproperFraction makeImproper() {
        int newNumerator = this.wholeNumber * this.denominator + this.numerator;
        return new ImproperFraction(newNumerator, this.denominator);
    }

    public void simplify() {
        // Find the greatest common factor (GCD) using Euclidean algorithm
        int num = Math.abs(this.numerator);
        int denom = this.denominator;
        int gcd = 1;
        
        while (denom != 0) {
            int temp = denom;
            denom = num % denom;
            num = temp;
        }
    
        gcd = num;
    
        // Divide both numerator and denominator by the GCD to simplify the fraction
        this.numerator /= gcd;
        this.denominator /= gcd;
    
        // Adjust the whole number if necessary
        if (Math.abs(this.numerator) >= this.denominator) {
            int extraWhole = this.numerator / this.denominator;
            this.wholeNumber += extraWhole;
            this.numerator %= this.denominator;
        }
    }

    public String toString() {
        if (wholeNumber == 0) {
            return numerator + "/" + denominator;
        } else {
            return wholeNumber + " " + numerator + "/" + denominator;
        }
    }
}
