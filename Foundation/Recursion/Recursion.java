import java.util.*;
import java.math.BigInteger;

public class Recursion {

    public static void printDecreasing(int n) {
        if (n == 0)
            return;
        System.out.println(n);
        printDecreasing(n - 1);
    }

    public static void printIncreasing(int n) {
        if (n == 0)
            return;
        printIncreasing(n - 1);
        System.out.println(n);
    }

    public static int factorial(int n) {
        if (n == 0)
            return 1;
        int num = n * factorial(n - 1);
        return num;
    }

    public static void increasingDecreasing(int n) {
        if (n == 0)
            return;
        System.out.println(n);
        increasingDecreasing(n - 1);
        System.out.println(n);
    }

    public static int powerLinear(int n, int p) {
        if (p == 0)
            return 1;
        return n * powerLinear(n, p - 1);
    }

    public static void printArray(int[] arr, int idx) {
        if (idx == arr.length)
            return;
        System.out.println(arr[idx]);
        printArray(arr, idx + 1);
    }

    public static int maxInArray(int[] arr, int idx) {
        if (idx == arr.length)
            return 0;
        return Math.max(arr[idx], maxInArray(arr, idx + 1));
    }

    public static int firstIndex(int[] arr, int idx, int x) {
        if (idx == arr.length)
            return -1;
        if (arr[idx] == x)
            return idx;
        return (firstIndex(arr, idx + 1, x));
    }

    public static int lastIndex(int[] arr, int idx, int x) {
        if (idx == arr.length)
            return -1;
        int a = lastIndex(arr, idx + 1, x);
        if (a != -1)
            return a;
        return (arr[idx] == x) ? idx : -1;
    }

    public static int[] allIndices(int[] arr, int x, int idx, int fsf) {
        if (idx == arr.length) {
            int[] base = new int[fsf];
            return base;
        }
        if (arr[idx] == x)
            fsf++;

        int[] answer = allIndices(arr, x, idx + 1, fsf);
        if (arr[idx] == x) {
            answer[fsf - 1] = idx;
        }
        return answer;
    }

    public static void zigzag(int n) {
        if (n == 0)
            return;
        System.out.print(n);
        zigzag(n - 1);
        System.out.print(n);
        zigzag(n - 1);
        System.out.print(n);
    }

    public static ArrayList<String> subsequence(String str) {
        if (str.length() == 0) {
            ArrayList<String> list = new ArrayList<>();
            list.add(" ");
            return list;
        }
        ArrayList<String> sublist = subsequence(str.substring(1));
        ArrayList<String> editor = new ArrayList<>();
        for (int i = 0; i < sublist.size(); i++) {
            editor.add(str.charAt(0) + sublist.get(i));
        }
        sublist.addAll(editor);
        return sublist;
    }

    static String[] container = { ",;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz" };

    public static ArrayList<String> kpC(String str, int idx) {
        if (idx == str.length()) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> answer = kpC(str, idx + 1);
        ArrayList<String> editor = new ArrayList<>();
        int len = Integer.parseInt("" + str.charAt(idx));
        for (int i = 0; i < container[len].length(); i++) {
            for (int j = 0; j < answer.size(); j++) {
                editor.add(container[len].charAt(i) + answer.get(j));
            }
        }
        return editor;
    }

    // public static void printRectangle(int row,int col,int i_row,int i_col){
    // if(i_row == row) return;

    // if(i_col < col)
    // }

    public static void removeHi(String str) {

        // if()
    }

    public static boolean arrayPalindrome(int start, int end, int[] arr) {

        if (start >= end)
            return true;

        if (arr[start] != arr[end])
            return false;

        return arrayPalindrome(start + 1, end - 1, arr);
    }

    public static void oddEvenPrint(int start, int n) {
        if (start == 0)
            return;

        if (start % 2 != 0)
            System.out.println(start);
        oddEvenPrint(start - 1, n);
        if (start % 2 == 0)
            System.out.println(start);
    }

    public static int[] inverseArrayRec(int[] arr, int idx) {
        if (idx == arr.length)
            return arr;
        int value = arr[idx];
        arr = inverseArrayRec(arr, idx + 1);
        arr[value] = idx;
        return arr;

    }

    public static void reverseArrayRec(int[] arr, int start, int stop) {
        if (start >= stop)
            return;
        int temp = arr[start];
        arr[start] = arr[stop];
        arr[stop] = temp;
        reverseArrayRec(arr, start + 1, stop - 1);
    }

    public static int sumOfString(String str, int idx) {
        if (idx == str.length())
            return 0;
        int ans = sumOfString(str, idx + 1);
        int current = Integer.parseInt("" + str.charAt(idx));
        ans += current;
        return ans;
    }

    public static boolean stringOneTwoReverse(String s1, String s2, int idx1, int idx2) {
        if (idx1 == s1.length() && idx2 == -1)
            return true;
        if (s1.charAt(idx1) != s2.charAt(idx2))
            return false;
        return stringOneTwoReverse(s1, s2, idx1 + 1, idx2 - 1);
    }

    public static boolean palindromeString(String str, int start, int stop) {
        if (start >= stop)
            return true;
        String c1 = str.charAt(start) + "";
        String c2 = str.charAt(start) + "";
        if (!c1.equalsIgnoreCase(c2))
            return false;
        return palindromeString(str, start + 1, stop - 1);
    }

    public static String seprateDuplicatesRec(String str, int idx) {
        if (idx == str.length())
            return "";
        StringBuilder res = new StringBuilder(seprateDuplicatesRec(str, idx + 1));
        if (res.length() > 0) {
            if (res.charAt(res.length() - 1) == str.charAt(idx)) {
                res.append("*");
            }
        }
        res.append(str.charAt(idx));
        return res.toString();
    }

    public static BigInteger numberToStringRec(String str, BigInteger pow, int counter) {
        if (counter == -1)
            return new BigInteger("0");
        BigInteger bg = BigInteger.valueOf(Integer.parseInt(str.charAt(counter) + "")).multiply(pow);
        BigInteger answer = numberToStringRec(str, pow.multiply(BigInteger.valueOf(10)), counter - 1);
        return bg.add(answer);
    }

    public static void moveCharatctersWayUp(String str, int idx, String end, String answer, char ch) {
        if (idx == str.length() - 1) {
            System.out.println(answer + str.charAt(idx) + end);
            return;
        }
        if (str.charAt(idx) == ch) {
            moveCharatctersWayUp(str, idx + 1, end + ch, answer, ch);
        } else {
            moveCharatctersWayUp(str, idx + 1, end, answer + str.charAt(idx), ch);
        }
    }

    public static String moveCharacterWayDown(String str, int idx, char chd) {
        if (idx == str.length() - 1) {
            return str.charAt(idx) + "";
        }
        char ch = str.charAt(idx);
        String result = moveCharacterWayDown(str, idx + 1, chd);
        if (ch == chd) {
            result = result + ch;
        } else {
            result = ch + result;
        }
        return result;
    }

    public static int countHi(String str, int idx) {
        if (idx == str.length() - 1)
            return 0;

        int result = countHi(str, idx + 1);
        if (str.charAt(idx) == 'h' && str.charAt(idx + 1) == 'i') {
            result++;
        }
        return result;
    }

    public static String removeAllHi(String str, int idx) {
        if (idx == str.length())
            return "";

        String answer = removeAllHi(str, idx + 1);
        answer = str.charAt(idx) + answer;
        if (answer.contains("hi")) {
            return answer.substring(2);
        } else
            return answer;
    }

    public static void removeAllHiVoid(String str, String result, int idx) {
        if (idx == str.length()) {
            System.out.println(result);
            return;
        }

        result += str.charAt(idx);
        if (result.contains("hi")) {
            removeAllHiVoid(str, result.substring(0, result.length() - 2), idx + 1);
        } else {
            removeAllHiVoid(str, result, idx + 1);
        }
    }

    public static String replaceHiWithPep(String str, int idx) {
        if (idx == str.length())
            return "";

        String answer = replaceHiWithPep(str, idx + 1);
        answer = str.charAt(idx) + answer;
        if (answer.contains("hi")) {
            return "pep" + answer.substring(2);
        } else
            return answer;
    }

    public static void replaceHiWithPepVoid(String str, String answer, int idx) {
        if (idx == str.length()) {
            System.out.println(answer);
            return;
        }
        answer += str.charAt(idx);
        if (answer.contains("hi")) {
            replaceHiWithPepVoid(str, answer.substring(0, answer.length() - 2) + "pep", idx + 1);
        } else {
            replaceHiWithPepVoid(str, answer, idx + 1);
        }
    }

    public static String HiWithoutHit(String str, int idx) {
        if (idx == str.length())
            return "";

        String result = HiWithoutHit(str, idx + 1);
        result = str.charAt(idx) + result;
        if (result.startsWith("hit")) {
            return result;
        } else if (result.startsWith("hi")) {
            return result.substring(2);
        } else {
            return result;
        }
    }

    public static void HiWithoutHitVoid(String str, String result, int idx) {
        if (idx == str.length()) {
            System.out.println(result);
            return;
        }

        result = result + str.charAt(idx);
        if (idx + 1 == str.length()) {
            if (result.endsWith("hi")) {
                HiWithoutHitVoid(str, result.substring(0, result.length() - 2), idx + 1);
            } else {
                HiWithoutHitVoid(str, result, idx + 1);
            }
        } else {
            if (result.endsWith("hi") && str.charAt(idx + 1) == 't') {
                HiWithoutHitVoid(str, result, idx + 1);
            } else if (result.endsWith("hi")) {
                HiWithoutHitVoid(str, result.substring(0, result.length() - 2), idx + 1);
            } else {
                HiWithoutHitVoid(str, result, idx + 1);
            }
        }

    }

    public static int countHiWithoutHit(String str, int idx) {
        if (idx == str.length() - 1)
            return 0;

        int res = countHiWithoutHit(str, idx + 1);
        if (str.charAt(idx) == 'h' && str.charAt(idx + 1) == 'i') {
            if (idx + 2 != str.length()) {
                if (str.charAt(idx + 2) != 't')
                    res++;
            } else {
                res++;
            }
        }
        return res;
    }

    public static String ReplacePepHiWithoutHit(String str, int idx) {
        if (idx == str.length())
            return "";

        String result = ReplacePepHiWithoutHit(str, idx + 1);
        result = str.charAt(idx) + result;
        if (result.startsWith("hit")) {
            return result;
        } else if (result.startsWith("hi")) {
            return "pep" + result.substring(2);
        } else {
            return result;
        }
    }

    public static void ReplacePepHiWithoutHitVoid(String str, String result, int idx) {
        if (idx == str.length()) {
            System.out.println(result);
            return;
        }

        result = result + str.charAt(idx);
        if (idx + 1 == str.length()) {
            if (result.endsWith("hi")) {
                ReplacePepHiWithoutHitVoid(str, result.substring(0, result.length() - 2) + "pep", idx + 1);
            } else {
                ReplacePepHiWithoutHitVoid(str, result, idx + 1);
            }
        } else {
            if (result.endsWith("hi") && str.charAt(idx + 1) == 't') {
                ReplacePepHiWithoutHitVoid(str, result, idx + 1);
            } else if (result.endsWith("hi")) {
                ReplacePepHiWithoutHitVoid(str, result.substring(0, result.length() - 2) + "pep", idx + 1);
            } else {
                ReplacePepHiWithoutHitVoid(str, result, idx + 1);
            }
        }

    }

    public static int countAAA(String str, int idx) {
        if (idx == str.length())
            return 0;

        int answer = countAAA(str, idx + 1);
        if (str.substring(idx).contains("aaa"))
            answer++;
        return answer;
    }

    public static void countAAANoOverLap(String str, int answer) {
        if (0 == str.length() || str.length() < 3) {
            System.out.println(answer);
            return;
        }
        if (str.substring(0, 3).equals("aaa")) {
            countAAANoOverLap(str.substring(3), answer + 1);
        } else {
            countAAANoOverLap(str.substring(1), answer);
        }
    }

    public static void contentOfPara(String str, boolean count, String result, int idx) {
        if (idx == str.length()) {
            System.out.println(result);
            return;
        }
        if (count)
            result += str.charAt(idx);
        if (str.charAt(idx) == '(') {
            result += str.charAt(idx);
            contentOfPara(str, true, result, idx + 1);
        } else if (str.charAt(idx) == ')') {
            contentOfPara(str, false, result, idx + 1);
        } else {
            if (count) {
                contentOfPara(str, true, result, idx + 1);
            } else {
                contentOfPara(str, false, result, idx + 1);
            }
        }
    }

    public static int twinCountOverlap(String str, int idx) {
        if (idx == str.length() - 2) {
            return 0;
        }
        int result = twinCountOverlap(str, idx + 1);
        if (str.charAt(idx) == str.charAt(idx + 2))
            result++;
        return result;
    }

    public static void balancedPara(String str, String res, int idx) {
        if (idx == str.length()) {
            if (res.length() % 2 == 0)
                System.out.println(true);
            else
                System.out.println(false);
            return;
        }

        if (str.charAt(idx) == '(' || str.charAt(idx) == '[' || str.charAt(idx) == '{' || str.charAt(idx) == ')'
                || str.charAt(idx) == ']' || str.charAt(idx) == '}') {
            res += str.charAt(idx);
        }
        balancedPara(str, res, idx + 1);
    }

    public static void twinCountNoOverLap(String str, int idx, int count) {
        if (idx >= str.length()) {
            System.out.println(count);
            return;
        }
        if (idx + 2 < str.length()) {
            if (str.charAt(idx) == str.charAt(idx + 2)) {
                twinCountNoOverLap(str, idx + 3, count + 1);
            } else {
                twinCountNoOverLap(str, idx + 1, count);
            }
        } else {
            twinCountNoOverLap(str, idx + 1, count);
        }
    }

    public static void balancedParaAdvanced(String str, String result, int idx) {
        if (idx == str.length()) {
            if (result.length() % 2 == 0)
                System.out.println(true);
            else
                System.out.println(false);

            return;
        }

        if (str.charAt(idx) == '(' || str.charAt(idx) == '[' || str.charAt(idx) == '{' || str.charAt(idx) == ')'
                || str.charAt(idx) == ']' || str.charAt(idx) == '}') {
            if (result.length() != 0) {
                if (result.charAt(result.length() - 1) == '(') {
                    if (str.charAt(idx) == '}' || str.charAt(idx) == ']') {
                        System.out.println(false);
                        return;
                    } else {
                        result += str.charAt(idx);
                        balancedParaAdvanced(str, result, idx + 1);
                    }
                } else if (result.charAt(result.length() - 1) == '[') {
                    if (str.charAt(idx) == '}' || str.charAt(idx) == ')') {
                        System.out.println(false);
                        return;
                    } else {
                        result += str.charAt(idx);
                        balancedParaAdvanced(str, result, idx + 1);
                    }
                } else if (result.charAt(result.length() - 1) == '{') {
                    if (str.charAt(idx) == ')' || str.charAt(idx) == ']') {
                        System.out.println(false);
                        return;
                    } else {
                        result += str.charAt(idx);
                        balancedParaAdvanced(str, result, idx + 1);
                    }
                } else {
                    result += str.charAt(idx);
                    balancedParaAdvanced(str, result, idx + 1);
                }
            } else {
                result += str.charAt(idx);
                balancedParaAdvanced(str, result, idx + 1);
            }
        } else {
            balancedParaAdvanced(str, result, idx + 1);
        }
    }

    public static char[] cont = { ' ', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
            'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

    public static void printAllPossibleCode(String str, int child, int parent, int case_maker) {
        if (child == str.length() && case_maker == 2)
            return;

        if (child == str.length()) {
            case_maker++;
            child = 0;
            parent = 1;
            System.out.println();
        }

        int rom = Integer.parseInt(str.substring(child, parent));
        System.out.print(cont[rom] + " ");
        if (case_maker == 0) {
            printAllPossibleCode(str, child + 1, parent + 1, 0);
        } else if (case_maker == 1) {
            printAllPossibleCode(str, child + 1, parent + 1, 1);
        } else if (case_maker == 2) {
            printAllPossibleCode(str, child + 1, parent + 1, 2);
        }

    }

    static String[] char_arr = { "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz" };

    public static void kPcVoid(String str, int idx, ArrayList<String> list) {
        if(idx == str.length()){
            System.out.println(list);
            return;
        }
        int ch = Integer.parseInt(str.charAt(idx)+"");
        ArrayList<String> smallAns = new ArrayList<>();
        for(int i=0;i<char_arr[ch].length();i++){
            for(int j=0;j<list.size();j++){
                smallAns.add(list.get(j) + char_arr[ch].charAt(i));
            }
        }
        kPcVoid(str,idx+1,smallAns);
    }

    public static ArrayList<String> printASCII(String str,int idx){
        if(idx == -1){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        char ch = str.charAt(idx);
        ArrayList<String> answer = printASCII(str,idx-1);
        ArrayList<String> editor = new ArrayList<>(answer);
        for(String e : answer){
            editor.add(ch + e);
        }

        for(String e : answer){
            int i = ch;
            editor.add(String.valueOf(i) + e);
        }
        return editor;
    }

    public static void printASCIIVoid(String str,String ans,int idx){
        if(idx == str.length()){
            System.out.println(ans);
            return;
        }

        printASCIIVoid(str, ans, idx+1);
        printASCIIVoid(str, ans + str.charAt(idx), idx+1);
        printASCIIVoid(str, ans + (int)str.charAt(idx), idx+1);
    }

    



    public static void main(String[] args) {
        // Scanner scn = new Scanner(System.in);
        // int n = scn.nextInt();
        // BigInteger power = BigInteger.valueOf((int)Math.pow(10, 7)) ;
        // countAAANoOverLap("aaaaaa", 0);
         //System.out.println(printASCII("ab", 1));
        // balancedParaAdvanced("[a+{b+(c+d)+e}+f]","",0);
        // ArrayList<String> smallAns = new ArrayList<>();
        // smallAns.add("");
        // kPcVoid("78",0,smallAns);
        printASCIIVoid("ab","",0);
    }
}