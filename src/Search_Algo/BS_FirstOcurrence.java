package Search_Algo;

public class BS_FirstOcurrence {
    
    static int firOc(int arr[],int key) {
            
        int s=0;
        int e=arr.length-1;
        int m=s+(e-s)/2;
        int ans=-1;
        
        while(s<=e) {
            if(arr[m]==key) {
                ans=m;
                e=m-1;
            }else if(arr[m]<key) {
                s=m+1;
            }else if(arr[m]>key) {
                e=m-1;
            }
            m=s=(e-s)/2;
        }
        return ans;
    }
    
    public static void main(String[] args) {
        int arr[]= {1,2,3,3,3,4,5};
        firOc(arr,3);
    }
}