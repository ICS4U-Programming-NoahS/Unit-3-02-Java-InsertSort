import java.io.FileWriter;

/**
* The Insertion Sort program will read a set of integers between 0 and 100.
* It will populate the set of integers into an array.
* It will then sort the arrays using the insertion sort algorithm.
* It will write the sorted array to the output file.
*
* @version 1.0
* @since 2025-04-09
*/

final class InsertSort {

    /**
     * This is the maximum number.
     */
    public static final int MAX_NUM = 100;

    /**
     * This is the minimum number.
     */
    public static final int MIN_NUM = 0;

    /**
     * This is the size of the array.
     */
    public static final int ARRAY_SIZE = 10;

    /**
     * This is a private constructor used to satisfy the
     * style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
    */
    private InsertSort() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This is the populating arrays method.
     *
     * @return array of random numbers
     */

    public static int[] populatingArrays() {

        // Create an array of numbers
        // The size of the array is 10
        int[] arrayNum = new int[ARRAY_SIZE];

        // Write a random number to the array of numbers
        // until 10 numbers have been added
        for (int counter = 0; counter < arrayNum.length; counter += 1) {

            // Add a random integer to the array, cast as an integer
            // The random integer is between 0 and 100
            arrayNum[counter] = (int) (Math.random() * (MAX_NUM + 1));
        }

        // return the array of numbers
        return arrayNum;
    }

    /**
     * This is the binary search method.
     *
     * @param arrayInt array of integers
     * @return sorted array
     */

    public static int[] insertSort(final int[] arrayInt) {

        // Sort the array using insertion sort algorithm
        // Source: https://www.programiz.com/dsa/insertion-sort
        // Loop through the array starting from the second element
        for (int pass = 1; pass < ARRAY_SIZE; pass++) {

            // store the current number
            int currentNum = arrayInt[pass];
            int counter = pass - 1;

            // Compare key with each element on the left of it
            // until an element smaller than it is found.
            while (counter >= 0 && currentNum < arrayInt[counter]) {

                // Shift the larger number one position to the left
                arrayInt[counter + 1] = arrayInt[counter];

                // Decrement counter
                --counter;
            }

            // Shift the current number one position to the left
            arrayInt[counter + 1] = currentNum;

        }

        // return the sorted array
        return arrayInt;
    }

    /**
     * This is the main method.
     *
     * @param args Unused.
     */

    public static void main(final String[] args) throws Exception {

        // Initialize output string
        String outputStr = "";

        // Greeting
        System.out.println("Welcome to the insert sort program!");

        // Get the unsorted array by calling the populating arrays function
        int[] arrayNumber = populatingArrays();

        // Get the sorted array by calling the insert sort function
        arrayNumber = insertSort(arrayNumber);

        // Display the array
        for (int num : arrayNumber) {
            // Display each number, separated by a space
            outputStr += (num + " ");
        }

        // Add a newline to the output string for spacing
        outputStr += "\n";

         // Write to the output file
        FileWriter myWriter = new FileWriter("./output.txt");

        // Write the output string to the file
        myWriter.write(outputStr);

        // Added a blank line for spacing
        System.out.println("");

        // Close the file writer
        myWriter.close();

        // Display success message
        System.out.println("Successfully wrote to 'output.txt'");
    }
}
