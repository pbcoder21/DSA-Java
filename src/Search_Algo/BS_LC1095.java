//package Search_Algo;     //https://leetcode.com/problems/find-in-mountain-array/
//
//public class BS_LC1095 { 
//    //find-in-mountain-array
//
//    public int findInMountainArray(int target, MountainArray mountainArr) {
//        int peak=peakIndexInMountainArray(mountainArr);
//        int ans=binarySearchAgnostic(mountainArr, target, 0, peak);
//        if(ans!=-1) {
//            return ans;
//        }
//        return binarySearchAgnostic(mountainArr, target, peak+1, mountainArr.length()-1 );
//     }
//     
//     public int peakIndexInMountainArray(MountainArray mountainArr) {
//         int s=0;
//         int e=mountainArr.length()-1;          
//         while(s<e) {
//             int m=s+(e-s)/2;
//             if(mountainArr.get(m)<mountainArr.get(m+1)) { //increasing part (find in right side)
//                 s=m+1;   //mi+1 element>m element
//             }else {       //decreasing part(find in left side)
//                 e=m;      //this may be ans, look at left (end!=mi-1)
//             } 
//         }
//         //li==si,points to largest element
//         return s;
//     }
//     
//         public int binarySearchAgnostic(MountainArray mountainArr,int target,int s,int e) {
//             //find whether the array is sorted or not
//             boolean isAsc=mountainArr.get(s)<mountainArr.get(e);      
//             while(s<=e) {            
//                 int m=s+(e-s)/2;  //mid val
//                 
//                 if(mountainArr.get(m)==target) {
//                     return m;
//                 }
//                 if(isAsc) {  //Ascending Order
//                     //System.out.println("Asc");
//                     if(mountainArr.get(m)<target) { 
//                         s=m+1;  //right side search
//                     }
//                     else { 
//                         e=m-1;  //left side search
//                     }                
//                 }else {      //Descending Order
//                     //System.out.println("Desc");
//                     if(mountainArr.get(m)<target) {
//                         e=m-1;  //left side search
//                     }
//                     else {
//                         s=m+1; //right side search
//                     }              
//                 }   
//             }
//             return -1;  //Not Found
//         }
// }