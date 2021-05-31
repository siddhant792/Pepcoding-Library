package Queue;

public class Client {
    public static void main(String[] args) throws Exception{
        dynamicQueue dq = new dynamicQueue();
        for(int i = 1; i < 20 ; i++){
            dq.enqueue(i * 10);
        }

        dq.display();
    }
}
