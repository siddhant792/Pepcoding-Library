
import java.util.ArrayList;

public class l001_GT {
    public static class Node {
        int data;
        ArrayList<Node> childs;

        Node(int data) {
            this.data = data;
        }
    }

    public static int size(Node root) {
        int sz = 0;
        for (Node child : root.childs) {
            sz += size(child);
        }

        return sz + 1;
    }

    public static int height(Node root) {
        int h = -1;
        for (Node child : root.childs) {
            h = Math.max(h, height(child));
        }

        return h + 1;
    }

    public static int maximum(Node root) {
        int max = -(int) 1e8;

        for (Node child : root.childs) {
            max = Math.max(max, Math.max(maximum(child), child.data));
        }
        return max;
    }

    public static int minimum(Node root) {
        int max = (int) 1e8;

        for (Node child : root.childs) {
            max = Math.min(max, Math.min(minimum(child), child.data));
        }
        return max;
    }

    public static boolean find(Node root, int data) {
        if (root.data == data)
            return true;

        for (Node child : root.childs) {
            boolean ans = find(child, data);
            if (ans)
                return true;
        }
        return false;
    }

    public static boolean rootToNodePath(Node root, int data, ArrayList<Node> arr) {
        boolean myAns = root.data == data;

        for (Node child : root.childs) {
            myAns = myAns || rootToNodePath(child, data, arr);
            if (myAns)
                break;
        }

        if (myAns)
            arr.add(root);

        return myAns;
    }

    public static int lcaGT(Node root, int d1, int d2) {
        ArrayList<Node> list1 = new ArrayList<>();
        rootToNodePath(root, d1, list1);

        ArrayList<Node> list2 = new ArrayList<>();
        rootToNodePath(root, d2, list2);

        int i = list1.size() - 1, j = list2.size() - 1;
        Node lcaNode = null;
        while (i >= 0 && j >= 0) {
            if (list1.get(i) != list2.get(j))
                break;
            else
                lcaNode = list1.get(i);
            i--;
            j--;
        }
        return lcaNode.data;
    }

    public static int distanceBetweenNodes(Node root, int d1, int d2) {
        ArrayList<Node> list1 = new ArrayList<>();
        rootToNodePath(root, d1, list1);

        ArrayList<Node> list2 = new ArrayList<>();
        rootToNodePath(root, d2, list2);

        int i = list1.size() - 1, j = list2.size() - 1;
        int LCADistance = 0;
        while (i >= 0 && j >= 0) {
            if (list1.get(i) != list2.get(j))
                break;
            else
                LCADistance++;
            i--;
            j--;
        }
        return list1.size() + list2.size() - 2 * LCADistance;
    }

    public static Node getTail(Node node) {
        Node curr = node;
        while (curr.childs.size() != 0) {
            curr = curr.childs.get(0);
        }
        return curr;
    }

    public static void linerarizeTree(Node root) {
        for (Node child : root.childs) {
            linerarizeTree(child);
        }

        for (int i = root.childs.size() - 2; i >= 0; i--) {
            Node tail = getTail(root.childs.get(i));
            tail.childs.add(root.childs.get(i + 1));
            root.childs.remove(i + 1);
        }
    }

    public static Node linearizeTreeBetter(Node root) {
        if (root.childs.size() == 0)
            return root;
        Node gNode = linearizeTreeBetter(root.childs.get(root.childs.size() - 1));
        for (int i = root.childs.size() - 1; i >= 0; i--) {
            Node tail = linearizeTreeBetter(root.childs.get(i));
            if (i + 1 != root.childs.size()) {
                tail.childs.add(root.childs.get(i + 1));
                root.childs.remove(i + 1);
            }
        }
        return gNode;
    }

    static int ceil;
    static int floor;

    public static void ceilAndFloor(Node root, int data) {

        if (root.data > data && root.data < ceil)
            ceil = root.data;
        if (root.data < data && root.data > floor)
            floor = root.data;

        for (Node child : root.childs) {
            ceilAndFloor(child, data);
        }
    }

    public static void displayTree(Node root) {

        System.out.println(root.data + " ->");

        for (Node child : root.childs) {
            System.out.print(child.data + ", ");
        }

        for (Node child : root.childs) {
            displayTree(child);
        }
    }

    public static int kthLargestElementHelper(Node root, int bound) {
        int currentMAx = (int) -1e8;
        for (Node child : root.childs) {
            int cMax = kthLargestElementHelper(child, bound);
            currentMAx = Math.max(currentMAx, cMax);
        }
        if (root.data < bound) {
            currentMAx = Math.max(currentMAx, root.data);
        }
        return currentMAx;
    }

    public static int kThLargestElement(Node root, int k) {
        int kThMax = (int) 1e8;
        while (k-- > 0) {
            kThMax = kthLargestElementHelper(root, kThMax);
        }
        return kThMax;
    }

    public static boolean areMirror(Node n1, Node n2) {
        if(n1.childs.size() != n2.childs.size()) return false;
        for (int i = 0, j = n2.childs.size() - 1; j >= 0; i++, j--) {
            return areMirror(n1.childs.get(i),n2.childs.get(j));
        }
        return true;
    }

    public static boolean areSimiliar(Node n1, Node n2) {
        if(n1.childs.size() != n2.childs.size()) return false;
        for (int i = 0;i<n1.childs.size();i++){
            return areSimiliar(n1.childs.get(i),n2.childs.get(i));
        }
        return true;
    }

    public static Node removeLeaves(Node node) {
        if(node.childs.isEmpty()) return null;

        ArrayList<Node> myAns = new ArrayList<>();
        for(int i = 0;i < node.childs.size() ;i++){
            Node curr = removeLeaves(node.childs.get(i));
            if(curr != null) myAns.add(curr);
        }
        node.childs = myAns;
        return node;
    }

}
