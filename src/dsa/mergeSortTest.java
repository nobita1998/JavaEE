package dsa;

import java.util.Arrays;

public class mergeSortTest {
    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 1, 3, 7, 9, 8, 5};
        mergeSort(arr, 0, arr.length - 1, new int[arr.length]);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int begin, int end, int[] temp) {
        if (begin < end){
            int mid = (begin + end) / 2;
            mergeSort(arr, begin, mid, temp);
            mergeSort(arr, mid + 1, end, temp);
            merge(arr, begin, mid, end, temp);
        }
    }

    private static void merge(int[] arr, int begin, int mid, int end, int[] temp) {
        int left = begin;
        int right = mid + 1;
        int t = 0;
        while(left <= mid && right <= end){
            if (arr[left] <= arr[right]){
                temp[t++] = arr[left++];
            } else {
                temp[t++] = arr[right++];
            }
        }
        while (left <= mid){
            temp[t++] = arr[left++];
        }
        while (right <= end){
            temp[t++] = arr[right++];
        }

//        System.arraycopy(temp, 0, arr, begin, t);
        for(int i = 0; i < t; i++){
            arr[begin + i] = temp[i];
        }
    }

}
