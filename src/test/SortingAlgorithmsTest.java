package test;

import shapes.*;
import utilities.SortingAlgorithms;
import org.junit.jupiter.api.Test;
import java.util.Comparator;
import static org.junit.jupiter.api.Assertions.assertTrue;

//Unit tests for the SortingAlgorithmsTest class.
public class SortingAlgorithmsTest {

	//Tests the bubbleSort method of SorthingAlgorithms.
    @Test
    public void testBubbleSort() {
    	// Create an array of shapes.
        Shape[] shapes = {
            new Cylinder(10, 5),
            new Cone(8, 3),
            new Pyramid(6, 4)
        };
        
        // Create a comparator to compare shapes by height.
        Comparator<Shape> comparator = Comparator.comparingDouble(Shape::getHeight);
        // Sort the shapes using bubble sort
        SortingAlgorithms.bubbleSort(shapes, comparator);
        // Assert that the shapes are sorted
        assertTrue(isSorted(shapes, comparator));
    }

    //Tests the insertionSort method of SortingAlgorithms.
    @Test
    public void testInsertionSort() {
    	// Create an array of shapes
        Shape[] shapes = {
            new Cylinder(10, 5),
            new Cone(8, 3),
            new Pyramid(6, 4)
        };
        // Create a comparator to compare shapes by height
        Comparator<Shape> comparator = Comparator.comparingDouble(Shape::getHeight);
        // Sort the shapes using insertion sort
        SortingAlgorithms.insertionSort(shapes, comparator);
        // Assert that the shapes are sorted.
        assertTrue(isSorted(shapes, comparator));
    }
    
    // Tests the selectionSort method of SortingAlgorithms.
    @Test
    public void testSelectionSort() {
    	// Create an array of shapes.
        Shape[] shapes = {
            new Cylinder(10, 5),
            new Cone(8, 3),
            new Pyramid(6, 4)
        };
        // Create a comparator to compare shapes by height.
        Comparator<Shape> comparator = Comparator.comparingDouble(Shape::getHeight);
        // Sort the shapes using selection sort.
        SortingAlgorithms.selectionSort(shapes, comparator);
        // Assert that the shapes are sorted.
        assertTrue(isSorted(shapes, comparator));
    }

    // Tests the mergeSort method of SortingAlgorithms.
    @Test
    public void testMergeSort() {
        // Create an array of shapes
        Shape[] shapes = {
            new Cylinder(10, 5),
            new Cone(8, 3),
            new Pyramid(6, 4)
        };
        // Create a comparator to compare shapes by height
        Comparator<Shape> comparator = Comparator.comparingDouble(Shape::getHeight);
        // Sort the shapes using merge sort
        SortingAlgorithms.mergeSort(shapes, comparator);
        // Assert that the shapes are sorted
        assertTrue(isSorted(shapes, comparator));
    }
    
    // Tests the quickSort method of SortingAlgorithms.
    @Test
    public void testQuickSort() {
        // Create an array of shapes
        Shape[] shapes = {
            new Cylinder(10, 5),
            new Cone(8, 3),
            new Pyramid(6, 4)
        };
        // Create a comparator to compare shapes by height
        Comparator<Shape> comparator = Comparator.comparingDouble(Shape::getHeight);
        // Sort the shapes using quick sort
        SortingAlgorithms.quickSort(shapes, comparator);
        // Assert that the shapes are sorted
        assertTrue(isSorted(shapes, comparator));
    }
    
    // Tests the heapSort method of SortingAlgorithms.
    @Test
    public void testHeapSort() {
        // Create an array of shapes
        Shape[] shapes = {
            new Cylinder(10, 5),
            new Cone(8, 3),
            new Pyramid(6, 4)
        };
        // Create a comparator to compare shapes by height
        Comparator<Shape> comparator = Comparator.comparingDouble(Shape::getHeight);
        // Sort the shapes using heap sort
        SortingAlgorithms.heapSort(shapes, comparator);
        // Assert that the shapes are sorted
        assertTrue(isSorted(shapes, comparator));
    }
    
    /**
     * Helper method to check if an array of shapes is sorted.
     *
     * @param shapes the array of shapes to check
     * @param comparator the comparator to use for comparison
     * @return true if the array is sorted, false otherwise
     */
    private boolean isSorted(Shape[] shapes, Comparator<Shape> comparator) {
        for (int i = 0; i < shapes.length - 1; i++) {
            if (comparator.compare(shapes[i], shapes[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }
}