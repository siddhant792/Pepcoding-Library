package PepCoding.LevelUp.Recursion;

import java.util.*;

public class Recursion {

    public static class Pair {
        String longestPath = "";
        String shortestPath = "";

        int longestPathLen = 0;
        int shortestPathLen = 0;

        Pair(int longestPathLen, int shortestPathLen) {
            this.longestPathLen = longestPathLen;
            this.shortestPathLen = shortestPathLen;
        }

        @Override
        public String toString() {
            return "Longest : " + longestPath + " Shortest : " + shortestPath;
        }
    }

    public static int floidFill(int sr, int sc, int dr, int dc, int[][] dir, String[] dir_str, String path,
            boolean[][] vis) {
        if (sr == dr && sc == dc) {
            System.out.println(path);
            return 1;
        }

        int count = 0;
        vis[sr][sc] = true;
        for (int d = 0; d < dir.length; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];
            if (r < vis.length && c < vis[0].length && r >= 0 && c >= 0 && !vis[r][c]) {
                count += floidFill(r, c, dr, dc, dir, dir_str, path + dir_str[d], vis);
            }
        }
        vis[sr][sc] = false;
        return count;
    }

    public static Pair floidFillPathMaker(int sr, int sc, int dr, int dc, int[][] dir, String[] dir_str,
            boolean[][] vis) {
        if (sr == dr && sc == dc) {
            return new Pair(0, 0);
        }

        vis[sr][sc] = true;
        Pair ans = new Pair((int) -1e8, (int) 1e8);
        for (int d = 0; d < dir.length; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];
            if (r < vis.length && c < vis[0].length && r >= 0 && c >= 0 && !vis[r][c]) {
                Pair temp = floidFillPathMaker(r, c, dr, dc, dir, dir_str, vis);
                if (temp.longestPathLen + 1 > ans.longestPathLen) {
                    ans.longestPath = dir_str[d] + temp.longestPath;
                    ans.longestPathLen = temp.longestPathLen + 1;
                }

                if (temp.shortestPathLen + 1 < ans.shortestPathLen) {
                    ans.shortestPath = dir_str[d] + temp.shortestPath;
                    ans.shortestPathLen = temp.shortestPathLen + 1;
                }
            }
        }
        vis[sr][sc] = false;
        return ans;
    }

    public static int floidFillWithCost(int sr, int sc, int dr, int dc, int[][] dir, boolean[][] vis, int[] dir_cost) {
        if (sr == dr && sc == dc) {
            return 0;
        }

        int cost = (int) 1e8;
        vis[sr][sc] = true;
        for (int d = 0; d < dir.length; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];
            if (r < vis.length && c < vis[0].length && r >= 0 && c >= 0 && !vis[r][c]) {
                cost = Math.min(floidFillWithCost(r, c, dr, dc, dir, vis, dir_cost) + dir_cost[d], cost);
            }
        }
        vis[sr][sc] = false;
        return cost;
    }

    // <---------------------------------------------------------------------------------------------------------------------->

    // <---------------------------------------Binomial
    // method---------------------------------------------->

    public static int permutationWithInfy(int[] arr, int target, String ans) {
        if (target < 0)
            return 0;
        if (target == 0) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            count += permutationWithInfy(arr, target - arr[i], ans + arr[i]);
        }
        return count;
    }

    public static int permutationWithSingle(int[] arr, int target, String ans, boolean[] vis, int idx) {
        if (target < 0)
            return 0;
        if (target == 0) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for (int i = idx; i < arr.length; i++) {
            if (!vis[i]) {
                vis[i] = true;
                count += permutationWithSingle(arr, target - arr[i], ans + arr[i], vis, 0);
                vis[i] = false;
            }
        }
        return count;
    }

    public static int combinationWithInfy(int[] arr, int target, String ans, int idx) {
        if (idx == arr.length || target < 0)
            return 0;
        if (target == 0) {
            System.out.println(ans);
            return 1;
        }
        int count = 0;
        for (int i = idx; i < arr.length; i++) {
            count += combinationWithInfy(arr, target - arr[i], ans + arr[i], i);
        }
        return count;
    }

    public static int combinationWithSingle(int[] arr, int target, String ans, int idx) {
        if (target == 0) {
            System.out.println(ans);
            return 1;
        }
        if (idx == arr.length || target < 0)
            return 0;

        int count = 0;
        for (int i = idx; i < arr.length; i++) {
            count += combinationWithSingle(arr, target - arr[i], ans + arr[i], i + 1);
        }
        return count;
    }

    // <------------------------------------------Subsequence
    // method------------------------------------------------>
    public static int permutationWithInfySubseq(int[] arr, int target, String ans, int idx) {
        if (idx == arr.length || target < 0)
            return 0;
        if (target == 0) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        count += permutationWithInfySubseq(arr, target - arr[idx], ans + arr[idx], 0);
        count += permutationWithInfySubseq(arr, target, ans, idx + 1);
        return count;
    }

    public static int permutationWithSingleSubseq(int[] arr, int target, String ans, int idx, boolean[] vis) {
        if (idx == arr.length || target < 0)
            return 0;
        if (target == 0) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        if (!vis[idx]) {
            vis[idx] = true;
            count += permutationWithSingleSubseq(arr, target - arr[idx], ans + arr[idx], 0, vis);
            vis[idx] = false;
        }
        count += permutationWithSingleSubseq(arr, target, ans, idx + 1, vis);
        return count;
    }

    public static int combinationWithInfySubSeq(int[] arr, int target, String ans, int idx) {
        if (idx == arr.length || target < 0)
            return 0;
        if (target == 0) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        count += combinationWithInfySubSeq(arr, target - arr[idx], ans + arr[idx], idx);
        count += combinationWithInfySubSeq(arr, target, ans, idx + 1);
        return count;
    }

    public static int combinationWithSingleSubSeq(int[] arr, int target, String ans, int idx) {
        if (target == 0) {
            System.out.println(ans);
            return 1;
        }
        if (idx == arr.length || target < 0)
            return 0;

        int count = 0;
        count += combinationWithSingleSubSeq(arr, target, ans, idx + 1);
        count += combinationWithSingleSubSeq(arr, target - arr[idx], ans + arr[idx], idx + 1);

        return count;
    }

    // <------------------------------------------Subsequence
    // method------------------------------------------------>

    // combination
    public static int queenPriorityCombi(int boxes, int queen, int q, int idx, String ans) {
        if (q == queen) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for (int i = idx; i < boxes; i++) {
            count += queenPriorityCombi(boxes, queen, q + 1, i + 1, ans + "B:" + i + " Q:" + q + "   ");
        }
        return count;
    }

    // permuttaion
    public static int queenPriorityPermutaion(boolean[] boxes, int queen, int q, String ans) {
        if (q == queen) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for (int i = 0; i < boxes.length; i++) {
            if (!boxes[i]) {
                boxes[i] = true;
                count += queenPriorityPermutaion(boxes, queen, q + 1, ans + "B:" + i + " Q:" + q + "   ");
                boxes[i] = false;
            }
        }
        return count;
    }

    // queen combination 2d
    public static int queenPriorityCombi2D(boolean[][] boxes, int queen, int qsf, int idx, String ans) {
        if (qsf == queen) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        int n = boxes.length;
        int m = boxes[0].length;
        for (int i = idx; i < n * m; i++) {
            int r = i / m;
            int c = i % m;
            count += queenPriorityCombi2D(boxes, queen, qsf + 1, i + 1, ans + "(" + r + " ," + c + ")   ");
        }
        return count;
    }

    // queen permutation 2d
    public static int queenPriorityPermutation2D(boolean[][] boxes, int queen, int qsf, int idx, String ans) {
        if (qsf == queen) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        int n = boxes.length;
        int m = boxes[0].length;
        for (int i = idx; i < n * m; i++) {
            int r = i / m;
            int c = i % m;
            if (!boxes[r][c]) {
                boxes[r][c] = true;
                count += queenPriorityPermutation2D(boxes, queen, qsf + 1, 0, ans + "(" + r + " ," + c + ")   ");
                boxes[r][c] = false;
            }
        }
        return count;
    }

    // 784
    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        letterCasePermutationHelper(s, ans, 0, "");
        return ans;
    }

    public static void letterCasePermutationHelper(String s, List<String> list, int idx, String ans) {
        if (idx == s.length()) {
            list.add(ans);
        }

        if (isNumber(s.charAt(idx))) {
            letterCasePermutationHelper(s, list, idx + 1, ans + s.charAt(idx));
        } else {
            char c = ' ';
            if (Character.isLowerCase(s.charAt(idx))) {
                c = Character.toUpperCase(s.charAt(idx));
            } else {
                c = Character.toLowerCase(s.charAt(idx));
            }

            letterCasePermutationHelper(s, list, idx + 1, ans + c);
            letterCasePermutationHelper(s, list, idx + 1, ans + s.charAt(idx));
        }
    }

    // 40
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> s_ans = new ArrayList<>();
        combinationSum2Helper(candidates, target, 0, ans, s_ans);
        return ans;
    }

    public static void combinationSum2Helper(int[] arr, int target, int idx, List<List<Integer>> ans,
            List<Integer> s_ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(s_ans));
            return;
        }
        if (target < 0 || idx == arr.length)
            return;
        s_ans.add(arr[idx]);
        combinationSum2Helper(arr, target - arr[idx], idx + 1, ans, s_ans);
        s_ans.remove(s_ans.size() - 1);
        combinationSum2Helper(arr, target, idx + 1, ans, s_ans);
    }

    // 216
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> s_ans = new ArrayList<>();
        combinationSum3Helper(n, ans, s_ans, k, 1, 0);
        return ans;
    }

    public static void combinationSum3Helper(int n, List<List<Integer>> ans, List<Integer> s_ans, int k, int idx,
            int tot) {
        if (tot == n) {
            ans.add(new ArrayList<>(s_ans));
            return;
        }

        if (tot > n || k < 0)
            return;

        s_ans.add(idx);
        combinationSum3Helper(n, ans, s_ans, k - 1, idx + 1, tot + idx);
        s_ans.remove(s_ans.size() - 1);
        combinationSum3Helper(n, ans, s_ans, k, idx + 1, tot + idx);
    }

    public static boolean isNumber(char c) {
        if (c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9'
                || c == '0') {
            return true;
        }
        return false;
    }

    // N- Queen
    public static List<List<String>> solveNQueens(int n) {
        boolean[][] vis = new boolean[n][n];
        List<List<String>> par = new ArrayList<>();
        List<String> child = new ArrayList<>();
        solveNQueensHelper(0, par, child, vis);
        System.out.println(par);
        return par;
    }

    public static void solveNQueensHelper(int r, List<List<String>> par, List<String> child, boolean[][] vis) {
        if (r == vis.length) {
            par.add(new ArrayList<>(child));
            return;
        }

        for (int i = 0; i < vis.length; i++) {
            String temp = "";
            if (isSafePlace(vis, r, i)) {
                for (int s = 0; s < vis.length; s++) {
                    if (s == i)
                        temp += "Q";
                    else
                        temp += ".";
                }
                child.add(temp);
                vis[r][i] = true;
                solveNQueensHelper(r + 1, par, child, vis);
                vis[r][i] = false;
                child.remove(child.size() - 1);
            }
        }
    }

    public static boolean isSafePlace(boolean[][] vis, int r, int c) {
        // up
        for (int i = r - 1; i >= 0; i--) {
            if (vis[i][c])
                return false;
        }

        // left-top
        for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--) {
            if (vis[i][j])
                return false;
        }

        // right-top
        for (int i = r - 1, j = c + 1; i >= 0 && j < vis[0].length; i--, j++) {
            if (vis[i][j])
                return false;
        }

        return true;
    }

    // N-Queen Optimized
    public static List<List<String>> solveNQueensOptimized(int n) {
        List<List<String>> par = new ArrayList<>();
        List<String> child = new ArrayList<>();
        boolean[] col_check = new boolean[n];
        boolean[] dia_right_check = new boolean[2 * n - 1];
        boolean[] dia_left_check = new boolean[2 * n - 1];
        solveNQueensHelperOptimized(0, par, child, col_check, dia_right_check, dia_left_check);
        System.out.println(par);
        return par;
    }

    public static void solveNQueensHelperOptimized(int r, List<List<String>> par, List<String> child,
            boolean[] col_check, boolean[] dia_right_check, boolean[] dia_left_check) {
        if (r == col_check.length) {
            par.add(new ArrayList<>(child));
            return;
        }

        for (int i = 0; i < col_check.length; i++) {
            String temp = "";
            if (isSafePlaceOptimized(r, i, col_check, dia_right_check, dia_left_check)) {
                for (int s = 0; s < col_check.length; s++) {
                    if (s == i)
                        temp += "Q";
                    else
                        temp += ".";
                }
                child.add(temp);
                col_check[i] = true;
                dia_right_check[r + i] = true;
                dia_left_check[r - i + (col_check.length - 1)] = true;
                solveNQueensHelperOptimized(r + 1, par, child, col_check, dia_right_check, dia_left_check);
                col_check[i] = false;
                dia_right_check[r + i] = false;
                dia_left_check[r - i + (col_check.length - 1)] = false;
                child.remove(child.size() - 1);
            }
        }
    }

    public static boolean isSafePlaceOptimized(int r, int c, boolean[] col_check, boolean[] dia_right_check,
            boolean[] dia_left_check) {
        // up
        if (col_check[c])
            return false;

        // right-top
        if (dia_right_check[r + c])
            return false;

        // left-top
        if (dia_left_check[r - c + (col_check.length - 1)])
            return false;

        return true;
    }

    // 494
    public int findTargetSumWays(int[] nums, int target) {
        HashMap<String, Integer> dp = new HashMap<>();
        return findTargetSumWaysHelper(nums, 0, target, "", 0, dp);
    }

    public static int findTargetSumWaysHelper(int[] nums, int ssf, int target, String ans, int idx,
            HashMap<String, Integer> dp) {
        if (idx == nums.length) {
            if (target == ssf) {
                System.out.println(ans);
                return 1;
            }
            return 0;
        }

        if (dp.containsKey(ssf + "< - >" + idx))
            return dp.get(ssf + "< - >" + idx);

        int count = 0;
        count += findTargetSumWaysHelper(nums, ssf + nums[idx], target, ans + " + " + nums[idx], idx + 1, dp);
        count += findTargetSumWaysHelper(nums, ssf - nums[idx], target, ans + " - " + nums[idx], idx + 1, dp);
        dp.put(ssf + "< - >" + idx, count);
        return count;
    }

    public static void friendsPairing2(int idx, int n, boolean[] used, String asf) {
        if (idx > n) {
            System.out.println(asf);
            return;
        }

        if (used[idx]) {
            friendsPairing2(idx + 1, n, used, asf);
        } else {
            used[idx] = true;
            friendsPairing2(idx + 1, n, used, asf + "(" + idx + ")");

            // System.out.println("Idx : " + idx);

            for (int i = idx + 1; i <= n; i++) {
                if (!used[i]) {
                    used[i] = true;
                    friendsPairing2(idx + 1, n, used, asf + "(" + idx + i + ")");
                    used[i] = false;
                }
            }

            used[idx] = false;
        }
    }

    public static void kPartition(int idx, int n, int k, int rssf, ArrayList<ArrayList<Integer>> ans) {
        if (idx > n) {
            if (rssf == ans.size())
                System.out.println(ans);
            return;
        }

        for (int i = 0; i < rssf; i++) {
            ans.get(i).add(idx);
            kPartition(idx + 1, n, k, rssf, ans);
            ans.get(i).remove(ans.get(i).size() - 1);
        }

        if (rssf < ans.size()) {
            ans.get(rssf).add(idx);
            kPartition(idx + 1, n, k, rssf + 1, ans);
            ans.get(rssf).remove(ans.get(rssf).size() - 1);
        }
    }

    public static int crypto(String str, int idx) {
        if(idx == str.length()){
            int x = convertStringToNumber(s1);
            int y = convertStringToNumber(s2);
            int z = convertStringToNumber(s3);

            if(x + y == z){
                for(int i = 0; i < mapping.length ; i++){
                    if(mapping[i] != -1) System.out.print((char) i + "-" + mapping[i] + " ");
                }
                System.out.println();
                return 1;
            }

            return 0;
        }

        int count = 0;
        char ch = str.charAt(idx);
        for (int i = 0; i <= 9; i++) {
            if (!usedNumber[i]) {
                usedNumber[i] = true;
                mapping[ch] = i;

                count += crypto(str, idx + 1);
                usedNumber[i] = false;
                mapping[ch] = 0;
            }
        }

        return count;
    }

    public static void crypto() {
        String str = s1 + s2 + s3;
        int[] freq = new int[26];
        for (int i = 0; i < str.length(); i++)
            freq[str.charAt(i) - 'a']++;

        str = "";
        for (int i = 0; i < 26; i++){
            if (freq[i] > 0) str += (char) (i + 'a');
        }
            
        crypto(str, 0);              

    }

    public static int convertStringToNumber(String s){
        String ans = "";
        if(mapping[s.charAt(0)] == 0) return -1;
        for(int i = 0 ; i < s.length() ; i++){
            ans += mapping[s.charAt(i)];
        }

        return Integer.parseInt(ans);
    }

    static String s1 = "send";
    static String s2 = "more";
    static String s3 = "money";

    static boolean[] usedNumber = new boolean[10];
    static int[] mapping = new int[128];

    //212
    public static List<String> findWords(char[][] board, String[] words) {
        List<String> par = new ArrayList<>();
        boolean[][] vis  = new boolean[board.length][board[0].length];
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[0].length ; j++){
                for(int z = 0 ; z < words.length ; z++){
                    String s = words[z];
                    if(s.length() > 0 && s.charAt(0) == board[i][j]){
                        if(findWords(board, s, 0, vis, i, j, par, dir)){
                            words[z] = "";
                        }
                    }
                }
            }
        }
        return par;
    }

    public static boolean findWords(char[][] board, String word, int idx, boolean[][] vis, int sr, int sc, List<String> par, int[][] dir) {
        if(idx == word.length() - 1){
            par.add(word);
            return true;
        }

        vis[sr][sc] = true;
        boolean status = false;
        for(int d = 0 ; d < dir.length ; d++){
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];
            if(r < board.length && c < board[0].length && r >= 0 && c >= 0 && !vis[r][c] && board[r][c] == word.charAt(idx + 1)){
                status = status || findWords(board, word, idx + 1, vis, r ,c, par, dir);
            }
        }
        vis[sr][sc] = false;
        return status;
    }

    // 37
    public void solveSudoku(char[][] board) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board.length ; j++){
                if(board[i][j] == '.'){
                    list.add(i * 9 + j);
                }
            }
        }
    }

    public static boolean sudokuHelper(char[][] board, int idx){
        if(idx == 81) return true;

        int r = idx / 9;
        int c = idx % 9;

        if(board[r][c] != '.'){
            if(sudokuHelper(board, idx + 1)) return true;
        }else{
            for(int i = 1 ; i <= 9 ; i++){
                if(isSafeSudoku(board, r, c, i)){
                    board[r][c] = (char) (i + '0');
                    if(sudokuHelper(board, idx + 1)) return true;
                    board[r][c] = '.';
                }
            }
        }
        return false;
    }

    public static boolean sudokuHelperList(char[][] board, int idx, List<Integer> list){
        if(idx == list.size()){
            return true;
        }

        int r = list.get(idx) / 9;
        int c = list.get(idx) % 9;

        for(int i = 1 ; i <= 9 ; i++){
            if(isSafeSudoku(board, r, c, i)){
                board[r][c] = (char) (i + '0');
                if(sudokuHelperList(board, idx + 1, list)) return true;
                board[r][c] = '.';
            }
        }
        return false;
    }

    public static boolean isSafeSudoku(char[][] board, int r, int c, int num){
        int n = board.length;
        for(int i = 0 ; i < n ; i++){
            if(board[r][i] - '0' == num) return false;
        }

        for(int i = 0 ; i < n ; i++){
            if(board[i][c] - '0' == num) return false;
        }

        r = (r / 3) * 3;
        r = (c / 3) * 3;
        for(int i = 0; i < 3 ; i++){
            for(int j = 0 ; j < 3 ; j++){
                if(board[r + i][c + j] - '0' == num) return false;
            }
        }
        return true;       
    }

    public static boolean isSafePlaceH(String word, int r, int c, char[][] box){
        for(int i = 0 ; i < word.length() ; i++){
            if(c + i >= box[0].length) return false;
            if(box[r][c + i] != '-' && box[r][c + i] != word.charAt(i)) return false;
        }
        return true;
    }

    public static boolean[] placeH(String word, int r, int c, char[][] box){
        boolean[] marked = new boolean[word.length()];
        for(int i = 0 ; i < word.length() ; i++){
            if(box[r][c + i] == '-'){
                box[r][c + i] = word.charAt(i);
                marked[i] = true;
            }
        }
        return marked;
    }

    public static void UnplaceH(String word, int r, int c, boolean[] vis, char[][] box){
        for(int i = 0 ; i < word.length() ; i++){
            if(vis[i]){
                box[r][c + i] = '-';
            }
        }
    }

    public static boolean[] placeV(String word, int r, int c, char[][] box){
        boolean[] marked = new boolean[word.length()];
        for(int i = 0 ; i < word.length() ; i++){
            if(box[r + i][c] == '-'){
                box[r + i][c] = word.charAt(i);
                marked[i] = true;
            }
        }
        return marked;
    }

    public static void UnplaceV(String word, int r, int c, boolean[] vis, char[][] box){
        for(int i = 0 ; i < word.length() ; i++){
            if(vis[i]){
                box[r + i][c] = '-';
            }
        }
    }

    public static boolean isSafePlaceV(String word, int r, int c, char[][] box){
        for(int i = 0 ; i < word.length() ; i++){
            if(r + i >= box.length) return false;
            if(box[r + i][c] != '-' && box[r + i][c] != word.charAt(i)) return false;
        }
        return true;
    }

    public static int crossword(char[][] box, String[] words, int idx){
        if(idx == words.length){
            print2D(box);
            return 1;
        }

        int count = 0;
        int n = box.length, m = box[0].length;
        String word = words[idx];
        for(int i = 0  ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(box[i][j] == '-' || box[i][j] == word.charAt(0)){
                    if(isSafePlaceH(word, i, j, box)){
                        boolean[] vis = placeH(word, i, j, box);
                        count += crossword(box, words, idx + 1);
                        UnplaceH(word, i, j, vis, box);
                    }

                    if(isSafePlaceV(word, i, j, box)){
                        boolean[] vis = placeV(word, i, j, box);
                        count += crossword(box, words, idx + 1);
                        UnplaceV(word, i, j, vis, box);
                    }
                }
            }
        }

        return count;
    }

    public static void print2D(char[][] box) {
        int n = box.length, m = box[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(box[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void crossWord(char[][] box, String[] words) {
        Arrays.sort(words, (a, b) -> {
            return b.length() - a.length();
        });

        System.out.println(crossword(box, words, 0));
    }

    public static void divideArrays(int[] arr){
        int sum = 0;
        for(int e : arr) sum += e;
        if(sum % 2 == 0){
            divideArraysHelper(arr, sum/2, new ArrayList<>(), 0);
        }
    }

    public static void divideArraysHelper(int[] arr, int target, List<Integer> list, int idx){
        if(target == 0){
            System.out.println(list);
            return;
        }
        if(idx >= arr.length) return;
        

        list.add(arr[idx]);
        divideArraysHelper(arr, target - arr[idx], list, idx + 1);
        list.remove(list.size() - 1);
        divideArraysHelper(arr, target , list, idx + 1);
    }

    public static void kSubetsWithEqualSum(int[] arr, int k){
        List<List<Integer>> parent = new ArrayList<>();
        int sum = 0;
        for(int e : arr) sum += e;
        if(arr.length < k || sum % k != 0) return;
        for(int i = 0; i < k ; i++){
            parent.add(new ArrayList<>());
        }
        int[] temp = new int[k];
        kSubetsWithEqualSum(arr, temp, k, parent, 0, sum/k);
    }

    public static void kSubetsWithEqualSum(int[] arr, int[] temp, int k, List<List<Integer>> parent, int idx, int target){
        if(idx == arr.length){
            for(int e : temp){
                if(e != target) return;
            }
            System.out.println(parent);
            return;
        }

        for(int i = 0 ; i < k ; i++){
            boolean flag = false; /////// stop permutation ------ fix the element 
            if(parent.get(i).size() == 0){
                flag = true;
            }
            if(temp[i] + arr[idx] > target) continue;
            temp[i] += arr[idx];
            parent.get(i).add(arr[idx]);
            kSubetsWithEqualSum(arr, temp, k, parent, idx + 1, target);
            parent.get(i).remove(parent.get(i).size() - 1);
            temp[i] -= arr[idx];
            if(flag) break;
        }
    }

    public static void palindromicPart(String str, int idx, String ans){
        if(idx >= str.length()){
            System.out.println(ans);
            return;
        }

        for(int i = idx + 1; i <= str.length() ; i++){
            String temp = str.substring(idx, i);
            if(isPalindrome(temp)){
                palindromicPart(str, i, ans + "(" + temp + ") ");
            }
        }
    }

    public static boolean isPalindrome(String str){
        int i = 0, j = str.length() - 1;
        while(i < j){
            if(str.charAt(i) != str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int segregate(int[] arr, int si, int ei, int p){
        swap(arr, p, ei);
        int pivot = si - 1;
        int iter = si;
        while(iter <= ei){
            if(arr[iter] <= arr[ei]){
                swap(arr, ++pivot, iter);
            }
            iter++;
        }
        return pivot;
    }

    public static void quickSort(int[] arr, int si, int ei){
        if(si > ei) return;

        int pivot = ei;
        pivot = segregate(arr, si, ei, pivot);

        quickSort(arr, si, pivot - 1);
        quickSort(arr, pivot + 1, ei);
    }

    public static void main(String[] args) {

        int[] arr = {5,1,7,6,9,3,4,2,2,2,22,90,333};

        quickSort(arr, 0, arr.length - 1);

        for(int e : arr) System.out.print(e + " ");
        System.out.println();

        //palindromicPart("pep",0,"");

        // int N = 2;
        // int M = 3;
        // boolean[][] vis = new boolean[N][M];
        // int[][] dir = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 }, { -1, -1 }, { 1, 1
        // }, { -1, 1 }, { 1, -1 } };
        // String[] dir_str = { "r", "l", "t", "d", "n", "s", "e", "w" };
        // int[] dir_cost = {2,3,3,5,1,6,3,2};
        // int paths = floidFill(0, 0, N - 1, M - 1, dir, dir_str, "", vis);
        // System.out.println(paths);
        // System.out.println();

        // Pair pair = floidFillPathMaker(0, 0, N - 1, M - 1, dir, dir_str, vis);
        // System.out.println("Longest Path : " + pair.longestPath);
        // System.out.println("Shortest Path : " + pair.shortestPath);

        // System.out.println();
        // System.out.println("Min cost : " + floidFillWithCost(0, 0, N - 1, M - 1, dir,
        // vis, dir_cost));

        // //int[] dd = { 2, 3, 5, 7 };
        // boolean[][] vis = new boolean[4][4];
        // System.out.println(queenPriorityPermutation2D(vis, 4, 0, 0, ""));
    }
}
