package Stack;

public class StackUsingCustomLL {
    public class Node{
        int data = 0;
        Node next = null;

        public Node(int data){
            this.data = data;
        }
    }

    private Node head = null;
    private Node tail = null;
    private int elementCount = 0;

    private void addFirst(int data){
        Node node = new Node(data);
        if(this.elementCount == 0){
            this.head = node;
            this.tail = node;
        }else{
            node.next = this.head;
            this.head = node;
        }
        this.elementCount++;
    }

    private int removeFirst(){
        Node node = this.head;
        if(this.elementCount == 1){
            this.head = null;
            this.tail = null;
        }else{
            this.head = node.next;
        }

        node.next = null;
        this.elementCount--;
        return node.data;
    }

    private int getFirst(){
        return this.head.data;
    }

    public int size(){
        return this.elementCount;
    }

    public boolean isEmpty(){
        return this.elementCount == 0;
    }

    public void push(int data){
        this.addFirst(data);
    }

    public void pop(){
        this.removeFirst();
    }

    public int top(){
        return this.getFirst();
    }
}
