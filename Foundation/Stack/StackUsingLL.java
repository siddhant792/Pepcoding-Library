package Stack;

import java.util.*;

public class StackUsingLL {
    private LinkedList<Integer> ll = new LinkedList();

    public int size(){
        return this.ll.size();
    }

    public boolean isEmpty(){
        return this.ll.size() == 0;
    }

    public void push(int data){
        this.ll.addFirst(data);
    }

    public void pop(){
        this.ll.removeFirst();
    }

    public int top(){
        return this.ll.getFirst();
    }
}
