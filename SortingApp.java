/*
 * Samuel Solomon and Mingrui Yuan
 * Assignment 2
 * This program will read and perform 3 different sorting algorithms
 * on each line of the experimental data.
 * It will analyze and compare the efficiency of each.
 * */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SortingApp {

    static int operationCount = 0;


    //----------------------------Main Method----------------------------------------
    public static void main(String[] args) {
        //Read txt file
        try {
            File file = new File("data.txt");
            Scanner scan = new Scanner(file);

            //loop while txt file has data
            while(scan.hasNextLine()) {
                String n = scan.nextLine();
                String[] numString = n.split(" ");
                int a [] = new int[numString.length];
                //convert string array to int array
                for(int i = 0;i < numString.length;i++)
                {
                    a[i] = Integer.parseInt(numString[i]);

                }



                System.out.println("When sorting");
                printArray(a);
                System.out.println();
                //test current array
                int bubbleOps = bubbleSort(a.clone());
                int insertionOps = insertionSort(a.clone());
                int selectionOps = selectionSort(a.clone());

                System.out.println("Bubble Sort took " + bubbleOps + " operations");
                System.out.println("Insertion Sort took " +  insertionOps + " operations");
                System.out.println("Selection Sort took " + selectionOps + " operations");
                System.out.println();

                //array of total operations for each search
                int ops[]= {bubbleOps,insertionOps, selectionOps};
                int minOps = findMin(ops, 0);
                //find what index had lowest value, print accordingly
                if(minOps == 0)
                    System.out.println("Bubble sort took the least operations");
                if(minOps == 1)
                    System.out.println("Insertion sort took the least operations");
                else
                    System.out.println("Selection sort took the least operations");

                System.out.println();
            }

            scan.close();

        } catch (FileNotFoundException e) { // In case the file is not found, print error
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }


    //----------------------------Sorting Methods----------------------------------------
    public static int selectionSort(int[] a) {
        //reset operationCount
        operationCount = 0;

        //loop n-1 times
        for (int i = 0; i < a.length -1; i++){

            //pass find min array and unsorted starting index
            int smallestIndex = findMin(a, i);
            //pass array, smallest value, and the index it belongs
            swapValues(a, smallestIndex, i);

        }

        return operationCount;
    }

    public static int insertionSort(int[] a) {
        //reset operationCount
        operationCount = 0;

        //loop through entire array except first element, since its already sorted
        for (int i = 1; i < a.length; i++){

            int target = a[i];
            int newPosition = findPosition(a, i);
            shiftDown(a, newPosition,i);

            //put target in correct spot
            a[newPosition] = target;

        }
        return operationCount;
    }

    public static int bubbleSort(int a[]) {
        //reset operationCount
        operationCount = 0;

        //loop n-1 times
        for(int i=0; i<a.length-1; i++) {
            for (int j = 0; j < a.length-i-1; j++) {
                operationCount++;
                //if j is bigger than the number in front of it, swap
                if (a[j] > a[j+1])
                {
                    swapValues(a, j, j+1);
                }
            }
        }

        return operationCount;
    }
    //----------------------------Helper Methods----------------------------------------
    public static void printArray(int a[]) {
        for(int i:a){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public static int findMin(int[] a, int i) {
        int minIndex = i;
        //goes through array starting at i
        for(int j=i+1; j<a.length; j++) {
            operationCount++;
            //if num following i is smaller, it is min
            if(a[j]<a[minIndex]) {
                operationCount++;
                minIndex = j;
            }
        }
        return minIndex;
    }

    public static void swapValues(int[] a, int t, int i) {
        //swap the smallest to current index
        int temp = a[t];
        a[t] = a[i];
        a[i] = temp;
    }

    public static int findPosition(int[] a, int i) {
        int value = a[i];
        while(i>0) {
            operationCount++;
            if(value > a[i-1])
                return i;
            i--;
        }
        return 0;
    }

    public static void shiftDown(int[] a, int j, int i) {
        //loop from old position down to new position
        for (int x = i; x > j; x--) {
            //put new value in front of smaller value
            a[x] = a[x-1];

        }
    }


}

