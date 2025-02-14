package BinarySearch;

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class binarySearchAlgo {

    /**
     * Method responsible for implementing binary search to locate the index
     * of a target vale.
     * @param arr Array to be searched.
     * @param target The target value in the array.
     * @param start Start of the array.
     * @param end End of the array.
     * @return The index of the target value or '-1' if none available.
     */
    public static int binarySearch(int[] arr, int target, int start, int end) {

        // Make sure that we are still in bounds, if not, then element is not present.
        if (start <= end) {
            // middle of the array
            int mid = start + (end - start) / 2;

            // BASECASE if we have match
            if (arr[mid] == target) {
                return mid;
            }
            else {
                // If middle element is bigger, focus on left side
                if(arr[mid] > target) {
                    return binarySearch(arr, target, start, mid - 1);
                }
                else {
                    return binarySearch(arr, target, mid + 1, end);
                }
            }
        }

        return -1;
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
     * 
     * @param args
     */
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = scan.nextInt();

        int[] arr = generateRandomArray(size);
        Arrays.sort(arr);

        System.out.println("Array to search is:\n" + printArray(arr));

        int targetIndex = rand.nextInt(size - 1);
        int target = arr[targetIndex];

        System.out.println("Target Value: " + target);

        int result = binarySearch(arr, target, 0, arr.length - 1);

        System.out.print("The index of the value is: " + result);
    }
}