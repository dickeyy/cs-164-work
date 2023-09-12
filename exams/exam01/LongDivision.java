package exams.exam01;

public class LongDivision {
    private int quotient;  // leave as is, only instance variables you need
    private int remainder;

    public void setQuotient(int quotient) {
        this.quotient = quotient;
    }

    public int getQuotient() {
        return this.quotient;
    }

    public void setRemainder(int remainder) {
        this.remainder = remainder;
    }

    public int getRemainder() {
        return this.remainder;
    }

    public String getFormattedString() {
        // this is the format we want
        // {quotient: val1, remainder: val2}
        
        String result = "{quotient: " + this.quotient + ", remainder: " + this.remainder + "}";
        return result;
    }

    /// static methods
    public static LongDivision buildLongDivision(int value1, int value2) {
        LongDivision division = new LongDivision();
        division.setQuotient(value1 / value2);
        division.setRemainder(value1 % value2);
        return division;
    }
}

