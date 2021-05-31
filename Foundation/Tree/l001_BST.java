package PepCoding.Foundation.Tree;

import java.sql.Array;
import java.util.ArrayList;

public class l001_BST {
    public static class Node{
        int data = 0;
        Node left = null;
        Node right = null;

        Node(int data){
            this.data = data;
        }
    }

    public static Node constructTree(int[] arr, int si, int ei){
        if(si > ei) return null;

        int mid = (si + ei)/2;
        Node node = new Node(arr[mid]);

        node.left = constructTree(arr,si,mid-1);
        node.right = constructTree(arr,mid-1,ei);
        return node;
    }

    public static Node constructTree(int[] arr){
        return constructTree(arr, 0, arr.length - 1);
    }

    public static int size(Node root){
        if(root == null) return 0;

        int left = size(root.left);
        int right = size(root.right);

        return left + right + 1;
    }

    public static int height(Node root){
        if(root == null) return -1;

        int left = height(root.left);
        int right = height(root.right);

        return Math.max(left, right) + 1;
    }

    public static int maximum(Node root){
        if(root.right == null) return root.data;

        return maximum(root.right);
    }

    public static int minimum(Node root){
        if(root.left == null) return root.data;

        return minimum(root.left);
    }

    public static int sum(Node root){
        if(root == null) return 0;

        int left = sum(root.left);
        int right = sum(root.right);
        return left + right + root.data;
    }

    public static boolean find(Node node,int data){

        Node current = node;
        while(current != null){
            if(data == current.data) return true;
            else if(data > current.data) current = current.right;
            else current = current.left;
        }
        return false;
    }

    public static Node addNode(Node node,int data){
        if(node == null) return new Node(data);
        Node current = node;
        Node ans = new Node(data);
        while(true){
            if(data > current.data){
                if(current.right != null){
                    current = current.right;
                }else{
                    current.right = ans;
                    break;
                }
            }
            else{
                if(current.left != null){
                    current = current.left;
                }else{
                    current.left = ans;
                    break;
                }
            }
        }
        return node;
    }

    public static Node addNodeRec(Node root,int data){
        if(root == null) return new Node(data);

        if(data < root.data) root.left = addNodeRec(root.left,data);
        else root.right = addNodeRec(root.right,data);
        return root;
    }

    //My code

    public static int lcaOfBST(Node root, int d1, int d2){
        Node current = root;
        while(true){
            if((d1 <= current.data && d2 >= current.data) || (d1 >= current.data && d2 <= current.data)) return current.data;
            else if(d1 < current.data && d2 < current.data) current = current.left;
            else current = current.right;
        }
    }

    //Sir's code

    public static Node lcaOfBST2(Node root, int d1, int d2){
        Node current = root;
        while(true){
            if(d1 < current.data && d2 < current.data) current = current.left;
            else if(d1 > current.data && d2 > current.data) current = current.right;
            return (find(current, d1) && find(current, d2)) ? current : null;
        }
    }

    //lca in binary tree

    //My Approach

    public boolean findData(Node root, int data) {
        if (root == null)
            return false;

        boolean res = root.data == data;
        return res || findData(root.left, data) || findData(root.right, data);
    }

    public Node lowestCommonAncestor(Node root, Node d1, Node d2){
        Node current = root;
        while(true){
            if(current == null) return null;
            boolean f1 = findData(current.left,d1.data);
            boolean f2 = findData(current.left,d2.data);
            if(f1 && f2){
                current = current.left;
            }else if(!f1 && !f2 && d1.data != current.data && d2.data != current.data){
                current = current.right;
            }else{
                return current;
            }
        }
    }

    //Sir's approach

    public static boolean rootToNodePath(Node root, int data, ArrayList<Node> ans) {
        if (root == null)
            return false;

        boolean res = root.data == data || rootToNodePath(root.left, data, ans)
                || rootToNodePath(root.right, data, ans);
        if (res)
            ans.add(root);
        return res;
    }

    public static Node lowestCommonAncestor2(Node root, Node d1, Node d2){
        ArrayList<Node> a1 = new ArrayList<>();
        ArrayList<Node> a2 = new ArrayList<>();
        rootToNodePath(root,d1.data,a1);
        rootToNodePath(root,d2.data,a2);

        int i = a1.size()-1,j = a2.size()-1;
        Node myAns = null;
        while(i >= 0 && j >= 0){
            if(a1.get(i) != a2.get(j)) break;
            else myAns = a1.get(i);
            i--;
            j--;
        }
        return myAns;
    }

    public static void printInRange(Node root, int d1, int d2){
        if(root == null) return;

        if(root.data >= d1 && root.data <= d2){
            printInRange(root.left, d1, d2);
            System.out.print(root.data + " ");
            printInRange(root.right, d1, d2);
        }

        if(root.data > d2){
            printInRange(root.left, d1, d2);
        }

        if(root.data < d1){
            printInRange(root.right, d1, d2);
        }
    }

    public static Node removeNode(Node root, int data){
        if(root == null) return null;

        if(root.data < data) root.right =  removeNode(root.right, data);
        else if(root.data > data) root.left = removeNode(root.left, data);
        else{
            if(root.left == null || root.right == null) return root.left!=null ? root.left : root.right;

            int maxData = maximum(root.left);
            root.data = maxData;
            root.left = removeNode(root.left,maxData);
        }
        return root;
    }

    public static void inOrderBST(Node root, ArrayList<Integer> arr){
        if(root == null) return;

        inOrderBST(root.left,arr);
        arr.add(root.data);
        inOrderBST(root.right,arr);
    }

    public static void targetSum(Node root, int target){
        
        ArrayList<Integer> list = new ArrayList<>();
        inOrderBST(root,list);
        int i = 0, j = list.size()-1;
        while(i < j){
            int sum = list.get(i) + list.get(j);
            if(sum > target) j--;
            else if(sum < target) i++;
            else{
                System.out.print(list.get(i) + " " + list.get(j));
                i++;
                j--;
            }
        }
        
    }

}
