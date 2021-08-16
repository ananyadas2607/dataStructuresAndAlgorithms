package Pepcoding.Graph;

import java.util.ArrayList;

public class basicGraph {
    static class Edge{
        int v;
        int w;
        Edge(int v, int w){
            this.v=v;
            this.w=w;
        }
    }

    public static void addEdge(ArrayList<Edge>[] graph, int u, int v, int w){
        graph[u].add(new Edge(v,w));
        graph[v].add(new Edge(u,w));
    }
    //O(2E) == O(E)
    public static void display(ArrayList<Edge>[] graph, int V){
        for(int i=0;i<V;i++){
            System.out.println(i + " -> ");
            for(Edge e: graph[i]){
                System.out.println("(" +e.v+ "," +e.w + ") ");
            }
            System.out.println();
        }
    }

    public static int findEdge(ArrayList<Edge>[] graph, int u, int v){
        for(int i=0;i<graph[u].size();i++){
            Edge e=graph[u].get(i);
            if(e.v==v)
                return i;
        }
        return -1;
    }

    public static void removeEdge(ArrayList<Edge>[] graph, int u, int v){
        int idx1=findEdge(graph, u, v);
        graph[u].remove(idx1);

        int idx2=findEdge(graph, v, u);
        graph[v].remove(idx2);
    }

    public static void removeVtx(ArrayList<Edge>[] graph, int u){
        for(int i=graph[u].size()-1;i>=0;i--){
            Edge e=graph[u].get(i);
            removeEdge(graph,u,e.v);
        }
    }

    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] vis){
        if (src == dest)
            return true;

        boolean res = false;
        vis[src] = true;
        for (Edge e : graph[src]) {
            if (!vis[e.v])
                res = res || hasPath(graph, e.v, dest, vis);
        }

        return res;
    }

    public static int allPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] vis, String psf) {
        if (src == dest) {
            System.out.println(psf + dest);
            return 1;
        }

        int count = 0;
        vis[src] = true;
        for (Edge e : graph[src]) {
            if (!vis[e.v])
                count += allPath(graph, e.v, dest, vis, psf + src);
        }

        vis[src] = false;
        return count;
    }

    //Get connected components
    public static void dfs_compo(ArrayList<Edge>[] graph, int src, boolean[] vis) {
        vis[src] = true;
        for (Edge e : graph[src])
            if (!vis[e.v])
                dfs_compo(graph, e.v, vis);
    }

    public static void gcc(ArrayList<Edge>[] graph) {
        int N = graph.length;
        boolean[] vis = new boolean[N];

        int components = 0;
        for (int i = 0; i < N; i++) {
            if (!vis[i]) {
                components++;
                dfs_compo(graph, i, vis);
            }
        }
    }

        public static void constructGraph(){
        int V=9;
        ArrayList<Edge>[] graph=new ArrayList[V];
        for(int i=0;i<V;i++)
            graph[i]=new ArrayList<>();

        addEdge(graph, 0, 1,    10);
        addEdge(graph, 0, 3, 10);
        addEdge(graph, 1, 2, 10);
        addEdge(graph, 2, 3, 40);
    }
}
