package DynamicProgramming;

import java.util.Arrays;
import java.util.LinkedList;

public class Dynamic {

    public static void print1D(int[] arr) {
        for (int ele : arr)
            System.out.print(ele + " ");
        System.out.println();
    }

    public static void print2D(int[][] arr) {
        for (int[] a : arr) {
            print1D(a);
        }
        System.out.println();
    }

    public static int fibo_memo(int n, int[] dp) {
        if (n <= 1) {
            dp[n] = n;
            return n;
        }

        if (dp[n] != -1)
            return dp[n];

        int ans = fibo_memo(n - 1, dp) + fibo_memo(n - 2, dp);
        dp[n] = ans;
        return ans;
    }

    public static int fibo_TAB(int N, int[] dp) {
        for (int n = 0; n < N; n++) {
            if (n <= 1) {
                dp[n] = n;
                continue;
            }

            int ans = dp[n - 1] + dp[n - 2];
            dp[n] = ans;
        }
        return dp[N];
    }

    public static int fino_opti(int N) {
        int a = 0, b = 1;
        for (int i = 0; i < N; i++) {
            System.out.print(a + " ");
            int sum = a + b;
            a = b;
            b = sum;
        }
        return a;
    }

    // leetcode 70
    public static int climbStairs(int n, int[] dp) {
        if (n <= 1) {
            return dp[n] = 1;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int ans = climbStairs(n - 1, dp) + climbStairs(n - 2, dp);
        dp[n] = ans;
        return ans;
    }

    public static int climbStairs_TAB(int N, int[] dp) {
        for (int n = 0; n <= N; n++) {
            if (n <= 1) {
                dp[n] = 1;
                continue;
            }

            int step = dp[n - 1] + dp[n - 2];
            dp[n] = step;
        }
        return dp[N];
    }

    // leetcode 746

    public static int minCost(int n, int[] dp, int[] cost) {
        if (n <= 1) {
            return dp[n] = cost[n];
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int step1 = minCost(n - 1, dp, cost);
        int step2 = minCost(n - 2, dp, cost);

        int ans = Math.min(step1, step2) + (n == cost.length ? 0 : cost[n]);
        return dp[n] = ans;
    }

    public static int minCost_TAB(int N, int[] dp, int[] cost) {
        for (int n = 0; n <= N; n++) {
            if (n <= 1) {
                dp[n] = cost[n];
                continue;
            }

            int ans = Math.min(dp[n - 1], dp[n - 2]) + (n == cost.length ? 0 : cost[n]);
            dp[n] = ans;
        }
        return dp[N];
    }

    public static int minCost_Opti(int N, int[] cost) {
        int a = 0, b = 0;
        for (int i = 0; i < N; i++) {
            int sum = Math.min(a, b) + cost[i];
            a = b;
            b = sum;
        }
        return Math.min(a, b);
    }

    // ----------------------------------------->

    public static int wayDiceMemo(int[] dp, int src, int desc) {
        if (src > desc)
            return 0;
        if (src == desc) {
            return dp[src] = 1;
        }

        if (dp[src] != -1) {
            return dp[src];
        }

        int ans = 0;
        for (int i = 1; i <= 6; i++) {
            ans += wayDiceMemo(dp, src + i, desc);
        }
        return dp[src] = ans;
    }

    public static int wayDiceTAB(int N) {
        int[] dp = new int[N + 1];
        for (int n = N; n >= 0; n--) {
            if (n == N) {
                dp[n] = 1;
                continue;
            }

            int ans = 0;
            for (int i = 1; i <= 6; i++) {
                ans += n + i > N ? 0 : dp[n + i];
            }
            dp[n] = ans;
        }
        return dp[0];
    }

    public static int wayDiceOPTI(int N) {
        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(1);
        list.addLast(1);
        for (int i = 2; i <= N; i++) {
            if (i < 7) {
                list.addLast(list.getLast() * 2);
            } else {
                int temp = (list.getLast() * 2) - list.removeFirst();
                list.addLast(temp);
            }
        }

        return list.getLast();
    }

    // maze path with 1 jump
    public static int maze_MEMO(int[][] arr, int row, int col, int[][] dp) {
        if (row == arr.length - 1 && col == arr[0].length - 1) {
            return dp[row][col] = 1;
        }

        if (dp[row][col] != 0)
            return dp[row][col];

        int ans = 0;
        if (row + 1 < arr.length && col + 1 < arr[0].length) {
            ans += maze_MEMO(arr, row + 1, col + 1, dp);
        }

        if (row + 1 < arr.length) {
            ans += maze_MEMO(arr, row + 1, col, dp);
        }

        if (col + 1 < arr[0].length) {
            ans += maze_MEMO(arr, row, col + 1, dp);
        }
        return dp[row][col] = ans;
    }

    public static int maze_MEMO_TAB(int[][] arr, int row, int col, int[][] dp) {
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = arr[0].length - 1; j >= 0; j--) {
                if (row == arr.length - 1 && col == arr[0].length - 1) {
                    dp[row][col] = 1;
                    continue;
                }

                int ans = 0;
                if (row + 1 < arr.length && col + 1 < arr[0].length) {
                    ans += dp[row + 1][col + 1]; // maze_MEMO_TAB(arr, row + 1, col + 1, dp);
                }

                if (row + 1 < arr.length) {
                    ans += dp[row + 1][col]; // maze_MEMO_TAB(arr, row + 1, col, dp);
                }

                if (col + 1 < arr[0].length) {
                    ans += dp[row][col + 1]; // maze_MEMO_TAB(arr, row , col + 1, dp);
                }
                dp[row][col] = ans;
            }
        }
        return dp[0][0];
    }

    // maze with n jump
    public static int mazeJump_Memo(int[][] arr, int row, int col, int[][] dp) {
        if (row == arr.length - 1 && col == arr[0].length - 1) {
            return dp[row][col] = 1;
        }

        if (dp[row][col] != 0) {
            return dp[row][col];
        }

        int ans = 0;

        for (int i = 1; row + i < arr.length && col + i < arr[0].length; i++) {
            ans += mazeJump_Memo(arr, row + i, col + i, dp);
        }

        for (int i = 1; row + i < arr.length; i++) {
            ans += mazeJump_Memo(arr, row + i, col, dp);
        }

        for (int i = 1; col + i < arr[0].length; i++) {
            ans += mazeJump_Memo(arr, row, col + i, dp);
        }

        return dp[row][col] = ans;
    }

    public static int mazeJump_TAB(int[][] arr, int[][] dp) {
        for (int row = arr.length - 1; row >= 0; row--) {
            for (int col = arr[0].length - 1; col >= 0; col--) {
                if (row == arr.length - 1 && col == arr[0].length - 1) {
                    dp[row][col] = 1;
                    continue;
                }

                int ans = 0;
                for (int r = 1; row + r < arr.length && col + r < arr[0].length; r++) {
                    ans += dp[row + r][col + r]; // mazeJump_Memo(arr, row + r, col + r, dp);
                }

                for (int r = 1; row + r < arr.length; r++) {
                    ans += dp[row + r][col]; // mazeJump_Memo(arr, row + r, col , dp);
                }

                for (int r = 1; col + r < arr[0].length; r++) {
                    ans += dp[row][col + r]; // mazeJump_Memo(arr, row , col + r, dp);
                }
                dp[row][col] = ans;
            }
        }
        return dp[0][0];
    }

    public static int friendsPairing(int n, int[] dp) {
        if (n == 0 || n == 1)
            return dp[n] = 1;

        if (dp[n] != 0)
            return dp[n];

        int ans = 0;
        ans += friendsPairing(n - 1, dp);
        ans += friendsPairing(n - 2, dp) * (n - 1);
        return dp[n] = ans;
    }

    public static int friendsPairingTAB(int N, int[] dp) {
        for (int n = 0; n <= N; n++) {
            if (n == 0 || n == 1){
                dp[n] = 1;
                continue;
            }

            int ans = 0;
            ans += dp[n - 1];
            ans += dp[n - 2] * (n - 1);
            dp[n] = ans;
        }
        return dp[N];
    }

    public static int goldMines(int[][] arr, int sr, int sc, int[][] dir, int[][] dp){
        if(sc == arr[0].length - 1){
            return dp[sr][sc] = arr[sr][sc];
        }

        if(dp[sr][sc] != 0) return dp[sr][sc];

        int maxGold = (int) -1e8;
        for(int i = 0 ; i < 3; i++){
            int r = sr + dir[i][0];
            int c = sc + dir[i][1];
            if(r < arr.length && c < arr[0].length && r >=0 && c >= 0){
                int temp = goldMines(arr, r, c, dir, dp);
                maxGold = Math.max(maxGold, temp);
            }
        }
        return dp[sr][sc] = maxGold + arr[sr][sc];
    }

    public static int goldOperator(int[][] arr){
        int maxGold = (int) -1e8;
        int[][] dir = {{1,1},{0,1},{-1,1}};
        int[][] dp = new int[arr.length][arr[0].length];
        for(int i = 0; i < arr.length ; i++){
            int cMax = goldMines(arr, i, 0, dir,dp);
            maxGold = Math.max(maxGold, cMax);
        }
        return maxGold;
    }

    public static int minMazeCost(int[][] arr, int sr, int sc , int[][] dp, int[][] dir){
        if(sr == arr.length - 1 && sc == arr[0].length - 1){
            return dp[sr][sc] = arr[sr][sc];
        }

        if(dp[sr][sc] != 0) return dp[sr][sc];

        int minCost = (int) 1e8;
        for(int i = 0;  i < 2 ; i++){
            int r = sr + dir[i][0];
            int c = sc + dir[i][1];
            if(r < arr.length && c < arr[0].length && r >=0 && c >= 0){
                int temp = minMazeCost(arr, r, c, dp, dir);
                minCost = Math.min(minCost, temp);
            }
        }
        return dp[sr][sc] = minCost + arr[sr][sc];
    }

    // 516
    public static int longestPalindromicSub(String str, int i, int j, int[][] dp){
        if(i == j){
            return dp[i][j] = 1;
        }else if(i > j){
            return dp[i][j] = 0;
        }

        if(dp[i][j] != -1) return dp[i][j];

        if(str.charAt(i) == str.charAt(j)){
            int len = longestPalindromicSub(str, i + 1, j - 1, dp);
            return dp[i][j] = len + 2;
        }else{
            int len1 = longestPalindromicSub(str, i + 1, j, dp);
            int len2 = longestPalindromicSub(str, i, j - 1, dp);
            return dp[i][j] = Math.max(len1, len2);
        }
    }

    public static int longestPalindromicSubDP(String str, int I, int J, int[][] dp){
        for(int gap = 0; gap < str.length() ;gap++){
            for(int i = 0,j = gap; j < str.length() ; i++,j++){
                if(i == j){
                    dp[i][j] = 1;
                    continue;
                }else if(i > j){
                    dp[i][j] = 0;
                    continue;
                }
        
                if(str.charAt(i) == str.charAt(j)){
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                }else{
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[I][J];
    }

    // 647
    public static int paindrmicSubstring(String str, int[][] dp){
        int max = (int) -1e8;
        int count = 0;
        for(int gap = 0 ; gap < str.length() ; gap++){
            for(int i = 0,j = gap; j < str.length() ; i++,j++){
                if(i == j){
                    dp[i][j] = 1;
                    count++;
                    continue;
                }else if(i > j){
                    dp[i][j] = 0;
                    continue;
                }
        
                if(str.charAt(i) == str.charAt(j)){
                    if(j - i + 1 == 2){
                        dp[i][j] = 2;
                        count++;
                    }else{
                        dp[i][j] = (dp[i + 1][j - 1] != 0) ?  dp[i + 1][j - 1] + 2 : 0;
                        if(dp[i][j] != 0)count++;
                    } 
                    max = Math.max(max, dp[i][j]);
                }else{
                    dp[i][j] = 0;
                }
            }
        }

        print2D(dp);

        return count;
    }

    // 1143
    public static int longestCommonSubsequence(String s1, String s2, int i1, int i2, int[][] dp){
        if(i1 == s1.length() || i2 == s2.length()){
            return dp[i1][i2] = 0;
        }

        if(dp[i1][i2] != -1) return dp[i1][i2];

        if(s1.charAt(i1) == s2.charAt(i2)){
            return dp[i1][i2] = longestCommonSubsequence(s1, s2, i1 + 1, i2 + 1, dp) + 1;
        }else{
            int c1 = longestCommonSubsequence(s1, s2, i1 + 1, i2, dp);
            int c2 = longestCommonSubsequence(s1, s2, i1, i2 + 1, dp);
            return dp[i1][i2] = Math.max(c1, c2);
        }
    }

    static int ans = 0;

    // https://practice.geeksforgeeks.org/problems/longest-common-substring1452/1
    public static int longestCommonSubstring(String s1, String s2, int i1, int i2, int[][] dp){
        if(i1 == s1.length() || i2 == s2.length()){
            return dp[i1][i2] = 0;
        }

        if(dp[i1][i2] != -1) return dp[i1][i2];

        if(s1.charAt(i1) == s2.charAt(i2)){
            int t = longestCommonSubstring(s1, s2, i1 + 1, i2 + 1, dp);
            if(i1 == s1.length() - 1 || i2 == s2.length() - 1){
                dp[i1][i2] = 1;
            }else{
                dp[i1][i2] = t == 0 ? 0 : t + 1;
            }
            ans = Math.max(ans, dp[i1][i2]);
            return dp[i1][i2];
        }else{
            int c1 = longestCommonSubstring(s1, s2, i1 + 1, i2, dp);
            int c2 = longestCommonSubstring(s1, s2, i1, i2 + 1, dp);
            return dp[i1][i2] = 0;
        }
    }

    // 1035
    public static int numberMatching(int[] arr1, int[] arr2, int i1, int i2, int[][] dp){
        if(i1 == arr1.length || i2 == arr2.length){
            return dp[i1][i2] = 0;
        }

        if(dp[i1][i2] != -1) return dp[i1][i2];

        if(arr1[i1] == arr2[i2]){
            return dp[i1][i2] = numberMatching(arr1, arr2, i1 + 1, i2 + 1, dp) + 1;
        }else{
            int c1 = numberMatching(arr1, arr2, i1 + 1, i2, dp);
            int c2 = numberMatching(arr1, arr2, i1, i2 + 1, dp);
            return dp[i1][i2] = Math.max(c1, c2);
        }
    }

    // 72
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        for(int[] e : dp) Arrays.fill(e, -1);
        return minDistance(word1, word2, n, m, dp);
    }
    
    public int minDistance(String word1, String word2, int n, int m, int[][] dp) {
        if(n == 0 || m == 0){
            return dp[n][m] = (n == 0 ? m : n);
        }
        
        if(dp[n][m] != -1) return dp[n][m];

        if(word1.charAt(n - 1) == word2.charAt(m - 1)){
            return dp[n][m] = minDistance(word1, word2, n - 1, m - 1, dp);
        }else{
            int insert = minDistance(word1, word2, n, m - 1, dp);
            int replace = minDistance(word1, word2, n - 1, m - 1, dp);
            int delete = minDistance(word1, word2, n - 1, m, dp);
            return dp[n][m] = Math.min(insert, Math.min(replace, delete)) + 1;
        }
    }

    public int minDistanceDP(String word1, String word2, int N, int M, int[][] dp) {
        for(int n = 0; n < N ;n++){
            for(int m = 0; m < M ; m++){
                if(n == 0 || m == 0){
                    dp[n][m] = (n == 0 ? m : n);
                    continue;
                }
                
                if(word1.charAt(n - 1) == word2.charAt(m - 1)){
                    return dp[n][m] = dp[n - 1][m - 1];//minDistance(word1, word2, n - 1, m - 1, dp);
                }else{
                    int insert = dp[n][m - 1];//minDistance(word1, word2, n, m - 1, dp);
                    int replace = dp[n - 1][m - 1];//minDistance(word1, word2, n - 1, m - 1, dp);
                    int delete = dp[n - 1][m];//minDistance(word1, word2, n - 1, m, dp);
                    return dp[n][m] = Math.min(insert, Math.min(replace, delete)) + 1;
                }
            }
        }
        return dp[N][M];
    }

    /// upgradation

    public int minCostToConvert_DP(String s1, String s2, int N, int M, int[][] dp, int[] cost) {
        for (int n = 0; n <= N; n++) {
            for (int m = 0; m <= M; m++) {
                if (n == 0) {
                    dp[n][m] =  m + cost[0];
                    continue;
                }else if(m == 0){
                    dp[n][m] =  n + cost[2];
                    continue;
                }

                int insert = dp[n][m - 1];// minDistance(s1, s2, n, m - 1, dp);
                int replace = dp[n - 1][m - 1];// minDistance(s1, s2, n - 1, m - 1, dp);
                int delete = dp[n - 1][m];// minDistance(s1, s2, n - 1, m, dp);

                if (s1.charAt(n - 1) == s2.charAt(m - 1))
                    dp[n][m] = replace;
                else
                    dp[n][m] = Math.min(Math.min(insert + cost[0], replace + cost[1]), delete + cost[2]);
            }
        }

        return dp[N][M];
    }

    public int minCostToConvert(String word1, String word2, int[] cost) {
        int n = word1.length(), m = word2.length();

        int[][] dp = new int[n + 1][m + 1];
        for (int[] d : dp)
            Arrays.fill(d, -1);

        int ans = minCostToConvert_DP(word1, word2, n, m, dp, cost);
        return ans;
    }

    public static int minimumNumberOfDeletions(String S, int i, int j, int[][] dp){
        if(i >= j){
            return dp[i][j] = 0;
        }

        if(dp[i][j] != -1) return dp[i][j];

        if(S.charAt(i) == S.charAt(j)){
            return dp[i][j] = minimumNumberOfDeletions(S, i + 1, j - 1, dp);
        }else{
            int c1 = minimumNumberOfDeletions(S, i + 1, j, dp);
            int c2 = minimumNumberOfDeletions(S, i, j - 1, dp);
            return dp[i][j] = Math.min(c1, c2) + 1;
        }
    }

    public static void main(String[] args) {

        int[][] dp = new int[8][8];
        //System.out.println(friendsPairingTAB(4, dp));
        // print1D(dp);
        for(int[] e : dp){
            Arrays.fill(e, -1);
        }
        System.out.println(numberMatching(new int[]{2,5,1,2,5}, new int[]{10,5,2,1,5,2}, 0, 0, dp));
    }
}
