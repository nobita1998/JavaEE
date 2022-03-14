package dsa;

import java.util.Arrays;

public class quickSort2 {

    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 1, 3, 7, 9, 8, 5};
        quickSort(arr, 0 , arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int partition = partition(arr, begin, end);
            quickSort(arr, begin, partition - 1);
            quickSort(arr, partition + 1, end);
        }
    }

    private static int partition(int[] arr, int begin, int end) {
        int pivot = arr[begin];
        int left = begin;
        int right = end;
        while (left < right) {
            while (left < right && arr[right] > pivot) right--;
            while (left < right && arr[left] <= pivot) left++;
            if (left < right) {
                swap(arr, left, right);
            }
        }
        swap(arr, begin, left);
        return left;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
