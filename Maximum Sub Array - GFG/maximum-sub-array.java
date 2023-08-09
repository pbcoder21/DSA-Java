//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            ArrayList<Integer> ans = new Solution().findSubarray(a, n);
            for(int i:ans){
                out.print(i+" ");
            }out.println();
        }
        out.close();
    }
}
// } Driver Code Ends
// User function Template for Java

class Solution {
    ArrayList<Integer> findSubarray(int a[], int n) {
        // code here
        ArrayList<Integer>ans=new ArrayList<>();
        int max=0, curr=0; 
        int maxst=0, currst=0, maxend=0, maxlen=0;
        
        for(int i=0;i<n;i++){
           if(a[i]<0){
              currst=i+1;
               curr=0;
           }
           else{
               curr+=a[i];
           }
           if(max<curr){
                max=curr;
                
                
                maxst=currst;
                maxend=i+1;
                
                
            }
            else if(max==curr){
                 maxlen=maxend-maxst;
                int currlen=i+1-currst;
                if(maxlen<currlen){
                    maxst=currst;
                    maxend=i+1;
                }
                
            }
            
            
            
           
        }
        for(int i=maxst;i<maxend;i++){
            ans.add(a[i]);
        }
        if(ans.size()==0)
           ans.add(-1);
        return ans;
        
    }
}