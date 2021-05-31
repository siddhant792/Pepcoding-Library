import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
 	public static Scanner scn = new Scanner(System.in);
	public static void main (String[] args)
	 {
	     ArrayList<ArrayList<String>> parent = new ArrayList<>();
         int test = scn.nextInt();
         scn.nextLine();
	     for(int i=0;i<test;i++){
             System.err.println("I : "+ i);
	         ArrayList<String> child = new ArrayList<>();
	         String temp = scn.nextLine();
	         stringPermutation(child,temp,"");
	         parent.add(child);
	     }
	     
	     for(int i=0;i<parent.size();i++){
	         for(String e : parent.get(i)){
	             System.out.print(e+" ");
	         }
	         System.out.println();
	     }
	 }
	 
	 public static void stringPermutation(ArrayList<String> child,String str,String ans){
        if(0 == str.length()){
            child.add(ans);
            return;
        }

        for(int i=0;i<str.length();i++){
            String part1 = str.substring(0,i);
            String part2 = str.substring(i+1);
            stringPermutation(child,part1 + part2 , ans + str.charAt(i));
        }
    }
}