package dsa;

import java.util.Arrays;
/* 首先调整从所有非叶子结点开始调整为为大顶堆
*  之后每次交换堆顶和最后一个元素，再次调整为大顶堆
* */
public class heapSortDemo {

    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 1, 3, 7, 9, 8, 5};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void heapSort(int[] arr){

        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjust(arr, i, arr.length);
            System.out.println("调整");
        }

        for (int j = arr.length - 1; j >= 0; j--) {
            swap(arr, 0, j);
            adjust(arr, 0, j);
            System.out.println("交换");
        }
    }


    private static void adjust(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int k = 2*i+1; k < length; k = 2*k+1) {
            if (k + 1 < length && arr[k] < arr[k+1]) {
                k += 1;
            }
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
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
