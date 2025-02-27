package appDomain;

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

        // Step 2: Parse command line arguments
        for (int i = 0; i < args.length; i++) {
            switch (args[i].toLowerCase()) {
                case "-f":  // File name argument
                    if (i + 1 < args.length) {
                        fileName = args[++i];  // Store the next argument as the file name
                    } else {
                        System.err.println("Missing file name after -f");
                        return;
                    }
                    break;
                case "-t":  // Sort type argument
                    if (i + 1 < args.length) {
                        sortType = args[++i];  // Store the next argument as the sort type
                    } else {
                        System.err.println("Missing sort type after -t");
                        return;
                    }
                    break;
                case "-s":  // Sorting algorithm argument
                    if (i + 1 < args.length) {
                        sortAlgorithm = args[++i];  // Store the next argument as the sorting algorithm
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

        // Debug statements to check parsed arguments
        System.out.println("File name: " + fileName);
        System.out.println("Sort type: " + sortType);
        System.out.println("Sort algorithm: " + sortAlgorithm);

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
                    break;
                case "a":
                    comparator = Comparator.comparingDouble(Shape::getBaseArea);
                    break;
                case "v":
                    comparator = Comparator.comparingDouble(Shape::getVolume);
                    break;
                default:
                    System.err.println("Invalid sort type. Use h, a, or v.");
                    return;
            }

            // Step 6: Sort the shapes based on the specified sort type and algorithm
            SortingAlgorithms sortingAlgorithms = new SortingAlgorithms();
            long startTime = System.currentTimeMillis();
            switch (sortAlgorithm.toLowerCase()) {
                case "b":  // Bubble Sort
                    sortingAlgorithms.bubbleSort(shapes, comparator);
                    break;
                case "s":  // Selection Sort
                    sortingAlgorithms.selectionSort(shapes, comparator);
                    break;
                case "i":  // Insertion Sort
                    sortingAlgorithms.insertionSort(shapes, comparator);
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
            long endTime = System.currentTimeMillis();

            // Step 7: Display the sorted results and benchmarking data
            System.out.println("Sorting completed successfully!");
            System.out.println("Time taken: " + (endTime - startTime) + " milliseconds");

            // Display the first, last, and every thousandth value
            for (int i = 0; i < shapes.length; i++) {
                if (i == 0 || i == shapes.length - 1 || i % 1000 == 0) {
                    System.out.println(shapes[i]);
                }
            }

        } catch (FileNotFoundException e) {
            // Handle file not found error
            System.err.println("File not found: " + fileName);
        }
    }
}