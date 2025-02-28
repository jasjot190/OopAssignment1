package utilities;

import shapes.Shape;
import java.util.Comparator;

/**
 * Utility class for sorting algorithms.
 */
public class SortingAlgorithms {

    /**
     * Sorts an array of shapes in descending order using the bubble sort algorithm.
     *
     * @param shapes     the array of shapes to sort
     * @param comparator the comparator to determine the order of the shapes
     */
    public static void bubbleSort(Shape[] shapes, Comparator<Shape> comparator) {
        int n = shapes.length;

        // Outer loop for each pass through the array.
        for (int i = 0; i < n - 1; i++) {
            // Inner loop for comparing adjacent elements.
            for (int j = 0; j < n - 1 - i; j++) {
                // Compare adjacent elements and swap if out of order (for descending order).
                if (comparator.compare(shapes[j], shapes[j + 1]) < 0) { // Changed to < for descending order
                    Shape temp = shapes[j];
                    shapes[j] = shapes[j + 1];
                    shapes[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Sorts an array of shapes in descending order using the insertion sort algorithm.
     *
     * @param shapes     the array of shapes to sort
     * @param comparator the comparator to determine the order of the shapes
     */
    public static void insertionSort(Shape[] shapes, Comparator<Shape> comparator) {
        int n = shapes.length;

        // Outer loop for each element in the array.
        for (int i = 1; i < n; i++) {
            Shape key = shapes[i];
            int j = i - 1;

            // Inner loop for shifting elements to the right (for descending order).
            while (j >= 0 && comparator.compare(shapes[j], key) < 0) { // Changed to < for descending order
                shapes[j + 1] = shapes[j];
                j--;
            }

            // Place the key element in its correct position.
            shapes[j + 1] = key;
        }
    }

    /**
     * Sorts an array of shapes in descending order using the selection sort algorithm.
     *
     * @param shapes     the array of shapes to sort
     * @param comparator the comparator to determine the order of the shapes
     */
    public static void selectionSort(Shape[] shapes, Comparator<Shape> comparator) {
        int n = shapes.length;

        // Outer loop for each element in the array.
        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i; // Changed to maxIndex for descending order

            // Inner loop for finding the maximum element in the unsorted part.
            for (int j = i + 1; j < n; j++) {
                if (comparator.compare(shapes[j], shapes[maxIndex]) > 0) { // Changed to > for descending order
                    maxIndex = j;
                }
            }

            // Swap the found maximum element with the first element of the unsorted part.
            Shape temp = shapes[maxIndex];
            shapes[maxIndex] = shapes[i];
            shapes[i] = temp;
        }
    }

    /**
     * Sorts an array of shapes in descending order using the merge sort algorithm.
     *
     * @param shapes     the array of shapes to sort
     * @param comparator the comparator to determine the order of the shapes
     */
    public static void mergeSort(Shape[] shapes, Comparator<Shape> comparator) {
        if (shapes == null || shapes.length < 2) return; // Base case: already sorted
        Shape[] tempArray = new Shape[shapes.length];
        mergeSortHelper(shapes, tempArray, 0, shapes.length - 1, comparator);
    }

    // Merge Sort Recursive Function
    private static void mergeSortHelper(Shape[] shapes, Shape[] tempArray, int left, int right, Comparator<Shape> comparator) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;
        mergeSortHelper(shapes, tempArray, left, mid, comparator);
        mergeSortHelper(shapes, tempArray, mid + 1, right, comparator);
        merge(shapes, tempArray, left, mid, right, comparator);
    }

    // Merge Function
    private static void merge(Shape[] shapes, Shape[] tempArray, int left, int mid, int right, Comparator<Shape> comparator) {
        System.arraycopy(shapes, left, tempArray, left, right - left + 1);

        int i = left;     // Left half pointer
        int j = mid + 1;  // Right half pointer
        int k = left;     // Merged array pointer

        while (i <= mid && j <= right) {
            if (comparator.compare(tempArray[i], tempArray[j]) >= 0) { // Changed to >= for descending order
                shapes[k++] = tempArray[i++];
            } else {
                shapes[k++] = tempArray[j++];
            }
        }

        // Copy remaining elements (if any)
        while (i <= mid) shapes[k++] = tempArray[i++];
        while (j <= right) shapes[k++] = tempArray[j++];
    }

    /**
     * Sorts an array of shapes in descending order using the quick sort algorithm.
     *
     * @param shapes     the array of shapes to sort
     * @param comparator the comparator to determine the order of the shapes
     */
    public static void quickSort(Shape[] shapes, Comparator<Shape> comparator) {
        quickSortHelper(shapes, 0, shapes.length - 1, comparator);
    }

    // Quick Sort Recursive Function
    private static void quickSortHelper(Shape[] shapes, int low, int high, Comparator<Shape> comparator) {
        if (low < high) {
            int pivotIndex = partition(shapes, low, high, comparator);
            quickSortHelper(shapes, low, pivotIndex - 1, comparator);
            quickSortHelper(shapes, pivotIndex + 1, high, comparator);
        }
    }

    // Partition Function
    private static int partition(Shape[] shapes, int low, int high, Comparator<Shape> comparator) {
        Shape pivot = shapes[high]; // Last element as pivot
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (comparator.compare(shapes[j], pivot) >= 0) { // Changed to >= for descending order
                i++;
                swap(shapes, i, j);
            }
        }
        swap(shapes, i + 1, high);
        return i + 1;
    }

    /**
     * Sorts an array of shapes in descending order using the heap sort algorithm.
     *
     * @param shapes     the array of shapes to sort
     * @param comparator the comparator to determine the order of the shapes
     */
    public static void heapSort(Shape[] shapes, Comparator<Shape> comparator) {
        int n = shapes.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(shapes, n, i, comparator);
        }

        // Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            swap(shapes, 0, i);
            heapify(shapes, i, 0, comparator);
        }
    }

    // Heapify Function
    private static void heapify(Shape[] shapes, int n, int i, Comparator<Shape> comparator) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && comparator.compare(shapes[left], shapes[largest]) > 0) { // Changed to > for descending order
            largest = left;
        }

        if (right < n && comparator.compare(shapes[right], shapes[largest]) > 0) { // Changed to > for descending order
            largest = right;
        }

        if (largest != i) {
            swap(shapes, i, largest);
            heapify(shapes, n, largest, comparator);
        }
    }

    // Swap Function
    private static void swap(Shape[] shapes, int i, int j) {
        Shape temp = shapes[i];
        shapes[i] = shapes[j];
        shapes[j] = temp;
    }
}