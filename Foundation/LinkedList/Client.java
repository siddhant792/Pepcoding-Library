package LinkedList;

public class Client {
    public static void main(String[] args) throws Exception{
        linkedlist ll = new linkedlist();
        for(int i=1;i<=10;i++) ll.addLast(i);
        ll.display();
    }
}
