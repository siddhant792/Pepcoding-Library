package PepCoding.Foundation.LinkedList;

public class QuestionsLL {
  public static class Node {
    int data;
    Node next;
  }

  public static class LinkedList {
    Node head;
    Node tail;
    int size;

    void addLast(int val) {
      Node temp = new Node();
      temp.data = val;
      temp.next = null;

      if (size == 0) {
        head = tail = temp;
      } else {
        tail.next = temp;
        tail = temp;
      }

      size++;
    }

    public int size() {
      return size;
    }

    public void display() {
      for (Node temp = head; temp != null; temp = temp.next) {
        System.out.print(temp.data + " ");
      }
      System.out.println();
    }

    public void removeFirst() {
      if (size == 0) {
        System.out.println("List is empty");
      } else if (size == 1) {
        head = tail = null;
        size = 0;
      } else {
        head = head.next;
        size--;
      }
    }

    public int getFirst() {
      if (size == 0) {
        System.out.println("List is empty");
        return -1;
      } else {
        return head.data;
      }
    }

    public int getLast() {
      if (size == 0) {
        System.out.println("List is empty");
        return -1;
      } else {
        return tail.data;
      }
    }

    public int getAt(int idx) {
      if (size == 0) {
        System.out.println("List is empty");
        return -1;
      } else if (idx < 0 || idx >= size) {
        System.out.println("Invalid arguments");
        return -1;
      } else {
        Node temp = head;
        for (int i = 0; i < idx; i++) {
          temp = temp.next;
        }
        return temp.data;
      }
    }

    public void addFirst(int val) {
      Node temp = new Node();
      temp.data = val;
      temp.next = head;
      head = temp;

      if (size == 0) {
        tail = temp;
      }

      size++;
    }

    public void addAt(int idx, int val) {
      if (idx < 0 || idx > size) {
        System.out.println("Invalid arguments");
      } else if (idx == 0) {
        addFirst(val);
      } else if (idx == size) {
        addLast(val);
      } else {
        Node node = new Node();
        node.data = val;

        Node temp = head;
        for (int i = 0; i < idx - 1; i++) {
          temp = temp.next;
        }
        node.next = temp.next;

        temp.next = node;
        size++;
      }
    }

    public void removeLast() {
      if (size == 0) {
        System.out.println("List is empty");
      } else if (size == 1) {
        head = tail = null;
        size = 0;
      } else {
        Node temp = head;
        for (int i = 0; i < size - 2; i++) {
          temp = temp.next;
        }

        tail = temp;
        tail.next = null;
        size--;
      }
    }

    public void removeAt(int idx) {
      if (idx < 0 || idx >= size) {
        System.out.println("Invalid arguments");
      } else if (idx == 0) {
        removeFirst();
      } else if (idx == size - 1) {
        removeLast();
      } else {
        Node temp = head;
        for (int i = 0; i < idx - 1; i++) {
          temp = temp.next;
        }

        temp.next = temp.next.next;
        size--;
      }
    }

    private Node getNodeAt(int idx) {
      Node temp = head;
      for (int i = 0; i < idx; i++) {
        temp = temp.next;
      }
      return temp;
    }

    public void reverseDI() {
      int li = 0;
      int ri = size - 1;
      while (li < ri) {
        Node left = getNodeAt(li);
        Node right = getNodeAt(ri);

        int temp = left.data;
        left.data = right.data;
        right.data = temp;

        li++;
        ri--;
      }
    }

    public void reversePI() {
      if (size <= 1) {
        return;
      }

      Node prev = null;
      Node curr = head;
      while (curr != null) {
        Node next = curr.next;

        curr.next = prev;
        prev = curr;
        curr = next;
      }

      Node temp = head;
      head = tail;
      tail = temp;
    }

    public int kthFromLast(int k) {
      Node slow = head;
      Node fast = head;
      for (int i = 0; i < k; i++) {
        fast = fast.next;
      }

      while (fast != tail) {
        slow = slow.next;
        fast = fast.next;
      }

      return slow.data;
    }

    public int mid() {
      Node f = head;
      Node s = head;

      while (f.next != null && f.next.next != null) {
        f = f.next.next;
        s = s.next;
      }

      return s.data;
    }

    public static LinkedList mergeTwoSortedLists(LinkedList l1, LinkedList l2) {
      LinkedList ml = new LinkedList();

      Node one = l1.head;
      Node two = l2.head;
      while (one != null && two != null) {
        if (one.data < two.data) {
          ml.addLast(one.data);
          one = one.next;
        } else {
          ml.addLast(two.data);
          two = two.next;
        }
      }

      while (one != null) {
        ml.addLast(one.data);
        one = one.next;
      }

      while (two != null) {
        ml.addLast(two.data);
        two = two.next;
      }

      return ml;
    }

    public static Node midNode(Node head) {
      Node slow = head;
      Node fast = head;
      while (fast.next != null && fast.next.next != null) {
        slow = slow.next;
        fast = fast.next.next;
      }
      return slow;
    }

    public static LinkedList mergeSort(Node head, Node tail) {
      if (head == tail) {
        LinkedList base = new LinkedList();
        base.addLast(head.data);
        return base;
      }

      Node mid = midNode(head);
      Node head1 = head;
      Node tail1 = mid;
      Node head2 = mid.next;
      Node tail2 = tail;

      mid.next = null;

      LinkedList fHalf = mergeSort(head1, tail1);
      LinkedList sHalf = mergeSort(head2, tail2);

      mid.next = head2;

      return mergeTwoSortedLists(fHalf, sHalf);
    }

    // public static LinkedList addTwoLists(LinkedList one, LinkedList two) {
    // one.reversePI();
    // two.reversePI();
    // LinkedList answer = new LinkedList();

    // Node node1 = one.head;
    // Node node2 = two.head;

    // int carry = 0;
    // while(node1!=null || node2!=null || carry!=0){
    // int sum = (node1!=null ? node1.data : 0) + (node2!=null ? node2.data : 0) +
    // carry;
    // carry = sum/10;
    // sum = sum%10;
    // answer.addFirst(sum);

    // if(node1!=null) node1 = node1.next;
    // if(node2!=null) node2 = node2.next;
    // }

    // one.reversePI();
    // two.reversePI();

    // return answer;
    // }

    public static int addTwoListsRec(Node one, int s1, Node two, int s2, LinkedList answer) {
      if (s1 == 0 && s2 == 0)
        return 0;

      if (s1 > s2) {
        int carry = addTwoListsRec(one.next, s1 - 1, two.next, s2, answer);
        int sum = carry + one.data;
        carry = sum / 10;
        answer.addFirst(sum % 10);
        return carry;
      } else {
        int carry = addTwoListsRec(one.next, s1 - 1, two.next, s2 - 1, answer);
        int sum = carry + one.data + two.data;
        carry = sum / 10;
        answer.addFirst(sum % 10);
        return carry;
      }
    }

    public static LinkedList addTwoLists(LinkedList one, LinkedList two) {
      int s1 = one.size;
      int s2 = two.size;
      LinkedList answer = new LinkedList();
      Node nOne = one.head;
      Node nTwo = two.head;

      int carry = 0;
      if (s1 > s2) {
        carry = addTwoListsRec(nOne, s1, nTwo, s2, answer);
      } else {
        carry = addTwoListsRec(nTwo, s2, nOne, s1, answer);
      }

      if (carry == 1)
        answer.addFirst(1);
      return answer;
    }

    int top = 0;

    public void reverseDRHelper(int down, int lsize) {
      if (down == lsize)
        return;

      reverseDRHelper(down + 1, lsize);

      if (top < down) {
        Node Ntop = getNodeAt(top);
        Node Ndown = getNodeAt(down);
        int temp = Ntop.data;
        Ntop.data = Ndown.data;
        Ndown.data = temp;
      }
      top++;
    }

    public void reverseDR() {
      // write your code here
    }

  }

  public static void main(String[] args) throws Exception {

  }
}