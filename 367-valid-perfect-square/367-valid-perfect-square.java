class Solution {
    public boolean isPerfectSquare(int num) {
        long start=1, end=num;
        while(start <= end) {
            long mid = (start+end)/2;
            if(mid*mid == num) {
                return true;
            } else if(mid*mid > num) {
                end = mid -1;
            } else {
                start = mid+1;
            }
        }
        return false;
    }
}