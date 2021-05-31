package Hashmap;

import java.util.*;

public class Hashmap {

    public static void printFrequency(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                int current = map.get(str.charAt(i));
                map.put(str.charAt(i), current + 1);
            } else {
                map.put(str.charAt(i), 1);
            }
        }
        // System.out.println(map);

        char highest = ' ';
        int f_highest = 0;
        for (char s : map.keySet()) {
            if (map.get(s) > f_highest) {
                f_highest = map.get(s);
                highest = s;
            }
        }

        System.out.println(highest);
    }

    public static void positionOfAllCharacters(String str) {
        HashMap<Character, String> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            map.put(c, map.getOrDefault(c, "") + i + ", ");
        }
        System.out.println(map);
    }

    public static void getCommonElementsWithoutDuplicates(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i<arr1.length;i++){
            map.put(arr1[i],map.getOrDefault(arr1[i],0) + 1);
        }

        for(int i = 0; i<arr2.length;i++){
            if(map.containsKey(arr2[i])){
                System.out.println(arr2[i]);
                map.remove(arr2[i]);
            }
        }
    }

    public static void getCommonElementsWithDuplicates(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i<arr1.length;i++){
            map.put(arr1[i],map.getOrDefault(arr1[i],0) + 1);
        }

        for(int i = 0; i<arr2.length;i++){
            if(map.containsKey(arr2[i])){
                System.out.println(arr2[i]);
                //map.remove(arr2[i]);
                map.put(arr2[i], map.get(arr2[i]) - 1);
                if(map.get(arr2[i]) == 0) map.remove(arr2[i]);
            }
        }
    }

    public static void getLongestSubsequence(int[] arr){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int e : arr){
            map.put(e, 1);
        }

        int lE = 0, length = 0;
        for(int i = 0; i<arr.length ;i++){
            if(map.containsKey(arr[i])){
                map.remove(arr[i]);
                int le = arr[i] - 1,re = arr[i] + 1;
                while(map.containsKey(le)){
                    map.remove(le);
                    le--;
                }

                while(map.containsKey(re)){
                    map.remove(re);
                    re++;
                }

                int temp_len = re - le - 1;
                if(temp_len > length){
                    lE = le + 1;
                    length = temp_len;
                }
            }
        }


        for(int i = 0 ;i < length ; i++){
            System.out.println(i + lE);
        }
    }


    public static void main(String[] args) {
        //positionOfAllCharacters("abcdeabc");
        int[] arr = {12,5,1,2,10,2,13,7,11,8,9,11,8,9,5,6,11};
        getLongestSubsequence(arr);
    }
}
