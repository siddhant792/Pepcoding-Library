package Adapter;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue_Remove {
    Queue<Integer> qu = new LinkedList<>();
    Queue<Integer> temp = new LinkedList<>();

    public int size(){
        return qu.size();
    }

    public boolean isEmpty(){
        return this.qu.isEmpty();
    }

    public void push(int data){
        addToAnotherQueue();
        this.qu.add(data);
        while(this.temp.size() != 0){
            this.qu.add(this.temp.remove());
        }
    }

    private void addToAnotherQueue(){
        while(this.qu.size() != 0){
            this.temp.add(this.qu.remove());
        }
    }

    public int pop(){
        return this.qu.remove();
    }

    public int peek(){
        return this.qu.peek();
    }
}
