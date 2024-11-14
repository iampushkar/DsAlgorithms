class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int left = 1;
        int right = Integer.MIN_VALUE;
        for (int q : quantities) {
            right = Math.max(right, q);
        }

        // apply binary search in the range
        int res = 0;
        while (left <= right) {
            int x = (left + right)/2;
            if (canDistribute(x, quantities, n)) {
                res = x;
                right = x - 1;
            } else {
                left = x + 1;
            }
        }
        return res;
    }

    private boolean canDistribute(int x, int[] quantities, int n) {
        int stores = 0;
        for (int q : quantities) {
            stores += Math.ceil(
                (double) q / (double) x
            );
        }
        return stores <= n;
    }
}