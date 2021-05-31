package Adapter;

import java.util.Stack;

public class QueueUsingStack_Pop {
    private Stack<Integer> st = new Stack<>();
    private Stack<Integer> temp = new Stack<>();

    public int size(){
        return st.size();
    }

    public boolean isEmpty(){
        return this.st.isEmpty();
    }

    public void add(int data){
        trasferToAnotherStack();
        this.st.push(data);
        while(this.temp.size() != 0){
            this.st.push(this.temp.pop());
        }
    }

    public int peek(){
        if(this.st.isEmpty()){
            System.out.println("Queue underflow");
            return -1;
        } 
        return this.st.peek();
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
        return this.st.pop();
    }
}
