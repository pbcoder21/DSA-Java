package Graphs; //To find Shortest distance 
import java.util.*;

public class CheapFlights {
  
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
    
    static void createGraph(int flights[][] ,ArrayList<Edge> graph[]) {
        for(int i=0; i<graph.length; i++) { //create empty AL of graph
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<flights.length; i++) {
            int src = flights[i][0];
            int dest = flights[i][1];
            int wt = flights[i][2];
            
            Edge e = new Edge(src, dest, wt);
            graph[src].add(e); //add edges in src index
        }
    }
    
    static class Info {
        int v;
        int cost;
        int stops;
        public Info(int v, int cost, int stops) {
            this.v = v;
            this.cost = cost;
            this.stops = stops;
        }
    }
    
    public static int cheapeastFlight(int n, int flights[][], int src, int dest, int k) {
        ArrayList<Edge> graph[] = new ArrayList[n];
        createGraph(flights, graph);
        
        int dist[] = new int[n];
        for(int i=0; i<n; i++) {
            if(i != src) { //i==src (dist=0)
                dist[i] = Integer.MAX_VALUE; //makes infinity 
            } 
        }
        
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0)); //initialize
        
        while(!q.isEmpty()) { //pq me all distance are stored
            Info curr = q.remove(); //from pq first value i.e small val will come out
            if(curr.stops > k) { //if it exceeds k then break
                break;
            }
            
            for(int i=0; i<graph[curr.v].size(); i++) { //go to all vertex
                Edge e = graph[curr.v].get(i); //neighb
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;
                   //Relax Step 
                if(curr.cost+wt < dist[v] && curr.stops <= k) { //update distance src to v
                    dist[v] = curr.cost + wt;
                    q.add(new Info(v, dist[v], curr.stops+1));
                }
            }
        } 
        //dist[dest]
        if(dist[dest] == Integer.MAX_VALUE) {
            return -1;
        }else {
            return dist[dest];
        }
    }
  
    
    public static void main(String args[]) {
        int n = 4;
        int flights[][] = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int src = 0, dest = 3, k = 1;
        ArrayList<Edge> graph[] = new ArrayList[n];
        cheapeastFlight(n, flights, src, dest, k);
    }
}