package Search_Algo;

public class BS_InfiniteArray {
    
        public static void main(String[] args) {
            //start with box of 2
            int[] a= {1,2,3,4,5,6,7,8,9,10,16,18,20,31,34};
            int target=20;
            System.out.println(ans(a, target));           
        }
    
        static int ans(int[] a,int target) {
            //first find the range
            //first start with a box of 2 then, 2*2=4, 4*2=8, ..... 
            int s=0;
            int e=1;
                 //condition for target to lie in between
            while(target>a[e]) {
                int newStart=e+1;
                    //double the box
                    //end = previous end + sizeofbox*2
                e=e+(e-s+1)*2;
                s=newStart;
            }
            return binarySearch(a, target, s, e);            
        }
        
        static int binarySearch(int[] a,int target,int s,int e) {
            while(s<=e) {
                int m=s+(e-s)/2;
                if(a[m]<target) {
                    s=m+1;
                }else if(a[m]<target) {
                    e=m-1;               
                }else {
                    return m;
                }
            }
            return -1;
        }
    
    }
