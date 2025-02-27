package appDomain;

import shapes.*;
import utilities.ShapeParser;
import java.io.FileNotFoundException;

public class AppDriver {
    public static void main(String[] args) {
        // Step 1: Initialize variables to store command line arguments
        String fileName = "";       // Stores the file name (e.g., shapes1.txt)
        String sortType = "";       // Stores the sort type (e.g., height, base area, volume)
        String sortAlgorithm = "";  // Stores the sorting algorithm (e.g., bubble, quick, merge)
        	
        // Step 2: Parse command line arguments
        for (int i = 0; i < args.length; i++) {
        	String current = args[i].toLowerCase();
            switch (String.valueOf(current.charAt(0))+String.valueOf(current.charAt(1))) {
                case "-f":  // File name argument
                    fileName = current.substring(2);  // Store the next argument as the file name
                    break;
                case "-t":  // Sort type argument
                    sortType = current.substring(2);  // Store the next argument as the sort type                    
                    break;
                case "-s":  // Sorting algorithm argument
                    sortAlgorithm = current.substring(2);  // Store the next argument as the sorting algorithm
                    break;
            }
        }
        
        // Step 3: Validate command line arguments
        if (fileName.isEmpty() || sortType.isEmpty() || sortAlgorithm.isEmpty()) {
            System.err.println("Missing command line arguments. Usage: java -jar Sort.jar -f <file> -t <sortType> -s <sortAlgorithm>");
            return;
        }

        // Step 4: Parse the input file and create shape objects
        try {
            Shape[] shapes = ShapeParser.parseFile(fileName);

            // Step 5: Sort the shapes based on the specified sort type and algorithm
            // (This part will be implemented later)
            switch (sortAlgorithm.toLowerCase()) {
                case "b":  // Bubble Sort
                    // Call Bubble Sort
                    break;
                case "s":  // Selection Sort
                    // Call Selection Sort
                    break;
                case "i":  // Insertion Sort
                    // Call Insertion Sort
                    break;
                case "m":  // Merge Sort
                    // Call Merge Sort
                    break;
                case "q":  // Quick Sort
                    // Call Quick Sort
                    break;
                case "z":  // Custom Sort (e.g., Heap Sort, Radix Sort)
                    // Call Custom Sort
                    break;
                default:
                    System.err.println("Invalid sorting algorithm. Use b, s, i, m, q, or z.");
                    return;
            }

            // Step 6: Display the sorted results and benchmarking data
            // (This part will be implemented later)
            System.out.println("Sorting completed successfully!");

        } catch (FileNotFoundException e) {
            // Handle file not found error
            System.err.println("File not found: " + fileName);
        }
    }
}