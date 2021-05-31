package Queue;

public class dynamicQueue extends queue{

    public dynamicQueue(){
        super();
    }

    public dynamicQueue(int size){
        super(size);
    }

    public dynamicQueue(int[] arr){
        super.initializeVariables(arr.length);

        for(int ele : arr) super.enqueue_(ele);
    }

    @Override
    public void enqueue(int data) throws Exception{
        if(super.capacity == super.elementCount){
            int[] temp = super.arr;
            int cap = super.capacity;
            int fro = super.front;
            super.initializeVariables(cap * 2);
            for(int i = 0;i < cap ; i++){
                int idx = (fro + i) % cap;
                super.enqueue_(temp[idx]);
            }
        }
        super.enqueue(data);
    }
}
