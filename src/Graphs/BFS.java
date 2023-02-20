package Graphs;

import java.util.*;

public class BFS {
    
    static class Edge {
        int src;
        int dest;
        int wt; //here wt=1 standard
        
        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }
    
    static void createGraph(ArrayList<Edge> graph[]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>(); //add in AL
        }
        
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));
        
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));  
        
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));
        
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));
        
        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));
        
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));
        
        graph[5].add(new Edge(6, 5, 1));
    }
    
    public static void bfs(ArrayList<Edge> graph[], int V) { //O(V+E)
        boolean visited[] = new boolean[V]; // T/F
        Queue<Integer> q = new LinkedList<>();
        q.add(0); //Source = 0
        
        while(!q.isEmpty()) {  //here V and E traverse
            int curr = q.remove();
            
            if(!visited[curr]) {    //visit curr
                System.out.print(curr+" ");  //1. print (only unvisited prints)
                visited[curr] = true;    //2. visited hai toh kardo True
                for(int i=0; i<graph[curr].size(); i++) {    //3. neighbor ko kardo add
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);  //queue me add kardo final value
                }
            }
        }
        System.out.println();
    }
    
    public static void main(String args[]) {
        /*
         1 --- 3
        /      | \
       0       |   5 -- 6
        \      | /
         2 ---- 4
        */
        
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];        
        createGraph(graph); //create graoh
        bfs(graph, V); //BFS Traversak
    }
}