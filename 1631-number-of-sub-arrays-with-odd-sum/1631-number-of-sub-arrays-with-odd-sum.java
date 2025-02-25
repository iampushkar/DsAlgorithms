class Solution {
    public int numOfSubarrays(int[] arr) {
        int currSum = 0;
        int evenCount = 0;
        int oddCount = 0;
        int res = 0;
        int MOD = (int) Math.pow(10, 9) + 7;

        for (int n : arr) {
            currSum += n;

            if (currSum % 2 != 0) { // odd
                res = (res + 1 + evenCount) % MOD;
                oddCount += 1;
            } else { // even
                res = (res + oddCount) % MOD;
                evenCount += 1;
            }
        }
        
        return res;
    }
}