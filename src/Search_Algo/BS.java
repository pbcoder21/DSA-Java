package Search_Algo;   //Smart programming : https://www.youtube.com/watch?v=7iE5xNOJET0

public class BS {
  

public static void main(String[] args) {
    
    int[] a= {0,1,2,3,3,4,5,12,18};
    int target=3;
    
    int s=0;            //lowest val
    int e=a.length-1;  //highest val
    
    //int m=(s+e)/2;   //(this might exceed int range
    int m=s+(e-s)/2;  //mid val
    
    while(s<=e) {
        if(a[m]==target) {
            System.out.println("Item is present at "+m+" index position");
            break;
        }
        else if(a[m]<=target) { //right side search
            s=m+1;  
        }
        else {
            e=m-1;  //left side search
        }
        //mi=(li+hi)/2;
        m=s+(e-s)/2;   
    }
    if(s>e) {
        System.out.println("Element not found");
    }
}}