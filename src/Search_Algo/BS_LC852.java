package Search_Algo;

public class BS_LC852 {  //BS_LC(162)
    
    public static void main(String[] args) {
        int[] arr= {1,2,3,4,5,6,7,8,9,10,9,8,5,1};
        System.out.println(peakIndexInMountainArray(arr)); 
    }
    
    public static int peakIndexInMountainArray(int[] arr) {
        int s=0;
        int e=arr.length-1;          
        while(s<e) {
            int m=s+(e-s)/2;
            if(arr[m]<arr[m+1]) { //increasing part (find in right side)
                s=m+1;   //m+1 element>m element
            }else {       //decreasing part(find in left side)
                e=m;      //this may be ans, look at left (end!=m-1)
            } 
        }
        //s==e,points to largest element
        return s;
    }
}
