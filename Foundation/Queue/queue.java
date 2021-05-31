package Queue;

public class queue {
    protected int[] arr = null;
    protected int capacity = 0;
    protected int elementCount = 0;
    protected int front = 0;
    protected int rear = 0;

    public void initializeVariables(int size) {
        this.arr = new int[size];
        this.capacity = size;
        this.elementCount = 0;
        this.front = 0;
        this.rear = 0;
    }

    public queue() {
        initializeVariables(10);
    }

    public queue(int size) {
        initializeVariables(size);
    }

    public int size() {
        return this.elementCount;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0; i < this.elementCount;i++){
            int idx = (this.front + i) % this.capacity;
            sb.append(this.arr[idx]);
            if(i != this.elementCount - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    public boolean isEmpty() {
        return this.elementCount == 0;
    }

    public void OverflowException() throws Exception {
        if (this.elementCount == this.capacity) {
            throw new Exception("QueueIsFull");
        }
    }

    public void UnderflowException() throws Exception {
        if (this.elementCount == 0) {
            throw new Exception("QueueIsEmpty");
        }
    }

    protected void enqueue_(int data) {
        this.arr[this.rear] = data;
        this.rear = (this.rear + 1) % this.capacity;
        this.elementCount++;
    }

    public void enqueue(int data) throws Exception {
        OverflowException();
        enqueue_(data);
    }

    protected int dequeue_() {
        int temp = this.arr[this.front];
        this.arr[this.front] = 0;
        this.front = (this.front + 1) % capacity;
        this.elementCount--;
        return temp;
    }

    public int dequeue() throws Exception {
        UnderflowException();
        return dequeue_();
    }

    public int peek() throws Exception{
        UnderflowException();
        return this.arr[this.front];
    }

}
