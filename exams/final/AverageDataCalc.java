import java.util.List;

public class AverageDataCalc extends AbstractDataCalc {

    public AverageDataCalc(DataSet set) {
        super(set);
    }

    @Override
    public String getType() {
        return "AVERAGE";
    }

    @Override
    public double calcLine(List<Double> line) {
        double sum = 0;
        for (Double value : line) {
            sum += value;
        }
        return sum / line.size();
    }
}
