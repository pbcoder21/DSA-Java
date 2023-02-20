package Recursion;

public class Powerlogn { //O(logn)
    public static int optimizedPower(int a,int n) {
        if(n==0) {
            return 1;
        }
        int halfPower=optimizedPower(a, n/2);
        int halfPowerSq=halfPower*halfPower;
        
        //n is odd
        if(n%2!=0) {
            halfPowerSq=a*halfPowerSq;
        }
        return halfPowerSq;
    }
    public static void main(String[] args) {
        int a=2;
        int n=9;
        System.out.println(optimizedPower(a, n));
    }

}

//if(n % 2 == 0) { //even
//    return optimizedPower(x, n/2) * optimizedPower(x, n/2);
//} else { //odd
//    return x * optimizedPower(x, n/2) * optimizedPower(x, n/2);
//}
//}