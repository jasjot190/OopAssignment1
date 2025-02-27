package utilities;


import shapes.Shape;
import java.util.Comparator;

// Utility class for sorting algorithms.
public class SortingAlgorithms
{
	/**
     * Sorts an array of shapes using the bubble sort algorithm.
     *
     * @param shapes the array of shapes to sort
     * @param comparator the comparator to determine the order of the shapes
     */
	public static void bubbleSort(Shape[] shapes, Comparator<Shape> comparator) {
		int n = shapes.length;
		
		// Outer loop for each pass through the array.
		for (int i = 0; i < n-1; i++)
		{
			// Inner loop for comparing adjacent elements.
			for (int j = 0; j < n-1-i; j++)
			{
				// Compare adjacent elements and swap if out of order.
				if (comparator.compare(shapes[j], shapes[j + 1])> 0)
				{
					Shape temp = shapes[j];
					shapes[j] = shapes[j]; 
					shapes[j+1]= temp;
				}
			}
		}
	}
	
	/**
     * Sorts an array of shapes using the insertion sort algorithm.
     *
     * @param shapes the array of shapes to sort
     * @param comparator the comparator to determine the order of the shapes
     */
	public static void insertionSort(Shape[] shapes, Comparator<Shape> comparator)
	{
		int n = shapes.length;
		
		// Outer loop for each element in the array.
		for (int i = 1; i < n; i++)
		{
			Shape key = shapes[i];
			int j = i -1; 
			// Inner loop for shifting elements to the right.	
			while (j >= 0 && comparator.compare(shapes[j], key) > 0)
			{
				shapes[j + 1] = shapes[j];
				j--; 
			}
			
			// Place the key element in its correct position.
			shapes[j+1] = key;
		}
	}
	
	/**
     * Sorts an array of shapes using the selection sort algorithm.
     *
     * @param shapes the array of shapes to sort
     * @param comparator the comparator to determine the order of the shapes
     */
	public static void selectionSort(Shape[] shapes, Comparator<Shape> comparator)
	{
		int n = shapes.length;
		
		// Outer loop for each element in the array.
		for (int i = 0; i < n -1; i++)
		{
			int minIndex = i;
			// Inner loop for finding the minimum element in the unsorted part.
			for (int j = i + 1; j < n; j++)
			{
				if (comparator.compare(shapes[j], shapes[minIndex]) < 0)
				{
					minIndex = j;
				}
			}
			
			// Swap the found minimum element with the first element of the unsorted part.
			Shape temp = shapes[minIndex];
			shapes[minIndex] = shapes[i];
			shapes[i] = temp; 
		}
	}
}
