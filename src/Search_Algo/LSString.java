package Search_Algo;  //Strings

public class LSString{
    
    public static void main(String[] args) {
        
        String[] arr= {"deepak","rohit","rahul","anjali"};
        String item="anjali";
        int temp=0;
        for(int i=0;i<arr.length;i++) {
            if(arr[i].equals(item)) {
                System.out.println("Item is present at "+i+" index position");
                temp=temp+1;
            }
        }
        if(temp==0) {
            System.out.println("Item not found");
        }
        }
    }




