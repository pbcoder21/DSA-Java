package Graphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {

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
        
        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
    }
    
    //O(V+E)
    public static boolean isBipartite(ArrayList<Edge> graph[]) {
        int col[] = new int[graph.length];
        
        for(int i=0; i<col.length; i++) {
            col[i] = -1; //no color, initialize
            
        }
        
        Queue<Integer> q = new LinkedList<>(); //BFS
        
        for(int i=0; i<graph.length; i++) {
            if(col[i] == -1) { //color is not assigned
                q.add(i); 
                col[i] = 0; //yellow color(0) assign
                while(!q.isEmpty()) {
                    int curr = q.remove();
                    for(int j=0; j<graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j); //e.dest
                        if(col[e.dest] == -1) { //if neighb is not assigned color, then assign it
                            int nextCol = col[curr] == 0 ? 1 : 0; //give opp.color //Blue color(1)
                            col[e.dest] = nextCol; //assigned opp. color of prevcurr
                            q.add(e.dest);
                        }else {
                            if (col[e.dest] == col[curr]) { //neighbour has color - same color
                                return false; //Non - Bipartite                           
                            }
                        }
                        
                    }
                }
                
            }
        }        
        return true;
    }
  
    public static void main(String args[]) {
    /*  
             0 ----3
            /     / 
           /     / 
          1     4  
           \   /
            \ /
             2      
    */
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        
        System.out.println(isBipartite(graph));
    }
}