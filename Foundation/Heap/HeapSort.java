package Heap;

public class HeapSort {

    public static void swap(int[] arr, int i, int j) {
        int ei = arr[i];
        int ej = arr[j];

        arr[i] = ej;
        arr[j] = ei;
    }

    private static void heapify(int[] arr, int pi, int end, boolean isMax) {
        int maxIdx = pi;
        int lci = 2 * pi + 1;
        int rci = 2 * pi + 2;

        if (lci < arr.length - end && compareTo(arr, lci, maxIdx, isMax) > 0)
            maxIdx = lci;
        if (rci < arr.length - end && compareTo(arr, rci, maxIdx, isMax) > 0)
            maxIdx = rci;

        if (maxIdx != pi) {
            swap(arr, maxIdx, pi);
            heapify(arr, maxIdx, end, isMax);
        }
    }

    public static int compareTo(int[] arr, int a, int b, boolean isMax) {
        if (isMax)
            return arr[a] - arr[b];
        else
            return arr[b] - arr[a];
    }

    public static void heapSort(int[] arr, boolean isMax) {
        for (int i = arr.length - 1; i >= 0; i--) {
            heapify(arr, i, 0, isMax);
        }
        int n = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            swap(arr, 0, n - i);
            heapify(arr, 0, i + 2, isMax);
        }

        for (int ele : arr)
            System.out.print(ele + " ");
        System.out.println();
    }

    

    public static void main(String[] args) {
        int[] arr = { 20, 22, 30, 10, 11, 13, 8, 9, 7, 6, 5, -2, -3, -4, 5 };
        heapSort(arr, false);
    }
}
