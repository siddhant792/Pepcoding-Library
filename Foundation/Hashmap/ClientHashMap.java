package Hashmap;

public class ClientHashMap {
    public static void main(String[] args) {
        CustomHashmap map = new CustomHashmap();
        map.put(5, 1);
        map.put(6, 1);
        map.put(7, 1);
        map.putIfAbsent(7, 2);
        System.out.println(map);
    }
}
