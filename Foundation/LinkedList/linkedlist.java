package LinkedList;

public class linkedlist {
    private class Node {
        int data = 0;
        Node next = null;
        public Node(int data) {
            this.data = data;
        }
    }

    private Node head = null;
    private Node tail = null;
    private int sizeOfLl = 0;

    public boolean isEmpty() {
        return sizeOfLl == 0;
    }

    public int size() {
        return sizeOfLl;
    }

    // Exception

    private void EmptyException() throws Exception {
        if (this.sizeOfLl == 0) {
            throw new Exception("LinkedList is Empty: -1 pepcoding");
        }
    }

    private void IndexOutOfBoundSizeExclusiveException(int idx) throws Exception {
        if (idx < 0 || idx >= this.sizeOfLl)
            throw new Exception("Index Out Of Bound : -1");
    }

    private void IndexOutOfBoundSizeInclusiveException(int idx) throws Exception {
        if (idx < 0 || idx > this.sizeOfLl)
            throw new Exception("Index Out Of Bound : -1");
    }

    // Add

    private void addFirstNode(Node node) {
        if (this.head == null) {
            this.head = node;
            this.tail = node;
        } else {
            node.next = this.head;
            this.head = node;
        }
        this.sizeOfLl++;
    }

    public void addFirst(int data){
        Node node = new Node(data);
        addFirstNode(node);
    }

    private void addLastNode(Node node) {
        if (this.tail == null) {
            this.head = node;
            this.tail = node;
        } else {
            this.tail.next = node;
            this.tail = node;
        }
        this.sizeOfLl++;
    }

    public void addLast(int data){
        Node node = new Node(data);
        addLastNode(node);
    }

    private void addNodeAt(Node node,int idx){
        if(idx == 0){
            addFirstNode(node);
        }else if(idx == sizeOfLl -1){
            addLastNode(node);
        }else{
            Node prev = getNodeAt(idx - 1);
            Node frwd = prev.next;

            prev.next = node;
            node.next = frwd;

            this.sizeOfLl++;
        }
    }

    public void addAt(int idx, int data) throws Exception{
        IndexOutOfBoundSizeExclusiveException(idx);
        Node node = new Node(data);
        addNodeAt(node,idx);
    }

    // Remove

    private Node removeFirstNode(){
        Node myFirstNode = this.head;
        if(this.sizeOfLl == 1){
            this.head = null;
            this.tail = null;
        }else{
            Node nextNode = this.head.next;
            myFirstNode.next = null;
            this.head = nextNode;
        }
        this.sizeOfLl--;
        return myFirstNode;
    }

    public int removeFirst() throws Exception{
        EmptyException();
        Node node = removeFirstNode();
        return node.data;
    }

    private Node removeLastNode(){
        Node myLastNode = this.tail;
        if(this.sizeOfLl == 1){
            this.head = null;
            this.tail = null;
        }else{
            Node nextNode = getNodeAt(sizeOfLl-2);
            this.tail.next = null;
            this.tail = nextNode;
        }
        this.sizeOfLl--;
        return myLastNode;
    }

    public int removeLast() throws Exception{
        EmptyException();
        Node node = removeLastNode();
        return node.data;
    }

    private Node removeNodeAt(int idx){
        Node myNode = this.head;
        if(idx == 0){
            myNode = removeFirstNode();
        }else if(idx == sizeOfLl-1){
            myNode = removeLastNode();
        }else{
            Node prev = getNodeAt(idx-1);
            myNode = prev.next;
            Node frwd = myNode.next;

            prev.next = frwd;
            myNode.next = null;
            sizeOfLl--;
        }
        return myNode;
    }

    public int removeAt(int idx) throws Exception{
        IndexOutOfBoundSizeInclusiveException(idx);
        Node node = removeNodeAt(idx);
        return node.data;
    }

    // Get

    private Node getNodeAt(int idx){
        Node myNode = this.head;
        if(idx == 0){
            return myNode;
        }else if(idx == sizeOfLl-1){
            myNode = this.tail;
            return myNode;
        }else{
            int count = 0;
            while(true){
                if(count == idx) break;
                myNode = myNode.next;
                count++;
            }
            return myNode;
        }
    }

    public int getFirst() throws Exception{
        EmptyException();
        return this.head.data;
    }

    public int getLast() throws Exception{
        EmptyException();
        return this.tail.data;
    }

    public int getAt(int idx) throws Exception{
        EmptyException();
        Node node = getNodeAt(idx);
        return node.data;
    }

    // Display

    public void display(){
        int count = 0;
        Node temp = this.head;
        while(count < sizeOfLl){
            System.out.print( temp.data + "  -->  ");
            temp = temp.next;
            count++;
        }
        System.out.println();
    }

}
