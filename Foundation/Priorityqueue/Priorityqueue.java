package PepCoding.Foundation.Priorityqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

import jdk.nashorn.api.tree.Tree;

public class Priorityqueue {

    public static void KLargest(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            if (pq.size() > k) {
                pq.remove();
            }
            pq.add(arr[i]);

        }
        while (!pq.isEmpty()) {
            System.out.print(pq.remove() + " ");
        }
    }

    public static void KFrequentElements(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[1] - b[1];
        });

        for (int e : map.keySet()) {
            pq.add(new int[] { e, map.get(e) });
            if (pq.size() > k) {
                pq.remove();
            }
        }

        int[] myAns = new int[k];
        int idx = 0;
        while (pq.size() != 0) {
            myAns[idx++] = pq.remove()[0];
        }
    }

    public List<String> topKFrequent(String[] arr, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        // {word,freq}
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
            if (map.get(a) == map.get(b)) {
                return b.compareTo(a);
            }
            return map.get(a) - map.get(b);
        });

        for (String e : map.keySet()) {
            pq.add(e);
            if (pq.size() > k) {
                pq.remove();
            }
        }
        List<String> myAns = new ArrayList<>();
        while (pq.size() != 0) {
            myAns.add(pq.remove());
        }

        Collections.sort(myAns, (a, b) -> {
            if (map.get(a) == map.get(b)) {
                return a.compareTo(b);
            } else
                return map.get(b) - map.get(a);
        });

        return myAns;
    }

    public static void sortKSorted(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int si = 0;
        for (int ele : arr) {
            pq.add(ele);
            if (pq.size() > k) {
                arr[si++] = pq.remove();
            }
        }

        while (pq.size() != 0) {
            arr[si++] = pq.remove();
        }
    }

    public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> parent){
        ArrayList<Integer> ans = new ArrayList<>();

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) ->{
            return a[2] - b[2];
        });

        //[array,idx,element]

        for(int i = 0; i < parent.size() ; i++){
            ArrayList<Integer> list = parent.get(i);
            pq.add(new int[]{i,0,list.get(0)});
        }

        while(!pq.isEmpty()){
            int[] temp = pq.remove();
            ans.add(temp[2]);
            int arr = temp[0];
            int arr_idx = temp[1];
            int length = parent.get(arr).size();
            if(arr_idx + 1 < length){
                temp[1]++;
                temp[2] = parent.get(arr).get(arr_idx + 1);
                pq.add(temp);
            }
        }
        return ans;
     }

     // slow approach
     public static boolean validAnagram(String s1, String s2){
         if(s1.length() != s2.length()) return false;
         TreeMap<Character,Integer> map1 = new TreeMap<>();
         TreeMap<Character,Integer> map2 = new TreeMap<>();

         for(int i = 0,j = 0; i < s1.length() ; i++,j++){
             map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0) + 1);
             map2.put(s2.charAt(j), map2.getOrDefault(s2.charAt(j), 0) + 1);
         }

         if(map1.equals(map2)) return true;
         return false;
     }


     // better time
     public static boolean validAnagram2(String s1, String s2){
        if(s1.length() != s2.length()) return false;
        int[] arr = new int[26];
        for(int i = 0;i < s1.length() ; i++) arr[s1.charAt(i) - 'a']++;
        for(int i = 0;i < s2.length() ; i++) arr[s2.charAt(i) - 'a']--;

        for(int i = 0;i < 26 ; i++) if(arr[i] != 0) return false;
        return true;  
    }

    //Leetcode 42

    public static String RunLengthEncodingString(String str){
        int[] arr = new int[26];
        StringBuilder ans = new StringBuilder();
        for(int i = 0;i < str.length() ; i++) arr[str.charAt(i) - 'a']++;

        for(int i = 0 ; i < 26 ; i++){
            if(arr[i] != 0){
                ans.append((char) i + 'a' );
                ans.append(arr[i]);
            }
        }
        return ans.toString();
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,ArrayList<String>> map = new HashMap<>();
        for(String s : strs){
            String rles = RunLengthEncodingString(s);
            map.putIfAbsent(rles, new ArrayList<>());
            map.get(rles).add(s);
        }

        List<List<String>> ans = new ArrayList<>();
        for(String keys : map.keySet()){
            ans.add(map.get(keys));
        }
        return ans;
    }


    public static void main(String[] args) {

       

        System.out.println( validAnagram2("anagram","nagaram"));

        // int[] arr = { 1, 1, 1, 2, 2, 3 };
        // KFrequentElements(arr, 2);
    }
}
