import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class l001_Tree {

    public static class Node {
        int data = 0;
        Node left = null;
        Node right = null;

        Node(int data) {
            this.data = data;
        }
    }

    public static void preOrderTraversal(Node root, ArrayList<Integer> ans) {
        if (root == null)
            return;

        ans.add(root.data);
        preOrderTraversal(root.left, ans);
        preOrderTraversal(root.right, ans);
    }

    public static void inOrderTraversal(Node root, ArrayList<Integer> ans) {
        if (root == null)
            return;

        inOrderTraversal(root.left, ans);
        ans.add(root.data);
        inOrderTraversal(root.right, ans);
    }

    public static void postOrderTraversal(Node root, ArrayList<Integer> ans) {
        if (root == null)
            return;

        postOrderTraversal(root.left, ans);
        postOrderTraversal(root.right, ans);
        ans.add(root.data);
    }

    // Basic Functions

    public static int size(Node root) {
        if (root == null)
            return 0;

        int left = size(root.left);
        int right = size(root.right);
        return left + right + 1;
    }

    // By Default

    public static int height(Node root) {
        if (root == null)
            return -1;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static int heigthInTermsOfNode(Node root) {
        if (root == null)
            return 0;

        int leftHeight = heigthInTermsOfNode(root.left);
        int rightHeight = heigthInTermsOfNode(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static int maximum(Node root) {
        if (root == null)
            return -(int) 1e8;

        int lMax = maximum(root.left);
        int rMax = maximum(root.right);
        return Math.max(Math.max(lMax, rMax), root.data);
    }

    public static int minimum(Node root) {
        if (root == null)
            return (int) 1e8;

        int lMin = minimum(root.left);
        int rMin = minimum(root.right);
        return Math.min(Math.min(lMin, rMin), root.data);
    }

    public static int sum(Node root) {
        if (root == null)
            return 0;

        int lSum = sum(root.left);
        int rSum = sum(root.right);
        return lSum + rSum + root.data;
    }

    public static boolean findData(Node root, int data) {
        if (root == null)
            return false;

        boolean res = root.data == data;
        return res || findData(root.left, data) || findData(root.right, data);
    }

    public static boolean rootToNodePath(Node root, int data, ArrayList<Node> ans) {
        if (root == null)
            return false;

        boolean res = root.data == data || rootToNodePath(root.left, data, ans)
                || rootToNodePath(root.right, data, ans);
        if (res)
            ans.add(root);
        return res;
    }

    public static void printAtKDepth(Node root, int k, Node block, ArrayList<Integer> ans) {
        if (root == null || root == block || k < 0)
            return;

        if (k == 0) {
            ans.add(root.data);
            return;
        }

        printAtKDepth(root.left, k - 1, block, ans);
        printAtKDepth(root.right, k - 1, block, ans);
    }

    public static ArrayList<Integer> distanceK(Node root, Node target, int K) {
        ArrayList<Node> path = new ArrayList<>();
        ArrayList<Integer> myAns = new ArrayList<>();
        rootToNodePath(root, target.data, path);

        Node block = null;
        for (int i = 0; i < path.size(); i++) {
            printAtKDepth(path.get(i), K - i, block, myAns);
            block = path.get(i);
        }
        return myAns;
    }

    public static void printSingleChildNodes(Node node, Node parent) {
        if (node == null)
            return;

        if (parent != null && (parent.left == null || parent.right == null)) {
            System.out.println(node.data);
        }
        printSingleChildNodes(node.left, node);
        printSingleChildNodes(node.right, node);
    }

    public static Node removeLeaves(Node node) {
        if (node == null)
            return null;

        if (node.left == null && node.right == null)
            return null;

        node.left = removeLeaves(node.left);
        node.right = removeLeaves(node.right);
        return node;
    }

    public static boolean isABinarySearchTree(Node root) {
        if (root.left == null && root.right == null)
            return true;

        if (root.left.data < root.data && root.right.data > root.data) {
            return isABinarySearchTree(root.left) || isABinarySearchTree(root.right);
        } else
            return false;
    }

    public static class isBST {
        int height = -1;
        boolean isBal = true;
    }

    public static isBST isBal_Pair(Node root) {
        if (root == null)
            return new isBST();

        isBST left = isBal_Pair(root.left);
        if (!left.isBal)
            return left;
        isBST right = isBal_Pair(root.right);
        if (!right.isBal)
            return right;

        isBST myAns = new isBST();
        myAns.isBal = false;
        if (left.isBal && right.isBal && Math.abs(left.height - right.height) <= 1) {
            myAns.isBal = true;
            myAns.height = Math.max(left.height, right.height) + 1;
        }

        return myAns;
    }

    public static class BinarySearchTree {
        int maxEle = -(int) 1e8;
        int minEle = (int) 1e8;
        boolean isBST = true;
        int height = -1;
        boolean isBalanced = true;
        Node largestNode = null;
        int largestBSTSize = 0;
        int totalBST = 0;
    }

    public static BinarySearchTree BinarySearchData(Node root) {
        if (root == null)
            return new BinarySearchTree();

        BinarySearchTree left = BinarySearchData(root.left);
        BinarySearchTree right = BinarySearchData(root.right);

        BinarySearchTree myAns = new BinarySearchTree();

        // init

        myAns.isBST = left.isBST && right.isBST && left.maxEle < root.data && right.minEle > root.data;
        myAns.isBalanced = left.isBalanced && right.isBalanced && Math.abs(left.height - right.height) <= 1;

        myAns.maxEle = Math.max(root.data, right.maxEle);
        myAns.minEle = Math.min(root.data, left.minEle);
        myAns.height = Math.max(left.height, right.height) + 1;

        myAns.totalBST = left.totalBST + right.totalBST + (myAns.isBST ? 1 : 0);

        if (myAns.isBST) {
            myAns.largestNode = root;
            myAns.largestBSTSize += left.largestBSTSize + right.largestBSTSize + 1;
        } else {
            if (left.largestBSTSize > right.largestBSTSize) {
                myAns.largestNode = left.largestNode;
                myAns.largestBSTSize = left.largestBSTSize;
            } else {
                myAns.largestNode = right.largestNode;
                myAns.largestBSTSize = right.largestBSTSize;
            }
        }
        return myAns;
    }

    public static class Treetilt {
        int tilt = 0;
        int sum = 0;
    }

    public static Treetilt tiltOfATree(Node root) {
        if (root == null)
            return new Treetilt();

        Treetilt left = tiltOfATree(root.left);
        Treetilt right = tiltOfATree(root.right);

        Treetilt myAns = new Treetilt();
        myAns.tilt = Math.abs(left.sum - right.sum) + left.tilt + right.tilt;
        myAns.sum = left.sum + right.sum + root.data;
        return myAns;
    }

    // leet code 404

    public int sumOfLeftLeaves(Node root) {
        if (root == null)
            return 0;

        int myAns = 0;

        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                myAns += root.left.data;
            } else {
                myAns += sumOfLeftLeaves(root.left);
            }
        }

        if (root.right != null) {
            if (root.right.left != null || root.right.right != null) {
                myAns += sumOfLeftLeaves(root.right);
            }
        }

        return myAns;
    }

    // leet code 1302

    public int deepestLeavesSum(Node root) {
        if (root == null)
            return 0;

        int myAns = 0;

        myAns += deepestLeavesSum(root.left);
        myAns += deepestLeavesSum(root.right);

        return myAns + (root.left == null && root.right == null ? root.data : 0);
    }

    // leetcode 112

    public boolean pathSum(Node root, int target, int current) {
        if (root == null)
            return false;
        if (root.left == null && root.right == null)
            return current + root.data == target ? true : false;

        return pathSum(root.left, target, current + root.data) || pathSum(root.right, target, current + root.data);
    }

    // leetcode 113

    // public List<List<Integer>> pathSum2(Node root, int target){

    // }

    // gfg

    static long myAns = 0;

    public static void rootToLeafSum(Node root, long sum) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            myAns += (sum * 10 + root.data);
            return;
        }
        rootToLeafSum(root.left, sum * 10 + root.data);
        rootToLeafSum(root.right, sum * 10 + root.data);
    }

    // Max Level Sum in Binary Tree - GFG

    static ArrayList<Integer> myArr = new ArrayList<>();

    public void maxLevelSum(Node root, int level) {
        if (root == null)
            return;

        if (myArr.size() > level)
            myArr.set(level, myArr.get(level) + root.data);
        else
            myArr.add(root.data);
        maxLevelSum(root.left, level + 1);
        maxLevelSum(root.right, level + 1);
    }

    // Odd even level difference - GFG

    static int odd = 0, even = 0;

    public static void sumOfOddEven(Node root, int level) {
        if (root == null)
            return;

        if (level % 2 != 0)
            odd += root.data;
        else
            even += root.data;

        sumOfOddEven(root.left, level + 1);
        sumOfOddEven(root.right, level + 1);
    }

    // Maximum Node Level - GFG

    static ArrayList<Integer> cont = new ArrayList<>();

    public static void maxNodeLevel(Node root, int level) {
        if (root == null)
            return;

        if (cont.size() > level)
            cont.set(level, cont.get(level) + 1);
        else
            cont.add(1);
        maxNodeLevel(root.left, level + 1);
        maxNodeLevel(root.right, level + 1);
    }

    // Count Number of SubTrees having given Sum - GFG

    static int myAns_ = 0;

    public static int subTreeSum(Node root, int X) {
        if (root == null)
            return 0;

        int left = subTreeSum(root.left, X);
        int right = subTreeSum(root.right, X);

        if (left + right + root.data == X)
            myAns_++;

        return left + right + root.data;
    }

    // Diameter of Binary Tree - GFG

    static int max_Dia = 0;

    public static int diameterOfTree(Node root) {
        if (root == null)
            return 0;

        int left = diameterOfTree(root.left);
        int right = diameterOfTree(root.right);

        if (left + right + 1 > max_Dia)
            max_Dia = left + right + 1;

        return Math.max(left, right) + 1;
    }

    // Maximum Path Sum between 2 Leaf Nodes - GFG

    static int max_val = (int) -1e8;

    public static int maxPathSum2(Node root) {
        if (root == null)
            return (int) -1e8;
        if (root.left == null && root.right == null)
            return root.data;

        int left = maxPathSum2(root.left);
        int right = maxPathSum2(root.right);

        if (left + right + root.data > max_val && (root.left != null && root.right != null))
            max_val = left + right + root.data;

        return (left + root.data > right + root.data ? left + root.data : right + root.data);
    }

    // Node at distance - GFG

    static ArrayList<Integer> nodeCon = new ArrayList<>();

    public static void parentNodeDist(Node root, int k, int h) {
        if (root == null)
            return;

        if (nodeAtDistance(root, k)) {
            nodeCon.add(h, 1);
        } else
            nodeCon.add(h, 0);

        parentNodeDist(root.left, k, h + 1);
        parentNodeDist(root.right, k, h + 1);
    }

    public static boolean nodeAtDistance(Node root, int k) {
        if (root == null)
            return false;
        if (root.left == null && root.right == null) {
            if (k == 0)
                return true;
            else
                return false;
        }

        return nodeAtDistance(root.left, k - 1) || nodeAtDistance(root.right, k - 1);
    }

    // Sum of Leaf Nodes at Min Level - GFG

    static ArrayList<Integer> nodeSum = new ArrayList<>();

    public static void sumOfNodesAtMin(Node root, int h) {
        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            if (nodeSum.size() <= h)
                nodeSum.add(root.data);
            else
                nodeSum.set(h, nodeSum.get(h) + root.data);
        } else {
            if (nodeSum.size() <= h)
                nodeSum.add(0);
        }

        sumOfNodesAtMin(root.left, h + 1);
        sumOfNodesAtMin(root.right, h + 1);
    }

    // Nodes at given distance in binary tree- GFG

    public static void nodesAtDist(Node root, int target, int k) {
        ArrayList<Node> path = new ArrayList<>();
        rootToNodePath(root, target, path);
        ArrayList<Integer> answer = new ArrayList<>();
        Node targ = null;
        for(int i=0;i<path.size();i++){
            nodeFinder(path.get(i),targ,k - i,answer);
            targ = path.get(i);
        }
        
    }

    public static void nodeFinder(Node root, Node targ, int k, ArrayList<Integer> ans) {
        if (root == null || root == targ || k < 0) return;

        if(k == 0) ans.add(root.data);

        nodeFinder(root.left, targ, k - 1, ans);
        nodeFinder(root.right, targ, k - 1, ans);
    }

}
