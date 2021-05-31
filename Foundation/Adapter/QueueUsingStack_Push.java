package Adapter;

import java.util.Stack;

public class QueueUsingStack_Push{
    private Stack<Integer> st = new Stack<>();
    private Stack<Integer> temp = new Stack<>();
    private int peek = 0;

    public int size(){
        return st.size();
    }

    public boolean isEmpty(){
        return this.st.isEmpty();
    }

    public void add(int data){
        if(st.size() == 0){
            this.peek = data;
        }
        this.st.push(data);
    }

    public int peek(){
        if(this.st.isEmpty()){
            System.out.println("Queue underflow");
            return -1;
        } 
        return this.peek;
    }
    
    private void trasferToAnotherStack(){
        while(this.st.size() != 0){
            this.temp.push(this.st.pop());
        }
    }

    public int remove(){
        if(this.st.isEmpty()){
            System.out.println("Queue underflow");
            return -1;
        } 
        trasferToAnotherStack();
        int rData = this.temp.pop();
        while(this.temp.size() != 0){
            add(this.temp.pop());
        }
        return rData;
    }
}