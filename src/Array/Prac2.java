package Array;

public class Prac2 {
	
	public static void main(String args[]) {
		
		int[] a= {10,20,30};
		System.out.print(a.length+",");
//		
//		for(int i=0; i<a.length; i++) {
//			System.out.print(a[i]+",");
//		}
		
		for(int i:a) {
			System.out.print(i+",");
		}
	}

}
