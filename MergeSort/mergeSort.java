import java.util.Random;
import java.util.Scanner;
/**
 * My take on the mergesort algorithm.
 * 
 * @author: Jacob Munroe
 * @date: 02/14/2025
 */
public class mergeSort {

    /**
     * Recursive method for applying mergesort algorithm. Creates two new arrays for left and right.
     * @param arr Array to be sorted.
     * @param n Size of the array.
     */
    public static void mergeSort(int[] arr, int n) {
        // if single element -> return
        if (n < 2) {
            return;
        }

        // defining the middle
        int mid = n / 2;

        // new left and right arrays
        int[] left = new int[mid];
        int[] right = new int[n - mid];

        // copy elements into left
        for(int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }
        // copy elements into right
        for(int i = mid; i < n; i++) {
            right[i - mid] = arr[i];
        }

        mergeSort(left, mid);
        mergeSort(right, n - mid);

        merge(arr, left, right, mid, n - mid);
    }



    /**
     * Method responsible for merging two seperate arrays in correct order.
     * @param arr Original array that will be sorted.
     * @param left Left half of the array.
     * @param right Right half of the array.
     * @param leftEnd End of the left half.
     * @param rightEnd End of the right half.
     */
    public static void merge(int[] arr, int[] left, int[] right, int leftEnd, int rightEnd) {

        // set pointers for sorting
        int index = 0, leftStart = 0, rightStart = 0;

        // while both pointers are in bounds
        while (leftStart < leftEnd && rightStart < rightEnd) {
            // if left is smaller then add to array
            if (left[leftStart] <= right[rightStart]) {
                arr[index] = left[leftStart];
                leftStart++;
            }
            // if right is smaller then add to array
            else {
                arr[index] = right[rightStart];
                rightStart++;
            }
            index++;
        }

        // if any remaining in left, add to array
        while (leftStart < leftEnd) {
            arr[index] = left[leftStart];
            leftStart++;
            index++;
        }
        // if any remaining in right, add to array
        while (rightStart < rightEnd) {
            arr[index] = right[rightStart];
            rightStart++;
            index++;
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
     * an array of random integers, apply mergesort, then print out the
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
        mergeSort(arr, arr.length);
        long endTime = System.nanoTime();

        System.out.println("After: " + printArray(arr));
        System.out.println("Execution Time: " + (endTime - startTime) + "ns");
    }
}