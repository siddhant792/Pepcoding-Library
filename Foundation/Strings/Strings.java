import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Strings {
    public static void compresion1(StringBuilder str){
        StringBuilder str_new  = new StringBuilder();
        char c = str.charAt(0);
        str_new.append(c);
        int count = 1;
        for(int i=1;i<str.length();i++){
            if(str.charAt(i) == c){
                count++;
                if(i+1==str.length()){
                    str_new.append(count);
                }
            }
            else{
                str_new.append(count);
                str_new.append(str.charAt(i));
                c = str.charAt(i);
                count = 1;
            }
        }
        System.out.println("String-"+str_new);
    }

    public static void toggle(String str){
        StringBuilder str_new  = new StringBuilder();
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(c<97 && c>=65){
                c+=32;
                str_new.append(c);
            }else{
                c-=32;
                str_new.append(c);
            }
        }

        System.out.println(str_new);
        str_new.toString();
    }

    public static boolean isPalindrome(String str){
        int i=0,j = str.length()-1;
        while(i<j){
            if(str.charAt(i++) != str.charAt(j--)) return false;
        }
        return true;
    }

    public static void substringPalindrome(String str){
        for(int i=0;i<str.length();i++){
            for(int j=i;j<str.length();j++){
                String s = str.substring(i,j+1);
                if(isPalindrome(s)) System.out.println(s);
            }
        }
    }

    public static void consecutiveString(String str){
        StringBuilder str_build = new StringBuilder();
        int i=0;
        while(i<str.length()){
            str_build.append(str.charAt(i));
            if(i+1!=str.length()) str_build.append(str.charAt(i+1) - str.charAt(i));
            i++;
        }
        System.out.println(str_build);
    }

    public static void permutationString(String str){
        ArrayList<String> init = new ArrayList<>();
        init.add(str.charAt(0)+"");
        for(int i=1;i<str.length();i++){
            ArrayList<String> final_ans = new ArrayList<>(); 
            char ch = str.charAt(i);
            for(String s : init){
                for(int j=0;j<=s.length();j++){
                    String n = s.substring(0,j)+ch+s.substring(j); 
                    final_ans.add(n);
                }
            }
            init = final_ans;
        }
        for(String e : init){
            System.out.println(e);
        }
    }

    public static void allSubstring(String str){     
        for(int i=0;i<str.length();i++){
            for(int j=i;j<=str.length();j++){
                System.out.println(str.substring(i,j));
            }
        }
    }

    public static boolean isPalindromeNew(String str){
        int i=0,j=str.length()-1;
        while(i<j){
            if(str.charAt(i++) != str.charAt(j--)) return false;
        }
        return true;
    }

    public static void allPalindromicString(String str){
        for(int i=0;i<str.length();i++){
            for(int j=i;j<str.length();j++){
                String s = str.substring(i,j+1);
                if(isPalindromeNew(s)) System.out.println(s);
            }
        }
    }

    public static void stringCompressionAdvanced(String str){
        StringBuilder result = new StringBuilder();
        int count = 1;
        result.append(str.charAt(0));
        for(int i=1;i<str.length();i++){
            if(str.charAt(i)==str.charAt(i-1)){
                count++;
                if(i+1==str.length()){
                    System.out.println("Last");
                    if(count!=1)result.append(count);
                }
            }else{
                if(count!=1)result.append(count);
                result.append(str.charAt(i));
                count =1;
            } 
        }
        System.out.println(result);
    }


    public static void withoutX(String str){
        StringBuilder result = new StringBuilder();
        for(int i=0;i<str.length();i++){
            if(i==0 || i==1){
                if(str.charAt(i)!='x') result.append(str.charAt(i));
            }else{
                result.append(str.charAt(i));
            }
        }
        System.out.println(result);
    }

    public static void togglePep(String str){
        StringBuilder res = new StringBuilder();
        for(int i=0;i<str.length();i++){
            char temp = str.charAt(i);
            if(str.charAt(i)>= 'A' && str.charAt(i)< 'a'){
                temp+=32;
                res.append(temp);
            }else{
                temp-=32;
                res.append(temp);
            }
        }
        System.out.println(res);
    }

    public static void twoConsecutiveChar(String str){
        StringBuilder res = new StringBuilder();
        for(int i=0;i<str.length()-1;i++){
            int temp = str.charAt(i+1) - str.charAt(i);
            res.append(str.charAt(i));
            res.append(temp);
        }
        res.append(str.charAt(str.length()-1));
        System.out.println(res);
    }


    public static int fact_num(int num){
        int count = 1;
        for(int i=1;i<=num;i++){
            count = count*i;
        }
        return count;
    }


    public static void printAllPermutations(String str){
        int outcomes = fact_num(str.length());
        for(int i=0;i<outcomes;i++){
            StringBuilder builder = new StringBuilder(str);
            int temp = i;
            for(int j=str.length();j>0;j--){
                int rem = temp%j;
                int q = temp/j;
                System.out.print(builder.charAt(rem));
                builder.deleteCharAt(rem);
                temp = q;
            }
            System.out.println("");
        }
    }

    public static void appendCharInList(String str,char ch,ArrayList<String> list){
        for(int i=0;i<=str.length();i++){
            list.add(str.substring(0, i) + ch + str.substring(i));
        }
        System.out.println(list);
    }

    public static void printPermutations(String str){ //arraylist method
        ArrayList<String> parent_list = new ArrayList<>();
        parent_list.add("");
        for(int i=0;i<str.length();i++){
            ArrayList<String> smallAns = new ArrayList<>();
            char ch = str.charAt(i);
            for(String s : parent_list){
                appendCharInList(s,ch,smallAns);
            }
            parent_list = smallAns;
        }
        System.out.println(parent_list);
    }

    public static boolean isPrime(int n){
        if(n==1) return false;
        for(int i=2;i*i<=n;i++){
            if(n%i==0) return false;
        }
        return true;
    }
    
    public static void outcomesFounder(ArrayList<Integer> list){
        for(int i=2;i*i<=10000;i++){
            if(isPrime(i)) list.add(i);
        }
    }

    public static void primeFactorsGenerator(ArrayList<Integer> list,int number){
        System.out.println("\n\n");
        int index = 0;
        while(number!=1 && index<list.size()){
            int count = 0;
            while(number%list.get(index) == 0){
                number = number/list.get(index);
                count++;
            }
            if(count>0)System.out.println(list.get(index) + "^" + count);
            index++;
        }
        if(number>1)System.out.println(number + "^" + 1);
    }

    //interview question
    public static void queryResolver(ArrayList<Integer> query){
        ArrayList<Integer> outcomes_list = new ArrayList<>();
        outcomesFounder(outcomes_list);
        for(int ele : query){
            primeFactorsGenerator(outcomes_list,ele);
        }
    }
    
    public static void main(String[] args) {
        String str = "abc";
        //System.out.println(str);
        //ArrayList<Integer> query = new ArrayList<>(Arrays.asList(116,445,332,6676,8823,1132,9376));
        //System.out.println(query);
        printPermutations(str);
    }
}
