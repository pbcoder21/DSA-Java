package Sorting;

public class BubbleSortString {
    
    public static void main(String args[]) {
		
		String a[]={"Advik", "Pratik", "Sameer", "Swara", "Manasvi"};
		String temp;
		//System.out.println(a.length);
		
		for(int i=0;i<a.length;i++) {  //no. of rounds
			int flag=0;
			for(int j=0;j<a.length-1-i;j++) { //for adjacent elements
				
				if( a[j].compareTo(a[j+1]) > 0) { // < for desc
					temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
					flag=1;
				}
			}
			if(flag==0) {
				break;
			}
		}
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
	}

}
