import java.util.Arrays;

public class Sorting {

    public static void moveToLast(int[] arr, int si, int ei) {
        for (int i = si; i < ei - 1; i++) {
            if (arr[i] > arr[i + 1])
                swapElement(arr, i, i + 1);
        }
    }

    public static void bubbleSort(int[] arr) {

    }

    public static void swapElement(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void moveToStart(int[] arr, int si, int li) {
        for (int i = si + 1; i < li; i++) {
            if (arr[si] > arr[i])
                swapElement(arr, i, si);
        }
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            moveToStart(arr, i, arr.length);
        }
    }

    public static int[] mergeSorted(int[] A, int[] B) {
        int Alen = A.length;
        int Blen = B.length;
        int[] answer = new int[Alen+Blen];
        int i=0,j=0,idx = 0;
        while(i < Alen && j < Blen){
            if(A[i] < B[j]){
                answer[idx] = A[i];
                i++;
            }else{
                answer[idx] = B[j];
                j++;
            }
            idx++;
        }

        while(i<Alen){
            answer[idx] = A[i];
            i++;
            idx++;
        }

        while(j<Blen){
            answer[idx] = B[j];
            j++;
            idx++;
        }


        for (int val : answer)
            System.out.print(val + " ");

        return answer;
    }

    public static int[] mergeSort(int[] arr, int lo, int hi) {
        if(lo == hi){
            int[] base = new int[1];
            base[0] = arr[lo];
            return base;
        }
        
        int mid = (lo + hi)/2;
        
        int[] A = mergeSort(arr,lo,mid);
        int[] B = mergeSort(arr,mid+1,hi);

        return mergeSorted(A,B);
    }


    public static void sort01(int[] arr) {
        int ptr = 0,itr = 0;
        while(itr != arr.length){
            if(arr[itr] == 0){
                swap2(arr,itr,ptr);
                itr++;
                ptr++;
            }else{
                itr++;
            }
        }
    }

    public static void partition(int[] arr,int pivot){
        int i = 0,j = 0;
        while(j < arr.length){
            if(arr[j] <= pivot){
                swapAdv(arr,j,i);
                i++;
                j++;
            }else{
                j++;
            }
        }
    }

    public static void swap2(int[] arr, int i, int j) {
        System.out.println("Swapping index " + i + " and index " + j);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void sort012(int[] arr) {
        int ptr0 = 0,ptr1 = arr.length-1,itr = 0;
        while(itr <= ptr1+1){
            if(arr[itr] == 0){
                swap2(arr,itr,ptr0);
                ptr0++;
                itr++;
            }else if(arr[itr] == 1){
                itr++;
            }else{
                swap2(arr,itr,ptr1);
                ptr1--;
            }
        }
    }

    

    public static void swapAdv(int[] arr, int i, int j) {
        System.out.println("Swapping " + arr[i] + " and " + arr[j]);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static int binarySearch(int[] arr,int data,int si,int ei){
        while(si <= ei){
            int mid = (si+ei)/2;
            if(arr[mid] == data){
                return mid;
            }else if(arr[mid] < data) ei = mid - 1;
            else si = mid + 1;
        }
        return -1;
    }

    public static void targetSum(int[] arr,int target, int si,int ei){
        Arrays.sort(arr);
        while(si < ei){
            int num = arr[si] + arr[ei];
            if(num == target){
                System.out.println(arr[si] + ", " + arr[ei]);
            }else if(num < target) ei--;
            else si++;
        }
    }

    public static void countSort(int[] arr,int min,int max){
        int[] counter_arr = new int[max-min+1];
        
    }

    public static void main(String[] args) {
         int[] araA = {1,4,1,2,7,5,2};
         //countSort(araA);
        // int[] araB = {0,1};
        // mergeSorted(araA,araB);
        //targetSum(araA, 3);
    }
}
