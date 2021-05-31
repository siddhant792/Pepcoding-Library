package Stack;

import java.util.Arrays;
import java.util.Stack;

public class Questions {

    public static boolean isBalancedBracket(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[')
                stack.push(ch);
            else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty())
                    return false;
                else if (stack.peek() == '(' && ch != ')')
                    return false;
                else if (stack.peek() == '{' && ch != '}')
                    return false;
                else if (stack.peek() == '[' && ch != ']')
                    return false;
                else
                    stack.pop();
            }
        }
        return stack.isEmpty();
    }


    // Next Greater on Right
    public static int[] nextgreaterElementRight(int[] arr) {
        Stack<Integer> stack = new Stack();
        int[] myAns = new int[arr.length];
        Arrays.fill(myAns, -1);
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                myAns[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        return myAns;
    }

    // Next Greater on Left
    public static int[] nextgreaterElementLeft(int[] arr) {
        Stack<Integer> stack = new Stack();
        int[] myAns = new int[arr.length];
        Arrays.fill(myAns, -1);
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                myAns[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        return myAns;
    }

    // Next Smaller on Right
    public static int[] nextSmallerOnRight(int[] arr) {
        Stack<Integer> stack = new Stack();
        int[] myAns = new int[arr.length];
        Arrays.fill(myAns, arr.length);
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                myAns[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        return myAns;
    }

    // Next Smaller on Left
    public static int[] nextSamllerElementLeft(int[] arr) {
        Stack<Integer> stack = new Stack();
        int[] myAns = new int[arr.length];
        Arrays.fill(myAns, -1);
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                myAns[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        return myAns;
    }

    // public static int[] getSmallestTower(int[] arr) {
    //     int smallest = (int) 1e8;
    //     int[] myAns = new int[arr.length];
    //     for (int i = 0; i < arr.length; i++) {
    //         if (arr[i] < smallest) {
    //             smallest = arr[i];
    //         }
    //         myAns[i] = smallest;
    //     }
    //     return myAns;
    // }

    // public static int histogramArea(int[] arr) {
    //     int MaxArea = 0;
    //     int[] smallestTower = getSmallestTower(arr);
    //     for (int i = 0; i < arr.length; i++) {
    //         if(arr[i] > MaxArea){
    //             MaxArea  = arr[i];
    //         }
    //         if(smallestTower[i]*i > MaxArea){
    //             MaxArea  = smallestTower[i]*i;
    //         }
    //     }
    //     return MaxArea;
    // }

    public static int histogramArea(int[] arr){
        int maxArea = (int) -1e8;
        int[] smallerLeft = nextSamllerElementLeft(arr);
        int[] smallerRight = nextSmallerOnRight(arr);
        for(int i = 0; i < arr.length ; i++){
            maxArea = Math.max(smallerRight[i] - smallerLeft[i] - 1,maxArea);
        }
        return maxArea;
    }

    public static boolean duplicateBrackets(String str) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < str.length() ; i++ ){
            char ch = str.charAt(i);
            if(ch != ')') stack.push(ch);
            else{
                boolean flag = false;
                while(stack.peek() != '('){
                    flag = true;
                    stack.pop();
                }

                if(!flag) return true;
                stack.pop();
            }
        }
        return false;
    }

    //leetcode 42

    public static int[] nextgreaterElementRightWater(int[] arr) {
        int[] myAns = new int[arr.length];
        Arrays.fill(myAns, -1);
        int greatest = (int) -1e8;
        int idxG = -1;
        for(int i = arr.length - 1 ; i >= 0 ; i--){
            if(arr[i] >= greatest){
                greatest = arr[i];
                idxG = i;
            }else{
                myAns[i] = idxG;
            }
        }
        return myAns;
    }

    public static int[] nextgreaterElementLeftWater(int[] arr) {
        int[] myAns = new int[arr.length];
        Arrays.fill(myAns, -1);
        int greatest = (int) -1e8;
        int idxG = -1;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] >= greatest){
                greatest = arr[i];
                idxG = i;
            }else{
                myAns[i] = idxG;
            }
        }
        return myAns;
    }

    public static int getTrappedWater(int[] arr){
        int[] gLeft = nextgreaterElementLeftWater(arr);
        int[] gRight = nextgreaterElementRightWater(arr);

        int myArea = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if(gLeft[i] != -1 && gRight[i] != -1){
                int minBar = Math.min(arr[gLeft[i]], arr[gRight[i]]);
                myArea+=minBar - arr[i];
            }
        }
        return myArea;
    }

    public static void main(String[] args) {
        int[] arr = {4,2,3};
        System.out.println(getTrappedWater(arr));
    }
}
