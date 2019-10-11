package com.zzang.test.algorithms;

/**
 * How do you find the duplicate number on a given integer array?
 */
public class Array_duplicate {

    public static void main(String[] args) {
        int arr[] = {4, 2, 4, 5, 2, 3, 1};
        int arr_size = arr.length;
        printRepeating(arr, arr_size);
    }

    public static void printRepeating(int arr[], int size) {
        int i;
        System.out.println("The repeating elements are : ");

        for(i = 0; i < size; i++) {
            int index = Math.abs(arr[i]);
            if(arr[index] > 0)
                arr[index] = -arr[index];
            else
                System.out.print(Math.abs(arr[i]) + " ");
        }
    }
}
