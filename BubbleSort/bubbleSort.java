package BubbleSort;

import java.util.Random;
import java.util.Scanner;

public class bubbleSort {

    public static void bubbleSort(int[] arr) {
        // var for swapping
        boolean swapped;
        int n = arr.length;

        // first for loop -> represents a pass
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            // second loop -> makes comparisons and swaps
            for (int j = 0; j < n - i - 1; j++) {
                // if bigger than element to right -> swap
                if (arr[j] > arr[j + 1]) {
                    // temp value to store for swap
                    int temp = arr[j];

                    // making swap happen
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swapped = true;
                }
            }
            // array is sorted if we get here
            if (!swapped) {
                break;
            }
        }
    }



    /**
     * Method to print out an array of integers.
     * @param arr Array of ints to be printed.
     * @return The string result of an array of integers.
     */
    public static String printArray(int[] arr) {
        String result = "{";

        for (int i = 0; i < arr.length - 1; i++) {
            result += arr[i] + ", ";
        }

        result += arr[arr.length - 1] + "}";
        return result;
    }



    /**
     * Method to generate an array of random integers from 0 - 10000.
     * @param size The size of the array.
     * @return Array of random integers from 0 - 10000.
     */
    public static int[] generateRandomArray(int size) {
        int[] result = new int[size];

        Random rand = new Random();

        for (int i = 0; i < size; i++) {
            result[i] = rand.nextInt(10000);
        }

        return result;
    }



    /**
     * Main method that will take input for the size of an array, will generate
     * an array of random integers, apply bubble sort, then print out the
     * execution time along with the sorted array.
     * @param args Command line arguments.
     */
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the size of your array: ");
        int size = scan.nextInt();
        scan.close();

        int[] arr = generateRandomArray(size);
        

        System.out.println("Before: " + printArray(arr));

        long startTime = System.nanoTime();
        bubbleSort(arr);
        long endTime = System.nanoTime();

        System.out.println("After: " + printArray(arr));
        System.out.println("Execution Time: " + (endTime - startTime) + "ns");
    }
}