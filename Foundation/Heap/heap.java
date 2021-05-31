package Heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class heap {

    private ArrayList<Integer> arr;
    private int size = 0;

    private void init() {
        this.size = 0;
        this.arr = new ArrayList<>();
    }

    public heap() {
        init();
    }

    public heap(int[] arr) {
        init();
        for (int ele : arr)
            this.arr.add(ele);
        this.size = arr.length;
        for (int i = this.arr.size() - 1; i >= 0; i--) {
            downHeapify(i);
        }
    }

    private void swap(int i, int j) {
        int ei = this.arr.get(i);
        int ej = this.arr.get(j);

        this.arr.set(i, ej);
        this.arr.set(j, ei);
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0 ? true : false;
    }

    public int peek() {
        return this.arr.get(0);
    }

    public int remove() {
        int re = this.arr.get(0);
        swap(0, this.arr.size() - 1);
        this.arr.remove(this.arr.size() - 1);
        this.size--;
        downHeapify(0);
        return re;
    }

    private void downHeapify(int pi) {
        int maxIdx = pi;
        int lci = 2 * pi + 1;
        int rci = 2 * pi + 2;

        if (lci < this.arr.size() && arr.get(lci) > arr.get(maxIdx))
            maxIdx = lci;
        if (rci < this.arr.size() && arr.get(rci) > arr.get(maxIdx))
            maxIdx = rci;

        if (maxIdx != pi) {
            swap(maxIdx, pi);
            downHeapify(maxIdx);
        }
    }

    public void add(int data) {
        this.arr.add(data);
        this.size++;
        upHeapify(this.arr.size() - 1);
    }

    private void upHeapify(int ci) {
        int pi = (ci - 1) / 2;
        if (pi < 0)
            return;
        if (this.arr.get(ci) > this.arr.get(pi)) {
            swap(ci, pi);
            upHeapify(pi);
        }
    }

    // leetcode 378

    public int kthSmallest(int[][] mat, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        return 0;
    }

    

}
