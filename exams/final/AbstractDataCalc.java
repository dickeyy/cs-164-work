import java.util.List;

public abstract class AbstractDataCalc {
    protected DataSet dataSet;

    public AbstractDataCalc(DataSet set) {
        setAndRun(set);
    }

    public void setAndRun(DataSet set) {
        this.dataSet = set;
        if (set != null) {
            runCalculations();
        }
    }

    private void runCalculations() {
        // Build an array (or list) of doubles with results from calcLine
        // Implementation depends on the subclass
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Dataset Results (Method: " + getType() + ")\n");
        for (int i = 0; i < dataSet.rowCount(); i++) {
            double roundedResult = roundToDecimal(getResultForLine(i), 1);
            result.append("Row ").append(i + 1).append(": ").append(roundedResult).append("\n");
        }
        return result.toString();
    }

    protected abstract String getType();

    protected abstract double calcLine(List<Double> line);

    private double getResultForLine(int row) {
        List<Double> line = dataSet.getRow(row);
        return calcLine(line);
    }

    private double roundToDecimal(double value, int decimalPlaces) {
        // Use String.format to round to specified decimal places
        String format = "%." + decimalPlaces + "f";
        return Double.parseDouble(String.format(format, value));
    }
}
