import java.util.List;

public class MaximumDataCalc extends AbstractDataCalc {

    public MaximumDataCalc(DataSet set) {
        super(set);
    }

    @Override
    public String getType() {
        return "MAX";
    }

    @Override
    public double calcLine(List<Double> line) {
        double max = Double.MIN_VALUE;
        for (Double value : line) {
            max = Math.max(max, value);
        }
        return max;
    }
}
