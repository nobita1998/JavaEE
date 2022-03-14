package dsa;

import java.util.Arrays;

public class heapSortDemo2 {

    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 1, 3, 7, 9, 8, 5};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void heapSort(int[] arr) {
        // 遍历所有非叶子结点，构建一个大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjust(arr, i, arr.length);
        }
        // 一个一个的交换排序 时间复杂度O(nlogn)
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            adjust(arr, 0, i - 1);
        }

    }

    private static void adjust(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int j = 2 * i + 1; j < length; j = 2 * j + 1) {
            if (j + 1 < length && arr[j] < arr[j + 1]){
                j++;
            }
            if (arr[j] > temp){
                arr[i] = arr[j];
                i = j;  // 记录最终temp的位置
            } else {
                break;
            }
        }
        arr[i] = temp;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
