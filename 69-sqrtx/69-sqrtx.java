class Solution {
    public int mySqrt(int x) {
        long start=1, end=x;
        long ans = 0;
        while(start <= end) {
            long mid = (start+end)/2;
            
            if(mid*mid == x) {
                ans = mid;
                return (int)ans;
            } else if(mid*mid < x) {
                ans = mid;
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return (int)ans;
    }
}