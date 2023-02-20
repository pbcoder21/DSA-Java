//package Search_Algo;
//
//public interface MountainArray {
//
//    public static void main(String[] args) {
//        MountainArray mountainArr[]= {1,2,3,4,5,3,1};
//    }
//    public int findInMountainArray(int target, MountainArray mountainArr) {
//       int peak=peakIndexInMountainArray(mountainArr);
//       
//        
//    }
//    
//    public static int peakIndexInMountainArray(mountainArr) {
//        int s=0;
//        int e=mountainArr.length-1;          
//        while(s<e) {
//            int m=s+(e-s)/2;
//            if(mountainArr[m]<mountainArr[m+1]) { //increasing part (find in right side)
//                s=m+1;   //mi+1 element>m element
//            }else {       //decreasing part(find in left side)
//                e=m;      //this may be ans, look at left (end!=mi-1)
//            } 
//        }
//        //li==si,points to largest element
//        return s;
//    }
//    
//     static int binarySearchAgnostic(mountainArr,int target) {
//            //find whether the array is sorted or not
//            boolean isAsc=mountainArr[li]<mountainArr[hi];      
//            while(li<=hi) {            
//                int mi=li+(hi-li)/2;  //mid val
//                
//                if(mountainArr[mi]==target) {
//                    return mi;
//                }
//                if(isAsc) {  //Ascending Order
//                    //System.out.println("Asc");
//                    if(mountainArr[mi]<target) { 
//                        li=mi+1;  //right side search
//                    }
//                    else { 
//                        hi=mi-1;  //left side search
//                    }                
//                }else {      //Descending Order
//                    //System.out.println("Desc");
//                    if(mountainArr[mi]<srch) {
//                        hi=mi-1;  //left side search
//                    }
//                    else {
//                        li=mi+1; //right side search
//                    }              
//                }   
//            }
//            return -1;  //Not Found
//        }
//
//
//
