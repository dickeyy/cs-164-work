import java.util.ArrayList;
import java.util.List;


/**
 *  A simple container that holds a set of Data, by row/col (matrix)
 *  @version 20200627
 */
public class DataSet {
    private final List<List<Double>> data = new ArrayList<>();

    /**
     * Reads the file, assuming it is a CSV file
     * @param fileName name of file
     */
    public DataSet(String fileName) {
        this(new CSVReader(fileName, false));
    }

    /**
     * Takes in a CSVReader to load the dataset
     * @param csvReader a csvReader 
     */
    public DataSet(CSVReader csvReader) {
        loadData(csvReader);
    }

    /**
     * Returns the number of rows in the data set
     * @return number of rows
     */
    public int rowCount() {
        return data.size();
    }

    /**
     * Gets a specific row based on the index. Throws exception if out of bounds
     * @param i the index of the row
     * @return the row as a List of doubles
     */
    public List<Double> getRow(int i) {
        return data.get(i);
    }

    /**
     * Loads the data from th CSV file
     * @param file a CSVReader
     */
    private void loadData(CSVReader file) {
        while(file.hasNext()) {
            List<Double> dbl = convertToDouble(file.getNext());
            if(dbl.size()> 0) {
                data.add(dbl);
            }
        }
    }

    /**
     * Converts a List of strings to a list of doubles. Ignores non-doubles in the list
     * @param next a List of strings
     * @return a List of doubles
     */
    private List<Double> convertToDouble(List<String> next) {
        List<Double> dblList = new ArrayList<>(next.size());
        for(String item : next) {
            try {
                dblList.add(Double.parseDouble(item));
            }catch (NumberFormatException ex) {
                System.err.println("Number format!");
            }
        }
        return dblList;
    }


    /**
     * Simple way to view the data
     * @return a String of the 
     */
    @Override
    public String toString() {
        return data.toString();
    }
}
