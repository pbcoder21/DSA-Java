package Graphs; //To find Shortest distance 
import java.util.*;

public class Dijkstras {
    
    static class Edge {
        int src;
        int dest;
        int wt;
        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }
    
    static void createGraph(ArrayList<Edge> graph[]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));
        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));
        graph[2].add(new Edge(2, 4, 3));
        graph[3].add(new Edge(3, 5, 1));
        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }
    
    static class Pair implements Comparable<Pair> {
        int n;
        int path;
        public Pair(int n, int path) {
            this.n = n;
            this.path = path;
        }
        @Override
        public int compareTo(Pair p2) {
            return this.path - p2.path; //gives shortest value pro
        }
    }
    
    public static void dijkstra(ArrayList<Edge> graph[], int src) {
        int dist[] = new int[graph.length]; //nodes dist store (src--i)
        
        for(int i=0; i<dist.length; i++) {
            if(i != src) { //i==src (dist=0)
                dist[i] = Integer.MAX_VALUE; //makes infinity 
            } 
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));    
        boolean vis[] = new boolean[graph.length];
        
        //bfs
        while(!pq.isEmpty()) { //pq me all distance are stored
            Pair curr = pq.remove(); //from pq first value i.e small val will come out
            
            if(!vis[curr.n]) { //if curr node is not visited
                vis[curr.n] = true;
                
                for(int i=0; i<graph[curr.n].size(); i++) {
                    Edge e = graph[curr.n].get(i); //neighb
                    int u = e.src;
                    int v = e.dest;
                     
                    if(dist[u]+e.wt < dist[v]) { //update distance src to v
                        dist[v] = dist[u] + e.wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }
        for(int i=0; i<dist.length; i++) { //print
            System.out.print(dist[i]+" ");
        }
    }
    
    public static void main(String args[]) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        
        int src = 0;
        dijkstra(graph, src);
       
    }
}