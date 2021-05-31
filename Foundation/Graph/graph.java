package PepCoding.Foundation.Graph;


import java.util.*;

public class graph {

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
        graph[v].add(new Edge(u, w));
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

    public static void removeEdge(int u, int v) {
        int idx1 = findEdge(u, v);
        ArrayList<Edge> dir1 = graph[u];
        dir1.remove(idx1);
        int idx2 = findEdge(v, u);
        ArrayList<Edge> dir2 = graph[v];
        dir2.remove(idx2);
    }

    public static void removeVtx(int u) {
        ArrayList<Edge> arr = graph[u];
        while (!arr.isEmpty()) {
            removeEdge(u, arr.get(arr.size() - 1).v);
        }
    }

    // question

    // my approach
    public static boolean hasPath(int src, int des) {
        ArrayList<Edge> arr = graph[src];
        for (Edge e : arr) {
            if (e.v == des)
                return true;
        }

        for (Edge e : arr) {
            if (src < des) {
                if (e.v > src)
                    return hasPath(e.v, des);
            } else {
                if (e.v < src)
                    return hasPath(e.v, des);
            }
        }
        return false;
    }

    // sir's approach
    public static boolean hasPath2(int src, int dest, boolean[] vis) {
        if (src == dest) {
            return true;
        }

        boolean res = false;
        vis[src] = true;
        for (Edge e : graph[src]) {
            if (!vis[e.v])
                res = res || hasPath2(e.v, dest, vis);
        }

        return res;
    }

    public static int allPath(int src, int dest, boolean[] vis, String ans) {
        if (src == dest) {
            System.out.println(ans + dest);
            return 1;
        }

        int count = 0;
        vis[src] = true;
        for (Edge e : graph[src]) {
            if (!vis[e.v])
                count += allPath(e.v, dest, vis, ans + src);
        }
        vis[src] = false;

        return count;
    }

    public static void preOrder(int src, boolean[] vis, String ans, int wsf) {
        System.out.print(src + " -> " + ans + src + "@" + wsf);
        vis[src] = true;
        for (Edge e : graph[src]) {
            if (!vis[e.v])
                preOrder(e.v, vis, ans + src, wsf + e.w);
        }
        vis[src] = false;
    }

    public static void postOrder(int src, boolean[] vis, String ans, int wsf) {
        vis[src] = true;
        for (Edge e : graph[src]) {
            if (!vis[e.v])
                postOrder(e.v, vis, ans + src, wsf + e.w);
        }
        System.out.print(src + " -> " + ans + src + "@" + wsf);
        vis[src] = false;
    }

    public static class PairPQ {
        String path = "";
        int weight = 0;

        PairPQ(String path, int weight) {
            this.path = path;
            this.weight = weight;
        }
    }

    public static PriorityQueue<PairPQ> pq = new PriorityQueue<>((a, b) -> {
        return a.weight - b.weight;
    });

    public static class PairP {
        int longestWeight = -(int) 1e9;
        String pathLongest = "";
        int smallestWeight = (int) 1e9;
        String pathSmallest = "";

        int ceil = (int) 1e9;
        String ceilPath = "";
        int floor = -(int) 1e9;
        String floorPath = "";
    }

    public static void getAll(int src, int desc, boolean[] vis, String psf, int wsf, int giveWeight, PairP p, int k) {

        if (src == desc) {
            if (wsf > p.longestWeight) {
                p.longestWeight = wsf;
                p.pathLongest = psf + desc;
            }

            if (wsf < p.smallestWeight) {
                p.smallestWeight = wsf;
                p.pathSmallest = psf + desc;
            }

            if (wsf > giveWeight && p.ceil > wsf) {
                p.ceil = wsf;
                p.ceilPath = psf + desc;
            }

            if (wsf < giveWeight && p.floor < wsf) {
                p.floor = wsf;
                p.floorPath = psf + desc;
            }

            pq.add(new PairPQ(psf + desc, wsf));
            if (pq.size() > k) {
                pq.remove();
            }

            return;
        }

        vis[src] = true;
        for (Edge e : graph[src]) {
            if (!vis[e.v]) {
                getAll(e.v, desc, vis, psf + src, wsf + e.w, giveWeight, p, k);
            }
        }
        vis[src] = false;
    }

    public static void dfs(ArrayList<Integer> arr, boolean[] vis, int src) {
        arr.add(src);
        vis[src] = true;
        for (Edge e : graph[src]) {
            if (!vis[e.v])
                dfs(arr, vis, e.v);
        }
    }

    public static ArrayList<ArrayList<Integer>> gcc() {
        boolean[] vis = new boolean[N];
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (!vis[i]) {
                ArrayList<Integer> sem = new ArrayList<>();
                dfs(sem, vis, i);
                ans.add(new ArrayList<>(sem));
            }
        }
        return ans;
    }

    public static void dfs_Island(int[][] mat, int[][] dir, int i, int j) {
        mat[i][j] = 0;
        for (int d = 0; d < 4; d++) {
            int r = i + dir[d][0];
            int c = j + dir[d][1];

            if (r >= 0 && c >= 0 && r < mat.length && c < mat[0].length && mat[r][c] == 1) {
                dfs_Island(mat, dir, r, c);
            }
        }
    }

    public static int inslandCounter(int[][] mat) {
        int count = 0;
        int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    dfs_Island(mat, dir, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void hamiltonianPath(int src, boolean[] vis, String path){
        if(path.length() == N - 1){
            int first = Integer.parseInt(path.charAt(0) + "");
            for(Edge e : graph[src]){
                if(e.v == first){
                    System.out.println(path + src + "*");
                    return;
                }
            }
            System.out.println(path + src + ".");
            return;
        }
        vis[src] = true;
        for(Edge e : graph[src]){
            if(!vis[e.v]){
                hamiltonianPath(e.v,vis,path + src);
            }
        }
        vis[src] = false;
    }

    public static int moonDFS(ArrayList<Integer>[] graph, int src, boolean[] vis) {
        vis[src] = true;
        int size = 0;
        for (Integer e : graph[src]) {
            if (!vis[e])
                size += moonDFS(graph, e, vis);
        }

        return size + 1;
    }

    public static int journeyToMoon(int n, int[][] astronaut) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        for (int[] a : astronaut) {
            graph[a[0]].add(a[1]);
            graph[a[1]].add(a[0]);
        }

        ArrayList<Integer> sizeArray = new ArrayList<>();
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!vis[i])
                sizeArray.add(moonDFS(graph, i, vis));
        }

        int ssf = 0;
        int ans = 0;
        for(int ele : sizeArray){
            ans += (ele * ssf);
            ssf += ele;
        }

        return ans;
    }

    public static int BFS_Cycle(int src, boolean[] vis){
        int level = 0, cycleCount = 0;
        LinkedList<Integer> que = new LinkedList<>();
        que.addLast(src);
        while(!que.isEmpty()){
            int size = que.size();
            System.out.print(level + " -> ");

            while(size-- > 0){
                int rVtx = que.removeFirst();
                if(vis[rVtx]){
                    cycleCount++;
                    continue;
                }

                System.out.println(rVtx + " ");
                vis[rVtx] = true;
                for(Edge e : graph[rVtx]){
                    if(!vis[e.v]){
                        que.addLast(e.v);
                    }
                }
            }

            System.out.println();
            level++;
        }
        return cycleCount;
    }

    public static void BFS_NoCycle(int src, boolean[] vis){
        int level = 0;
        LinkedList<Integer> que = new LinkedList<>();
        que.addLast(src);
        vis[src] = true;
        while(!que.isEmpty()){
            int size = que.size();
            System.out.print(level + " -> ");

            while(size-- > 0){
                int rVtx = que.removeFirst();
                System.out.println(rVtx + " ");
                for(Edge e : graph[rVtx]){
                    if(!vis[e.v]){
                        que.addLast(e.v);
                        vis[e.v] = true;
                    }
                }
            }

            System.out.println();
            level++;
        }
    }

    public static boolean isBipartite(int[][] graph, int[] vis, int src) {
        LinkedList<Integer> que = new LinkedList<>();
        int color = 0;
        //--- -1 undef
        // --- 0 red 
        // --- 1 green
        que.addLast(src);
        while(!que.isEmpty()){
            int size = que.size();
            while(size-- > 0){
                int rVtx = que.removeFirst();
                if(vis[rVtx] != -1){
                    if(vis[rVtx] != color) return false;
                    continue;
                }

                vis[rVtx] = color;
                for(Integer e : graph[rVtx]){
                    if(vis[e] == -1)
                        que.addLast(e);
                }
            }
            color = (color + 1)%2;
        }

        return true;
    }

    public static boolean Bipartite(int[][] graph){
        int[] vis = new int[graph.length];
        Arrays.fill(vis, -1);
        for(int i = 0 ; i < graph.length ; i++){
            if(vis[i] == -1 && !isBipartite(graph, vis, i))
                return false;
        }
        return true;
    }

    public static int infectionSpread(int src, int time, boolean[] vis){
        int count = 0;
        int level = 1;
        LinkedList<Integer> que = new LinkedList<>();
        que.addLast(src);
        vis[src] = true;
        while(!que.isEmpty() || level > time){
            int size = que.size();
            while(size-- > 0){
                int rVtx = que.removeFirst();
                count++;
                for(Edge e : graph[rVtx]){
                    if(!vis[e.v]){
                        que.addLast(e.v);
                        vis[e.v] = true;
                    }
                }
            }
            level++;
        }
        return count;
    }

    public static void main(String[] args) throws Exception{
        // for (int i = 0; i < N; i++) {
        //     graph[i] = new ArrayList<>();
        // }

        // addEdge(0, 1, 10);
        // addEdge(0, 3, 40);
        // addEdge(1, 2, 10);
        // addEdge(2, 3, 10);
        // addEdge(3, 4, 2);
        // addEdge(4, 5, 3);
        // addEdge(4, 6, 8);
        // addEdge(5, 6, 3);
        // addEdge(2, 5, 5);
        // // display();
        // boolean[] vis = new boolean[N];
        // hamiltonianPath(0,vis,"");

        

        // PairP pair = new PairP();
        // getAll(0, 6, vis, "", 0, 30, pair, 4);
        // System.out.println("Smallest Path = " + pair.pathSmallest + "@" +
        // pair.smallestWeight);
        // System.out.println("Longest Path = " + pair.pathLongest + "@" +
        // pair.longestWeight);
        // System.out.println("Just Larger Path than 30 = " + pair.ceilPath + "@" +
        // pair.ceil);
        // System.out.println("Just Smaller Path than 30 = " + pair.floorPath + "@" +
        // pair.floor);
        // System.out.println("4th Larger Path = " + pq.peek().path + "@" +
        // pq.peek().weight);
        // removeEdge(1, 2);

        // removeVtx(2);

        // System.out.println();

        // display();

    }
}
