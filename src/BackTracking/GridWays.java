package BackTracking;

public class GridWays {
                                    //curr cells  //last cells
    public static int countGridWays(int i, int j, int n, int m) {
        if(i == n-1 && j == m-1) { //last cell
            return 1;
        } 
        else if(i == n || j == m) { //exceed last cell
            return 0;
        }
        int w1 = countGridWays(i, j+1, n, m); //goes right
        int w2 = countGridWays(i+1, j, n, m); //goes left
        int ways = w1 + w2;
        return ways;
    }
    
    public static void main(String args[]) {
        int n = 3, m = 3;
        System.out.println(countGridWays(0, 0, n, m));
    }
}