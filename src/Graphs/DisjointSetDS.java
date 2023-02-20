package Graphs;

public class DisjointSetDS {
    static int n = 7;
    static int par[] = new int[n];
    static int rank[] = new int[n];
    
    public static void init() { //initialization
        for(int i=0; i<n; i++) {
            par[i] = i;
        }        
    }
    
    public static int find(int x) {  //exp : find(x=3)                             //now find(x=1)
        if(x == par[x]) {            //     3 == par[3]->1 // 3==1 wrong           // 1 == par[1]-> 1==1 return 1
            return x;
        }
        return par[x] = find(par[x]); // par[3]=find(par[3])                       //par[3]=find(1)
    }
    
    public static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);
        
        if(rank[parA] == rank[parB]) { //both rank same
            par[parB] = parA; //chosen parA to be supreme parent
            rank[parA]++;
        }else if(rank[parA] > rank[parB]) {
            par[parB] = parA;
        }else {
            par[parA] = parB;
        }
    }
    //path compression
    
    public static void main(String[] args) {
        init();
        System.out.println(find(3));
        union(1, 3);
        System.out.println(find(3)); //exp
        union(2, 4);
        union(3, 6);
        union(1, 4);
        System.out.println(find(3));
        System.out.println(find(4));
        union(1, 5);
    }
            

}
