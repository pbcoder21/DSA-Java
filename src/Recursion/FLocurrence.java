package Recursion; //First and Last occurence

public class FLocurrence {
                                                 //index
    public static int firstOccur(int a[], int key, int i) {
        if(i==a.length) { //if it reaches last n not found
            return -1;
        }
        if(a[i]==key) {  //key=5
            return i;
        }
        return firstOccur(a, key, i+1);
    }
                                                 //index
    public static int lastOccur(int a[], int key, int i) {
        if(i==a.length) { //if it reaches last n not found
            return -1;
        }
        int isFound=lastOccur(a, key, i+1); //key=5
        if(isFound==-1 && a[i]==key) {
            return i;
        }
        return isFound;
    }
    
    public static void main(String[] args) {
        int a[]= {8,2,3,4,5,6,7,5,3,4};
        System.out.println("FirstOcurrence: "+firstOccur(a, 5, 0));
        System.out.println("LastOcurrence: "+lastOccur(a ,5 ,0));
        
        }
    }
