package Graphs;

import java.nio.channels.NonWritableChannelException;
import java.util.ArrayList;

import Graphs.DFS.Edge;

public class HasPath {

    static class Edge {
        int src;
        int dest;
        
        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }
    static void createGraph(ArrayList<Edge> graph[]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));
        
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));
        
        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));
        
        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));
        
        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));
        
        graph[6].add(new Edge(6, 5));
    }
    
    public static void dfs(ArrayList<Edge> graph[], int curr, boolean visited[]) {
//        if(visited[curr]) {
//            return;
//        }
        System.out.print(curr+" "); //current visited make it True
        visited[curr] = true;   //TRUE
        
        for(int i=0; i<graph[curr].size(); i++) { //call neighbors
            Edge e = graph[curr].get(i);
            if(!visited[e.dest]) { //checks if neighbors are visited
                dfs(graph, e.dest, visited);
            }
        }
    }
    
    // O(V+E)
    public static boolean hasPath(ArrayList<Edge> graph[], int src, int dest, boolean visited[]) {
        if(src == dest) {
            return true;
        }
        visited[src] = true;
        for(int i=0; i<graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            //e.dest = neighbor
            if(!visited[e.dest] && hasPath(graph, e.dest, dest, visited)) {
                return true;
            }
        }
        return false;
    }
    
    public static void main(String args[]) {
        /*
          1 --- 3
         /      | \
        0       |  5 -- 6
         \      | /
         2 ---- 4
        */
        
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        
        createGraph(graph);
        dfs(graph, 0, new boolean[V]);
        
        System.out.println(hasPath(graph, 0, 5, new boolean[V]));
    }
}
