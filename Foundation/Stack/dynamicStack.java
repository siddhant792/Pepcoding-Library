public class dynamicStack extends stack{

    public dynamicStack(){
        super();
    }

    public dynamicStack(int size){
        super(size);
    }

    public dynamicStack(int[] arr){
        super.initializeVariables(arr.length);

        for(int ele : arr) super.push_(ele);
    }

    @Override
    public void push(int data){
        if(super.capacity == super.elementCount){
            int[] temp = super.arr;
            super.initializeVariables(2 * elementCount);
            for(ine ele : temp) super.push(ele);
        }

        super.push(data);
    }
}
