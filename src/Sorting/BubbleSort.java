package Sorting;

public class BubbleSort {
    
    public static void bubbleSort(int a[]) {
        
        for(int i=0;i<a.length-1;i++) {  //no. of rounds
            int flag=0;
            for(int j=0;j<a.length-1-i;j++) { //for adjacent elements
                
                if(a[j]>a[j+1]) { // < for desc
                    int temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                    flag=1;
                }
            }
            if(flag==0) {
                break;
            }
        }
    }
    
    public static void printArr(int a[]) {
        for(int i=0;i<a.length;i++) {
            System.out.print(a[i]+" ");
        }
    }
	
	public static void main(String args[]) {
		int a[]={36,5,29,12,5};
		bubbleSort(a);
		printArr(a);
	
	}
}	