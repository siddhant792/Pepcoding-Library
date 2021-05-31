package PepCoding.Foundation.Graph;

import java.util.*;

public class DirectedGraph {
    public static class Edge {
        int v = 0;
        int w = 0;

        Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public String toString() {
            return "(" + v + ", " + w + ")";
        }
    }

    public static int N = 7;
    public static ArrayList<Edge>[] graph = new ArrayList[N];

    public static void addEdge(int u, int v, int w) {
        graph[u].add(new Edge(v, w));
    }

    public static void display() {
        for (int i = 0; i < N; i++) {
            ArrayList<Edge> arr = graph[i];
            System.out.print(i + " -> ");
            for (int j = 0; j < arr.size(); j++) {
                System.out.print(arr.get(j));
                if (j != arr.size() - 1)
                    System.out.print(", ");
            }
            System.out.println();
        }
    }

    public static int findEdge(int u, int v) {
        ArrayList<Edge> arr = graph[u];
        for (int j = 0; j < arr.size(); j++) {
            if (arr.get(j).v == v)
                return j;
        }
        return -1;
    }

    public static void dfsMarker(int src, boolean[] vis, ArrayList<Integer> list){
        vis[src] = true;
        for(Edge e : graph[src]){
            if(!vis[e.v]){
                dfsMarker(e.v, vis,list);
            }
        }
        list.add(src);
    }

    public static ArrayList<Integer> topologicalOrder(){
        boolean[] vis = new boolean[N];
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < N ; i++){
            if(!vis[i]) dfsMarker(i, vis, list);
        }
        return list;
    }

    public static void main(String[] args) {
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        addEdge(0, 1, 10);
        addEdge(0, 3, 40);
        addEdge(1, 2, 10);
        addEdge(2, 3, 10);
        addEdge(4, 5, 3);
        addEdge(4, 6, 8);
        addEdge(5, 6, 3);
        System.out.println(topologicalOrder());
    }
}
