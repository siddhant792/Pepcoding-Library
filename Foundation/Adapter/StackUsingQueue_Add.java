package Adapter;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue_Add {
    Queue<Integer> qu = new LinkedList<>();
    Queue<Integer> temp = new LinkedList<>();
    private int top = 0;

    public int size(){
        return qu.size();
    }

    public boolean isEmpty(){
        return this.qu.isEmpty();
    }

    public void push(int data){
        this.top = data;
        this.qu.add(data);
    }

    private void addToAnotherQueue(){
        while(this.qu.size() != 0){
            this.temp.add(this.qu.remove());
        }
    }

    public int pop(){
        addToAnotherQueue();
        while(this.temp.size() != 1){
            this.push(this.temp.remove());
        }
        return this.temp.remove();
    }

    public int peek(){
        return this.top;
    }


}
