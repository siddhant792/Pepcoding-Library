import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import javax.crypto.interfaces.DHPrivateKey;

public class GfgPractice {

    public static int sr = 0, sc = 0;

    // Number of paths
    public static long numberOfPaths(int m, int n) {
        if (sr == m - 1 && sc == n - 1) {
            return 1;
        }

        int ans = 0;

        if (sr < m && sc < n) {
            sr++;
            ans += numberOfPaths(m, n);
            sr--;
        }

        if (sr < m && sc < n) {
            sc++;
            ans += numberOfPaths(m, n);
            sc--;
        }
        return ans;
    }

    // Game of Death in a circle

    public static int gameOfDeath(int n, int k) {
        if (n == 1)
            return 1;

        int ans = gameOfDeath(n - 1, k);
        int y = (ans + k - 1) % n;
        return y + 1;
    }

    // Lucky Number

    static int counter = 2;

    public static boolean luckyNumber(int n) {
        if (n < counter)
            return true;
        if (n % counter == 0)
            return false;

        int next_num = n - n / counter;
        counter++;
        return luckyNumber(next_num);
    }

    // Finding Positions'

    public static int findingPosition(int n) {
        if (n == 1)
            return 1;

        int ans = findingPosition(n / 2);
        return ans * 2;
    }

    // Word Break - Part 2

    public static void wordBreaker(int startIdx, int idx, String str, List<String> strArray) {
        if (idx == str.length()) {
            if (strArray.contains(str.substring(startIdx, idx))) {
                System.out.print("(" + str + ")");
            }
            return;
        }

        String mark = str.substring(startIdx, idx);
        if (strArray.contains(mark)) {
            String nextStr = str.substring(0, startIdx) + mark + " " + str.substring(idx);
            wordBreaker(idx + 1, idx + 2, nextStr, strArray);
        }
        wordBreaker(startIdx, idx + 1, str, strArray);
    }

    // Permutation with Spaces

    public static void permutationWithSpace(String str, String ans, int idx) {
        if (idx == str.length()) {
            System.out.println(ans);
            return;
        }

        permutationWithSpace(str, ans + str.charAt(idx), idx + 1);
        if (idx > 0)
            permutationWithSpace(str, ans + " " + str.charAt(idx), idx + 1);
    }

    // Recursive sequence

    public static long recursiveSequence(long ans, int count, int num, int last) {
        System.out.println("ANs : " + ans + " count : " + count + " num : " + num + " last : " + last);
        if (count > num) {
            return ans;
        }

        long inter = 1;
        for (int i = 0; i < count; i++) {
            inter *= last;
            last++;
        }
        return recursiveSequence(ans + inter, count + 1, num, last);
    }

    // Possible Words From Phone Digits

    public static ArrayList<String> answer = new ArrayList<>();

    public static String[] cont = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public static void phoneDigits(String str, int idx, String ans) {
        if (idx == str.length()) {
            answer.add(ans);
            return;
        }

        int num = Integer.parseInt(str.charAt(idx) + "");
        String inter = cont[num];
        for (int i = 0; i < inter.length(); i++) {
            phoneDigits(str, idx + 1, ans + inter.charAt(i));
        }
    }

    // Combination Sum

    public static void combinationSum(ArrayList<Integer> arr, int sum, String ans) {
        if (sum == 0) {
            System.out.println(ans);
            return;
        } else if (sum < 0)
            return;

        for (int i = 0; i < arr.size(); i++) {
            int last = 0;
            if (ans.length() > 0)
                last = Integer.parseInt(ans.charAt(ans.length() - 1) + "");
            if (arr.get(i) >= last) {
                combinationSum(arr, sum - arr.get(i), ans + " " + arr.get(i));
            }
        }
    }

    public static void stringPermutation(String str, String ans) {
        if (0 == str.length()) {
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            String part1 = str.substring(0, i);
            String part2 = str.substring(i + 1);
            stringPermutation(part1 + part2, ans + str.charAt(i));
        }
    }

    // Juggler Sequence

    public static void jugglerSequence(int n) {
        System.out.println(n + " ");
        if (n == 1)
            return;

        if (n % 2 == 0) {
            int num = (int) Math.pow(n, 0.5);
            jugglerSequence(num);
        } else {
            int num = (int) Math.pow(n, 1.5);
            jugglerSequence(num);
        }
    }

    // Finding Profession

    public static char findingProfession(int level, int pos) {
        if (level == 1) {
            return 'e';
        }

        char ans = findingProfession(level - 1, (pos + 1) / 2);
        if (ans == 'e') {
            return pos % 2 == 0 ? 'd' : 'e';
        } else
            return pos % 2 == 0 ? 'e' : 'd';

    }

    // Generate All Possible Parentheses

    public static void generateParentheses(int open, int close, int num, String ans) {
        if (close == num) {
            System.out.println(ans);
            return;
        }

        if (open < num) {
            generateParentheses(open + 1, close, num, ans + "(");
        }

        if (close < open) {
            generateParentheses(open, close + 1, num, ans + ")");
        }
    }

    // Geek-onacci Number

    public static void geekOnaci(int num, int ans, int count, List<Integer> extract) {
        if (count == num) {
            System.out.println(ans);
            return;
        }

        int counter = 0;
        int answer = 0;
        int x = extract.size() - 1;
        while (counter < 3) {
            answer += extract.get(x);
            x--;
            counter++;
        }
        extract.add(answer);
        geekOnaci(num, answer, count + 1, extract);
    }

    // Geeks's Garden

    static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { -1, -1 }, { 1, 1 }, { -1, 1 }, { 1, -1 } };

    public static int geeksGarden(int[][] arr, int row, int col, int s_row, int s_col) {
        if (s_row > row)
            return 0;

        int current = 0;
        if (s_col < col) {
            current = geeksGarden(arr, row, col, s_row, s_col + 1);
        } else {
            current = geeksGarden(arr, row, col, s_row + 1, 0);
        }

        if (arr[s_row][s_col] == 1) {
            for (int i = 0; i < 8; i++) {
                if ((s_row + dir[i][0] >= 0) && (s_col + dir[i][1] >= 0) && (s_row + dir[i][0] <= row)
                        && (s_col + dir[i][1] <= col)) {
                    if (arr[s_row + dir[i][0]][s_col + dir[i][1]] == 1) {
                        current++;
                        break;
                    }
                }
            }
        }

        return current;
    }

    // N Digit numbers with digits in increasing order

    static Set<Integer> ans_set = new HashSet<>();

    public static void increasingOrder(int digit, int count, int answer) {
        if (count == 10) {
            return;
        }
        ans_set.add(answer);
        for (int i = 1; i <= digit; i = i * 10 + 1) {
            increasingOrder(digit, count + 1, answer + i);
        }
    }

    static ArrayList<Integer> increasingNumbers(int N) {
        int digit = 1, answer = 1;
        for (int i = 1; i < N; i++) {
            digit = digit * 10 + 1;
            answer = answer * 10 + (i + 1);
        }
        increasingOrder(digit, N, answer);
        ArrayList<Integer> numbersList = new ArrayList<Integer>(ans_set);
        Collections.sort(numbersList);
        return numbersList;
    }

    // Pascals Triangle

    private static Vector<Long> pascalsTriangle(int row) {
        if (row == 1) {
            Vector<Long> base = new Vector<>();
            base.add((long) 1);
            return base;
        }

        Vector<Long> myAns = pascalsTriangle(row - 1);
        Vector<Long> result = new Vector<>();
        result.add((long) 1);

        if (myAns.size() > 1) {
            for (int i = 0; i < myAns.size() - 1; i++) {
                result.add(Long.sum(myAns.get(i), myAns.get(i + 1)));
            }
        }

        result.add((long) 1);
        return result;
    }

    // Gf Series

    public static int gfSeries(int n) {
        if (n == 2) {
            return 1;
        } else if (n == 1) {
            return 0;
        }

        int T1 = gfSeries(n - 2);
        int T2 = gfSeries(n - 1);
        return (T1 * T1) - T2;
    }

    // Reach Target

    public static boolean status = false;

    public static void reachTarget(int position, int next_jump, int des, int rem_step) {
        if (rem_step == 0 && position == des) {
            status = true;
            return;
        } else if (rem_step == 0) {
            return;
        }
        if (!status) {
            reachTarget(position + next_jump, next_jump, des, rem_step - 1);
            reachTarget(position - next_jump, next_jump, des, rem_step - 1);
        }
    }

    // adjacent duplicates

    public static boolean sort = false;

    public static String adjacentDuplicates(String str, int idx, boolean found, String result){
        if(idx == str.length()){
            if(found) return result.substring(0,result.length()-1);
            else return result;
        }
    
        String myAns;

        // down-top

        if(result.charAt(result.length()-1) == str.charAt(idx)){
            myAns = adjacentDuplicates(str,idx + 1,true,result);
        }else{
            if(found){
               myAns =  adjacentDuplicates(str,idx + 1,false,result.substring(0, result.length()-1) + str.charAt(idx));
            } 
            else  myAns = adjacentDuplicates(str,idx + 1,false,result + str.charAt(idx));
        }

        // top-down

        if(sort){
            return myAns;
        }else{
            int index = 0,start = 0;
            for(int i=myAns.length()-1;i>=0;i--){
                index = i-1;
                while(index >= 0){
                    if(myAns.charAt(i) != myAns.charAt(index)) break;
                    index--;
                }
                if(index != i-1){
                    start = i + 1;
                    break;
                }
            }
            sort = true;
            System.out.println("Entered");
            if(index==-1 && start==0) return myAns;
            else return myAns.substring(0, index) + myAns.substring(start);
        }
    
    }


    // Next Happy Number

    public static boolean isHappy(int n){
        if(n == 1 || n == 7){
            return true;
        }else if(n < 10){
            return false;
        }else{
            int sum = 0;
            while(n>0){
                sum+=(n%10)*(n%10);
                n/=10;
            }
            return isHappy(sum);
        }
    }

    public static int nextHappyNumber(int n){
        if(isHappy(n+1)){
            return n+1;
        }else return nextHappyNumber(n+1);
    }

    public static void main(String[] args) {
        // phoneDigits("58898",0,"");
        // recursiveSequence(0,1,5,1);
        // permutationWithSpace(str,"",0);
         //System.out.print(adjacentDuplicates("geeks",0));
        // }
        

        System.out.println(nextHappyNumber(10));

        // handShake(4, 1, "1");
    }
}
