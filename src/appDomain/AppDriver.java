package appDomain;

import utilities.SortingAlgorithms;
import shapes.*;
import utilities.ShapeParser;
import java.io.FileNotFoundException;
import java.util.Comparator;

public class AppDriver {
    public static void main(String[] args) {
        // Step 1: Initialize variables to store command line arguments
        String fileName = "";       // Stores the file name (e.g., shapes1.txt)
        String sortType = "";       // Stores the sort type (e.g., height, base area, volume)
        String sortAlgorithm = "";  // Stores the sorting algorithm (e.g., bubble, quick, merge)
        String sortTypeValue = "";
        String sortAlgorithmValue ="";

        // Step 2: Parse command line arguments
        for (int i = 0; i < args.length; i++) {
        	String current = args[i].toLowerCase();
            switch (String.valueOf(current.charAt(0))+String.valueOf(current.charAt(1))) {
                case "-f":  // File name argument
                    if (i + 1 < args.length) {
                        fileName = args[i].substring(2);  // Store the next argument as the file name
                    } else {
                        System.err.println("Missing file name after -f");
                        return;
                    }
                    break;
                case "-t":  // Sort type argument
                    if (i + 1 < args.length) {
                        sortType = args[i].substring(2);  // Store the next argument as the sort type
                    } else {
                        System.err.println("Missing sort type after -t");
                        return;
                    }
                    break;
                case "-s":  // Sorting algorithm argument
                    if (i + 1 < args.length+1) {
                        sortAlgorithm = args[i].substring(2);  // Store the next argument as the sorting algorithm
                    } else {
                        System.err.println("Missing sorting algorithm after -s");
                        return;
                    }
                    break;
                default:
                    System.err.println("Unknown argument: " + args[i]);
                    return;
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

            // Step 5: Determine the comparator based on the sort type
            Comparator<Shape> comparator;
            switch (sortType.toLowerCase()) {
                case "h":
                    comparator = Comparator.comparingDouble(Shape::getHeight);
                    sortTypeValue = "Height";
                    break;
                case "a":
                    comparator = Comparator.comparingDouble(Shape::getBaseArea);
                    sortTypeValue = "BaseArea";
                    break;
                case "v":
                    comparator = Comparator.comparingDouble(Shape::getVolume);
                    sortTypeValue = "Volume";
                    break;
                default:
                    System.err.println("Invalid sort type. Use h, a, or v.");
                    return;
            }
 

            // Step 6: Sort the shapes based on the specified sort type and algorithm
//            SortingAlgorithms sortingAlgorithms = new SortingAlgorithms();
            long startTime = System.currentTimeMillis();
            switch (sortAlgorithm.toLowerCase()) {
                case "b":  // Bubble Sort
                    SortingAlgorithms.bubbleSort(shapes, comparator);
                    sortAlgorithmValue = "Bubble Sort";
                    break;
                case "s":  // Selection Sort
                    SortingAlgorithms.selectionSort(shapes, comparator);
                    sortAlgorithmValue = "Selection Sort";
                    break;
                case "i":  // Insertion Sort
                    SortingAlgorithms.insertionSort(shapes, comparator);
                    sortAlgorithmValue = "Insertion Sort";
                    break;
                case "m":  // Merge Sort
                    // Call Merge Sort
                    SortingAlgorithms.mergeSort(shapes, comparator);
                    sortAlgorithmValue = "Merge Sort";
                    break;
                case "q":  // Quick Sort
                	SortingAlgorithms.quickSort(shapes, comparator);
                	sortAlgorithmValue = "Quick Sort";
                    // Call Quick Sort
                    break;
                case "z":  // Custom Sort (e.g., Heap Sort, Radix Sort)
                    // Call Custom Sort
                    SortingAlgorithms.heapSort(shapes, comparator);
                    sortAlgorithmValue = "Custom Sort(Heap Sort)";
                    break;
                default:
                    System.err.println("Invalid sorting algorithm. Use b, s, i, m, q, or z.");
                    return;
            }
            
         // Debug statements to check parsed arguments
            System.out.println("File name: " + fileName);
            System.out.println("Sort type: " + sortTypeValue);
            System.out.println("Sort algorithm: " + sortAlgorithmValue);
            
            long endTime = System.currentTimeMillis();
            long timeTaken = endTime - startTime;

            // Display the first, last, and every thousandth value            
            for (int i = 0; i < shapes.length; i++) {
                if (i == 0 || i % 1000 == 0 || i == shapes.length - 1) {
                    String label;
                    if (i == 0) {
                        label = "First element";
                    } else if (i == shapes.length - 1) {
                        label = "Last element";
                    } else {
                        label = i + "-th element";
                    }

                    // Determine what to print based on sortTypeValue
                    double value;
                    if (sortTypeValue.equals("Height")) {
                        value = shapes[i].getHeight();
                    } else if (sortTypeValue.equals("Area")) {
                        value = shapes[i].getBaseArea();
                    } else if (sortTypeValue.equals("Volume")) {
                        value = shapes[i].getVolume();
                    } else {
                        // Default to Area if sortTypeValue is invalid
                        value = shapes[i].getBaseArea();
                    }

                    // Print the formatted output
                    System.out.printf("| %-15s | %-20s | %s: %-20.6E |%n",
                        label,
                        shapes[i].getType(),
                        sortTypeValue,
                        value);
                }
            }
            
            
            // Step 7: Display the sorted results and benchmarking data
            System.out.println("Sorting completed successfully!");
            System.out.println(sortAlgorithmValue +" run time was: " + timeTaken + " milliseconds");

        } catch (FileNotFoundException e) {
            // Handle file not found error
            System.err.println("File not found: " + fileName);
        }
    }
}