package TowerOfHanoi;

public class Hanoi {

	public static void towerOfHanoi(int n, String src, String helper, String dest) {
		if(n == 1) {
			System.out.println("transfer disk " + n + " from " + src + " to " + dest);
			return;
		}
		
		towerOfHanoi(n-1, src, dest, helper);  //transfer top n-1 from src to helper using dest as 'helper'
		
		System.out.println("transfer disk " + n + " from " + src + " to " + dest); //transfer nth from src to dest
		
		towerOfHanoi(n-1, helper, src, dest); //transfer n-1 from helper to dest using src as 'helper'
	}
	
	public static void main(String args[]) {
		int n = 2;
		towerOfHanoi(n, "S", "H", "D");
	}
	

}
