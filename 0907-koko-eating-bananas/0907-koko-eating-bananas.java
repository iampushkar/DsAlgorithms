class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1; // eating 1 banana per hour is minimum
        int r = Integer.MIN_VALUE; // max of piles array can be the max speed
        for (int p : piles) {
            r = Math.max(r, p);
        }

        int res = r;

        while (l <= r) {
            int k = l + (r-l)/2; // mid
            int hours = 0;
            for (int p : piles) {
                hours += Math.ceil((double) p / (double) k);
            }

            if (hours <= h) {
                res = Math.min(res, k);
                r = k - 1;
            } else {
                l = k + 1;
            }
        }

        return res;
    }
}