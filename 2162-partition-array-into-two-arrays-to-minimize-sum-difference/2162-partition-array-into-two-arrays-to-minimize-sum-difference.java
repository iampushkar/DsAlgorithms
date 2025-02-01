class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length / 2;
        int totalSum = Arrays.stream(nums).sum();

        // Generate all possible subset sums for each size in left and right halves
        Map<Integer, List<Integer>> leftSums = new HashMap<>();
        Map<Integer, List<Integer>> rightSums = new HashMap<>();

        // Initialize the maps
        for (int i = 0; i <= n; i++) {
            leftSums.put(i, new ArrayList<>());
            rightSums.put(i, new ArrayList<>());
        }

        // Generate subset sums for left half
        generateSubsetSums(nums, 0, n, 0, 0, leftSums);
        // Generate subset sums for right half
        generateSubsetSums(nums, n, nums.length, 0, 0, rightSums);

        // Sort all lists in rightSums for binary search
        for (List<Integer> list : rightSums.values()) {
            Collections.sort(list);
        }

        int minDiff = Integer.MAX_VALUE;

        // For each size k in left half, we need (n-k) elements from right half
        for (int k = 0; k <= n; k++) {
            List<Integer> left = leftSums.get(k);
            List<Integer> right = rightSums.get(n - k);

            for (int leftSum : left) {
                int target = (totalSum - 2 * leftSum) / 2;

                // Find closest sum in right list using binary search
                int idx = lowerBound(right, target);

                // Check the found value
                if (idx < right.size()) {
                    int sum1 = leftSum + right.get(idx);
                    int sum2 = totalSum - sum1;
                    minDiff = Math.min(minDiff, Math.abs(sum2 - sum1));
                }
                // Check previous value if exists
                if (idx > 0) {
                    int sum1 = leftSum + right.get(idx - 1);
                    int sum2 = totalSum - sum1;
                    minDiff = Math.min(minDiff, Math.abs(sum2 - sum1));
                }
            }
        }

        return minDiff;
    }

    // Generate subset sums with size tracking
    private void generateSubsetSums(int[] nums, int start, int end, int sum, int count,
            Map<Integer, List<Integer>> sums) {
        if (start == end) {
            sums.get(count).add(sum);
            return;
        }
        // Include current number
        generateSubsetSums(nums, start + 1, end, sum + nums[start], count + 1, sums);
        // Exclude current number
        generateSubsetSums(nums, start + 1, end, sum, count, sums);
    }

    // Binary search to find lower bound
    private int lowerBound(List<Integer> list, int target) {
        int left = 0, right = list.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}