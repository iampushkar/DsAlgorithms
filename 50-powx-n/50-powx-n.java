class Solution {
    /*public double myPow(double x, int N) {
        int n = N;
        if(n == 0) return 1.0;
        
        if(n < 0){
            n = -n;
            x = 1/x;
        }
        
        double halfPower = myPow(x, n/2);
        double halfAns = halfPower * halfPower;
        
        if(n % 2 == 0) {
            return halfAns;
        }
        return (halfAns * x);
    }*/
    
    public double myPow(double x, int N) {
        long n = N;
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        return helper(x, n);
    }
    
    public double helper(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double partition = helper(x, n / 2);
        return (n % 2 == 0) ? partition * partition : x * partition * partition;
    }
}
/*
34.00515 
-3
2.10000
3

*/