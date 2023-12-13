import java.util.List;

public class MinimumDataCalc extends AbstractDataCalc {

    public MinimumDataCalc(DataSet set) {
        super(set);
    }

    @Override
    public String getType() {
        return "MIN";
    }

    @Override
    public double calcLine(List<Double> line) {
        double min = Double.MAX_VALUE;
        for (Double value : line) {
            min = Math.min(min, value);
        }
        return min;
    }
}
