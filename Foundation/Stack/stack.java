public class stack {
    protected int[] arr = null;
    protected int capacity = 0;
    protected int elementCount = 0;
    protected int tos = -1;

    protected void initializeVariables(int capacity){
        this.capacity = capacity;
        this.elementCount = 0;
        this.tos = -1;
        this.arr = new int[this.capacity];
    }

    public stack(){
        initializeVariables(10);
    }

    public stack(int size){
        initializeVariables(size);
    }

    public int size(){
        return this.elementCount;
    }

    public boolean isEmpty(){
        return this.elementCount == 0;
    }

    public void OverflowException() throws Exception{
        if(this.elementCount == this.capacity){
            throw new Exception("StackIsFull");
        }
    }

    public void UnderflowException() throws Exception{
        if(this.elementCount == 0){
            throw new Exception("StackIsEmpty");
        }
    }

    protected void push_(int data){
        this.arr[++this.tos] = data;
        this.elementCount++;
    }

    public void push(int data) throws Exception{
        OverflowException();
        push_(data);
    }

    public int top() throws Exception{
        UnderflowException();
        return this.arr[this.tos];
    }

    protected int pop_(){
        int temp = this.arr[this.tos];
        this.arr[this.tos--] = 0;
        this.elementCount--;
        return temp;
    }

    public int pop() throws Exception{
        UnderflowException();
        return pop_();
    }

    public void display(){
        for(int ele : this.arr) System.out.print(ele + " ");

        System.out.println();
    }

}
