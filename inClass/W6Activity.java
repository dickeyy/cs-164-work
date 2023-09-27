import java.util.ArrayList;
import java.util.Scanner;

public class W6Activity {
    private ArrayList<Double> lst;
    private int capacity;

    public W6Activity(int capacity) {
        if (capacity < 10) capacity = 10;
        this.capacity = capacity;
        lst = new ArrayList<Double>(capacity);
    }

    public boolean readAndAdd(Scanner in) {
        System.out.println("Enter the quantity of numbers to read");
        int quantity = in.nextInt();
        if (quantity < (lst.size() + capacity)) {
            for (int i = 0; i < quantity; i++) {
                System.out.println("Enter a dobule");
                double num = in.nextDouble();
                lst.add(num);
            }
            return true;
        }
        return false;
    }

    public int size() {
        return lst.size();
    }

    public int getCapacity() {
        return capacity;
    }

    public String toString() {
        String msg = "";
        for (Double element: lst) {
            msg += element + " ";
        }
        msg += "\n";
        return msg;
    }

    public int maximum() {
        int max = 0;
        for (int i = 0; i < lst.size(); i++) {
            if (lst.get(i) > lst.get(max)) {
                max = i;
            }
        }
        return max;
    }

    

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        W6Activity w6 = new W6Activity(4);
        System.out.println(w6.size());
        System.out.println(w6.getCapacity());
        if (w6.readAndAdd(in)) {
            System.out.println("Number added");
        } else {
            System.out.println("Not possible to add more numbers");
        }
        System.out.println(w6.size());
        System.out.println(w6.getCapacity());
        System.out.println(w6.toString());
    }
}
