package Queue;

import java.util.*;

public class QueueUsingLL {
    private LinkedList<Integer> ll = new LinkedList();

    public int size(){
        return this.ll.size();
    }

    public boolean isEmpty(){
        return this.ll.size() == 0;
    }

    public void enqueue(int data){
        this.ll.addLast(data);
    }

    public void dequeue(){
        this.ll.removeFirst();
    }

    public void peek(){
        this.ll.getFirst();
    }
}
