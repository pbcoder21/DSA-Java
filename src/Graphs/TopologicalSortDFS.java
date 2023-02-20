package Graphs;

import java.util.*;

public class TopologicalSortDFS {
    
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
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }
    
    //O(V+E)
    public static void topoSort(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>(); //inbuilt stack
        
        for(int i=0; i<graph.length; i++) {
            if(!vis[i]) { //unvisited
                topoSortUtil(graph, i, vis, s); //modified dfs
            }
        }
        
        while(!s.isEmpty()) {
            System.out.print(s.pop()+" "); //prints the final answer
        }
    }
    
    public static void topoSortUtil(ArrayList<Edge> graph[], int curr, boolean vis[], Stack<Integer> s) {
        vis[curr] = true;
            
        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i); //neighb
               
            if(!vis[e.dest]) { //check neighb are visited
                topoSortUtil(graph, e.dest, vis, s); //visited kardo it is in 1st step
            }
        } 
        s.push(curr); //add in stack in topo order
    }
    
    
    public static void main(String args[]) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        topoSort(graph);
    }
}