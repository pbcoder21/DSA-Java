package DivideConquer;

public class MergeSort { //O(nlogn)
    //sorting method (to do step1(divide) & step2(sort parts))
    public static void divide(int arr[], int si, int ei) { 
        if(si >= ei) { //BC  //when si=0 > e1=5 not possible, come out
            return;
        }
        //O(nlogn)
        int mid = si + (ei - si)/2; // or = (si + ei) / 2; 
        divide(arr, si, mid); //left /s----mid
        divide(arr, mid+1, ei); //right /mid+1---ei
        //merge
        conquer(arr, si, mid, ei);
    }

    //merge method to merge the sorted parts //O(nlogn)
    public static void conquer(int arr[], int si, int mid,int ei) {
        int temp[] = new int[ei-si+1]; //left(0,2)=3, right(3,5)=3 -> 5-0+1=6
        int idx1 = si; //idx for 1st sorted part
        int idx2 = mid+1; //idx for 2nd sorted part
        int k = 0; //idx for temp;
        
        //O(n)
        while(idx1 <= mid && idx2 <= ei) {
            //sort
            if(arr[idx1] < arr[idx2]) {
                temp[k] = arr[idx1];
                idx1++;
            } else {
                temp[k] = arr[idx2];
                idx2++;
            }
            k++;
        }

        //for leftover elements of 1st sorted part
        while(idx1 <= mid) {
            temp[k++] = arr[idx1++];
        }

        //for leftover elements of 2nd sorted part
        while(idx2 <= ei) {
            temp[k++] = arr[idx2++];
        }

        //copy temp to original array
        for(k=0, idx1=si; k<temp.length; k++, idx1++) {
            arr[idx1] = temp[k]; //temp --> original array
        }
    }

    public static void printArr(int arr[]) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] +" ");
        }
        System.out.println();
    }
    
    public static void main(String args[]) {
        int arr[] = {6, 3, 9, 5, 2, 8};
        divide(arr, 0, arr.length-1);
        printArr(arr);
    }
}