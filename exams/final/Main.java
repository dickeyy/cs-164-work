/*
 * Copyright (c) 2020. 
 * This work is licensed under the Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License. To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-sa/4.0/ or send a letter to Creative Commons, PO Box 1866, Mountain View, CA 94042, USA.
 */

/**
 * @author Albert Lionelle <br>
 *         lionelle@colostate.edu <br>
 *         Computer Science Department <br>
 *         Colorado State University
 * @version 20200624
 */

public class Main {

    public static void main(String[] args) {
        String testFile = "./exams/final/sample.csv";
        DataSet set = new DataSet(testFile);
        AverageDataCalc averages = new AverageDataCalc(set);
        System.out.println(averages);
        MinimumDataCalc minimum = new MinimumDataCalc(set);
        System.out.println(minimum);
        MaximumDataCalc max = new MaximumDataCalc(set);
        System.out.println(max);
    }

}
