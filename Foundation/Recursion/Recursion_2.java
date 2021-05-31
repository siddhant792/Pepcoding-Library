package Recursion;

import java.util.List;
import java.util.ArrayList;

public class Recursion_2 {

    public static void printSubseq_WayUp(String str, String res, int idx) {
        if (idx == str.length()) {
            System.out.println(res);
            return;
        }
        char ch = str.charAt(idx);
        printSubseq_WayUp(str, res + ch, idx + 1);
        printSubseq_WayUp(str, res, idx + 1);
    }

    static String[] char_arr = { "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz" };

    public static void printKPCWay_Up(String str, String res, int idx) {
        if (idx == str.length()) {
            System.out.println(res);
            return;
        }
        String value = char_arr[Integer.parseInt(str.charAt(idx) + "")];
        for (int i = 0; i < value.length(); i++) {
            char ch = value.charAt(i);
            printKPCWay_Up(str, res + ch, idx + 1);
        }
    }

    public static char[] cont = { ' ', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
            'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

    public static void printEncodingWay_Up(String str, String res, int idx) {
        if (idx == str.length() - 1) {
            int ch = Integer.parseInt(str.charAt(idx) + "");
            char ch1 = cont[ch];
            System.out.println(res + ch1);
            return;
        }

        if (idx == str.length()) {
            System.out.println(res);
            return;
        }

        int ch = Integer.parseInt(str.charAt(idx) + "");
        int st = Integer.parseInt(str.substring(idx, idx + 2));
        char ch1 = cont[ch];
        if (ch == 0) {
            return;
        } else {
            printEncodingWay_Up(str, res + ch1, idx + 1);
        }

        if (st <= 26) {
            printEncodingWay_Up(str, res + cont[st], idx + 2);
        }
    }

    public static void permutationHR(String str, String res) {
        if (0 == str.length()) {
            System.out.println(res);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String level = str.substring(0, i) + str.substring(i + 1);
            permutationHR(level, res + ch);
        }
    }

    public static ArrayList<String> printMazeWithJump(int s_row, int s_col, int d_row, int d_col) {
        if (s_row == d_row && s_col == d_col) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> myAns = new ArrayList<>();

        for (int i = 1; i <= d_row; i++) {
            if (s_col + 1 <= d_col) {
                ArrayList<String> horizontal = printMazeWithJump(s_row, s_col + 1, d_row, d_col);
                for (String s : horizontal) {
                    myAns.add("h" + i + s);
                }
            }
        }

        for (int i = 1; i <= d_row; i++) {
            if (s_row + 1 <= d_row) {
                ArrayList<String> vertical = printMazeWithJump(s_row + 1, s_col, d_row, d_col);
                for (String s : vertical) {
                    myAns.add("v" + i + s);
                }
            }
        }
        for (int i = 1; i <= (d_row < d_col ? d_row : d_col); i++) {
            if (s_row + 1 <= d_row && s_col + 1 <= d_col) {
                ArrayList<String> vertical = printMazeWithJump(s_row + 1, s_col + 1, d_row, d_col);
                for (String s : vertical) {
                    myAns.add("d" + i + s);
                }
            }
        }

        return myAns;
    }

    public static ArrayList<String> printMaze(int sr, int sc, int dr, int dc) {
        if (sc == dr && sc == dc) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> myAns = new ArrayList<>();
        if (sr + 1 <= dr) {
            ArrayList<String> horizontal = printMaze(sr + 1, sc, dr, dc);
            for (String e : horizontal) {
                myAns.add("h" + e);
            }
        }

        if (sc + 1 <= dc) {
            ArrayList<String> vertical = printMaze(sr, sc + 1, dr, dc);
            for (String e : vertical) {
                myAns.add("v" + e);
            }
        }
        return myAns;
    }

    public static void printMazeWay_up(int sr, int sc, int dr, int dc, String ans) {
        if (sr == dr && sc == dc) {
            System.out.println(ans);
            return;
        }

        if (sc + 1 <= dc) {
            printMazeWay_up(sr, sc + 1, dr, dc, "h" + ans);
        }

        if (sr + 1 <= dr) {
            printMazeWay_up(sr + 1, sc, dr, dc, "v" + ans);
        }
    }

    public static void printMaze_Way_Up(int sr, int sc, int dr, int dc, String answer) {
        if (sr == dr && sc == dc) {
            System.out.println(answer);
            return;
        }

        for (int i = 1; sc + i <= dc; i++) {
            printMaze_Way_Up(sr, sc + i, dr, dc, answer + "h" + i);
        }

        for (int i = 1; sr + i <= dr; i++) {
            printMaze_Way_Up(sr + i, sc, dr, dc, answer + "v" + i);
        }

        for (int i = 1; sr + i <= dr && sc + i <= dc; i++) {
            printMaze_Way_Up(sr + i, sc + i, dr, dc, answer + "d" + i);
        }
    }

    public static void stairCase(int count, int num, String ans) {
        if (count > num)
            return;
        if (count == num) {
            System.out.println(ans);
            return;
        }

        stairCase(count + 1, num, ans + 1);
        stairCase(count + 2, num, ans + 2);
        stairCase(count + 3, num, ans + 3);
    }

    public static ArrayList<String> stairCaseWay_Down(int count, int num) {
        if (count > num)
            return new ArrayList<>();
        if (count == num) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> myAns = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            ArrayList<String> subAns = stairCaseWay_Down(count + i, num);
            for (String s : subAns) {
                myAns.add(i + s);
            }
        }
        return myAns;
    }

    public static void solution(String str) {
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                boolean flag = true;
                String m = str.substring(i, j + 1);
                int k = 0;
                int l = m.length() - 1;
                while (k <= l) {
                    if (m.charAt(k) != m.charAt(l)) {
                        flag = false;
                        break;
                    }
                    k++;
                    l--;
                }
                if (flag) {
                    System.out.println(m);
                }
            }
        }
    }

    // floid fill algorithm

    public static void floidFill(int sr, int sc, int dr, int dc, boolean[][] option, int[][] dirArr, String[] dirS,
            String ans) {
        if (sr == dr && sc == dc) {
            System.out.println(ans);
            return;
        }

        int n = option.length;
        int m = option[0].length;
        option[sr][sc] = true;

        for (int repeat = 0; repeat < 4; repeat++) {
            int r = sr + dirArr[repeat][0];
            int c = sc + dirArr[repeat][1];
            if (r >= 0 && c >= 0 && r < n && c < m && option[r][c] == false) {
                floidFill(r, c, dr, dc, option, dirArr, dirS, ans + dirS[repeat]);
            }
        }
        option[sr][sc] = false;
    }

    public static void floidFillJump(int sr, int sc, int dr, int dc, boolean[][] option, int[][] dirArr, String[] dirS,
            String ans) {
        if (sr == dr && sc == dc) {
            System.out.println(ans);
            return;
        }

        int n = option.length;
        int m = option[0].length;
        option[sr][sc] = true;

        for (int radius = 1; radius < Math.max(n, m); radius++) {
            for (int repeat = 0; repeat < dirArr.length; repeat++) {
                int r = sr + radius * dirArr[repeat][0];
                int c = sc + radius * dirArr[repeat][1];
                if (r >= 0 && c >= 0 && r < n && c < m && option[r][c] == false) {
                    floidFillJump(r, c, dr, dc, option, dirArr, dirS, ans + dirS[repeat]);
                }
            }
        }
        option[sr][sc] = false;
    }

    public static void KnightMove(int sr, int sc, int move, int tnc, int[][] option, int[][] dirArr) {
        if (move == tnc) {
            option[sr][sc] = move;
            printBoard(option);
            option[sr][sc] = 0;
            return;
        }

        int n = option.length;
        int m = option[0].length;
        option[sr][sc] = move;

        for (int repeat = 0; repeat < dirArr.length; repeat++) {
            int r = sr + dirArr[repeat][0];
            int c = sc + dirArr[repeat][1];
            if (r >= 0 && c >= 0 && r < n && c < m && option[r][c] == 0) {
                KnightMove(r, c, move + 1, tnc, option, dirArr);
            }
        }
        option[sr][sc] = 0;
    }

    public static void printBoard(int[][] chess) {
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess[0].length; j++) {
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int targetSum(int[] arr, int idx, int target) {
        if (idx == arr.length) {
            if (target == 0)
                return 1;
            else
                return 0;
        }

        int ans = 0;
        ans += targetSum(arr, idx + 1, target - arr[idx]);
        ans += targetSum(arr, idx + 1, target + arr[idx]);
        return ans;
    }


    public static boolean isvalid(ArrayList<Integer> A,ArrayList<Integer> B) {
        int sumA = 0;
        int sumB = 0;
        for (int i = 0; i < A.size(); i++) {
            sumA += A.get(i);
        }
        for (int i = 0; i < B.size(); i++) {
            sumB += B.get(i);
        }
        if (sumA == sumB)
            return true;
        else
            return false;

    }

    public static void seprateArrayRec(int[] arr, int idx,ArrayList<Integer> arrA,ArrayList<Integer> arrB) {
        if (idx == arr.length) {
            if (isvalid(arrA, arrB)) {
                System.out.print(arrA + "   =   "+arrB);
                System.out.println();
            }
            return;
        }

        arrA.add(arr[idx]);
        seprateArrayRec(arr,idx+1,arrA,arrB);
        arrA.remove(arrA.indexOf(arr[idx]));
        arrB.add(arr[idx]);
        seprateArrayRec(arr,idx+1,arrA,arrB);
        arrB.remove(arrB.indexOf(arr[idx]));

    }

    public static void main(String[] args) {
        // ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        // int[] arr = {1,2,3};
        // printMaze_Way_Up(0,0,2,2,"");
        // System.out.println(stairCaseWay_Down(0,3));
        // stairCase(0,3,"");
        // solution("abcc");
        // boolean[][] option = new boolean[3][3];
        // int[][] dirArr = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };
        // String[] dirS = { "L", "U", "R", "D" };
        // floidFillJump(0, 0, 2, 2, option, dirArr, dirS, "");
        // int[] arr = { 10, 20, 30, 40, 50, 60, 70};
        // ArrayList<Integer> arrA = new ArrayList<>();
        // ArrayList<Integer> arrB = new ArrayList<>();
        // seprateArrayRec(arr,0,arrA,arrB);

        System.out.println(printMazeWithJump(0,0,2,2));
        //permutationHR("aab","");
        //System.out.println(targetSum(arr, 0, 6));
    }
}
