package Hashmap;

import java.util.*;

public class CustomHashmap<K, V> {
    private class Node {
        K key;
        V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return key + " = " + value;
        }
    }

    private LinkedList<Node>[] bucket;
    private int NoOfElements = 0;
    private int maxSizeOfBucket = 0;

    private void initialize(int size) {
        bucket = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            bucket[i] = new LinkedList<>();
        }
        this.maxSizeOfBucket = size;
    }

    public CustomHashmap() {
        initialize(10);
    }

    public Integer size() {
        return this.NoOfElements;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        int max = this.NoOfElements;
        for (int i = 0; i < this.bucket.length; i++) {
            LinkedList<Node> ll = this.bucket[i];
            int size = ll.size();
            while (size-- > 0) {
                Node node = ll.getFirst();
                sb.append(node);
                ll.addLast(ll.removeFirst());
                if(max > 1) sb.append(", ");
                max--;
            }
        }
        sb.append(" ]");
        return sb.toString();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    // return null if not found
    public V get(K key) {
        if (containsKey(key))
            return group(key).getFirst().value;
        return null;
    }

    public V remove(K key) {
        if (containsKey(key)) {
            this.NoOfElements--;
            return group(key).removeFirst().value;
        }
        return null;
    }

    public boolean containsKey(K key) {
        LinkedList<Node> ll = group(key);
        int size = ll.size();
        while (size-- > 0) {
            if (ll.getFirst().key == key)
                return true;
            ll.addLast(ll.removeFirst());
        }
        return false;
    }

    public ArrayList<K> keySet() {
        ArrayList<K> arr = new ArrayList<>();
        for (int i = 0; i < this.bucket.length; i++) {
            LinkedList<Node> ll = this.bucket[i];
            int size = ll.size();
            while (size-- > 0) {
                arr.add(ll.getFirst().key);
                ll.addLast(ll.removeFirst());
            }
        }
        return arr;
    }

    public V getOrDefault(K key, V defaultValue) {
        if (containsKey(key))
            return group(key).getFirst().value;
        return defaultValue;
    }

    private void reHash(){
        LinkedList<Node>[] temp = this.bucket;
        initialize(this.maxSizeOfBucket*2);
        for(int i = 0 ; i < temp.length ; i++){
            LinkedList<Node> ll = temp[i];
            int size = ll.size();
            while(size-- > 0){
                Node node = ll.removeFirst();
                put(node.key, node.value);
            }
        }
    }

    public void put(K key, V value) {
        LinkedList<Node> ll = group(key);
        if (containsKey(key)) {
            ll.getFirst().value = value;
        } else {
            Node node = new Node(key, value);
            ll.addLast(node);
            this.NoOfElements++;

            double lambda  = (0.5 * this.maxSizeOfBucket);
            if(ll.size() >= lambda){
                reHash();
            }
        }
    }

    public void putIfAbsent(K key, V value) {
        LinkedList<Node> ll = group(key);
        if (!containsKey(key)) {
            Node node = new Node(key, value);
            ll.addLast(node);
        }
    }

    public LinkedList<Node> group(K key) {
        int groupNo = groupNo(key);
        return this.bucket[groupNo];
    }

    public Integer groupNo(K key) {
        Integer hs = Math.abs(key.hashCode());
        return hs % this.maxSizeOfBucket;
    }

}
