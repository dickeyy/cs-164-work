/*
 * Copyright (c) 2020.
 * This work is licensed under the Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License. To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-sa/4.0/ or send a letter to Creative Commons, PO Box 1866, Mountain View, CA 94042, USA.
 */

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This is a slightly more advanced CSV reader that can handle quoted tokens. 
 */
public class CSVReader {
    private static final char DELIMINATOR = ',';
    private Scanner fileScanner;

    /**
     * Basic constructor that assumes the first line should be skipped. 
     * @param file name of file to read
     */
    public CSVReader(String file) {
        this(file, true);
    }

    /**
     * A constructor that requires the name of the file to open
     * @param file filename to read
     * @param skipHeader true to skip header, false if it is to be read
     */
    public CSVReader(String file, boolean skipHeader) {
        try {
            fileScanner = new Scanner(new File(file));
            if(skipHeader) this.getNext();
        }catch (IOException io) {
            System.err.println(io.getMessage());
            System.exit(1);
        }
    }

    /**
     * Reads a line (nextLine()) and splits it into a String array by the DELIMINATOR, if the line is
     * empty it will also return null. This is the proper way to check for CSV files as compared
     * to string.split - as it allows for "quoted" strings ,",",.
     * @return a String List if a line exits or null if not
     */
    public List<String> getNext() {
        if(hasNext()){
            String toSplit = fileScanner.nextLine();
            List<String> result = new ArrayList<>();
            int start = 0;
            boolean inQuotes = false;
            for (int current = 0; current < toSplit.length(); current++) {
                if (toSplit.charAt(current) == '\"') { // the char uses the '', but the \" is a simple "
                    inQuotes = !inQuotes; // toggle state
                }
                boolean atLastChar = (current == toSplit.length() - 1);
                if (atLastChar) {
                    result.add(toSplit.substring(start).replace("\"", "")); // remove the quotes from the quoted item
                } else {
                    if (toSplit.charAt(current) == DELIMINATOR && !inQuotes) {
                        result.add(toSplit.substring(start, current).replace("\"", ""));
                        start = current + 1;
                    }
                }
            }
            return result;
        }
        return null;
    }

    /**
     * Checks to see if the fileScanner has more lines and returns the answer. 
     * @return true if the file scanner has more lines (hasNext())
     */
    public boolean hasNext() {
        return (fileScanner != null) && fileScanner.hasNext();
    }



}
