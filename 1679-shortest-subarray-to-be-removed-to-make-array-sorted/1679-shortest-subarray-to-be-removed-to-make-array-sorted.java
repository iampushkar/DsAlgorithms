class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        // Remove prefix
        int N = arr.length;
        int r = N - 1;
        while (r > 0 && arr[r-1] <= arr[r]) {
            r--;
        }
        int res = r;

        // Remove postfix
        int l = 0;
        while (l + 1 < N && arr[l] <= arr[l+1]) {
            l++;
        }
        res = Math.min(res, N - 1 - l);

        // Remove Middle 
        l = 0;
        r = N - 1;

        while (l < r) {
            // Shrink Valid window
            while (r < N && l + 1 < r && arr[r-1] <= arr[r] && arr[l] <= arr[r]) {
                r--;
            }

            // Expand Invalid window
            while (r < N && arr[l] > arr[r]) {
                r++;
            }

            res = Math.min(res, r - l - 1);
            if (arr[l] > arr[l+1]) {
                break;
            }
            l++;
        }
        return res;
    }
}