class Solution {
    public int rob(int[] nums) {
        int N = nums.length;
        if (N == 1) return nums[0];

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (int i=0; i<N; i++) {
            //exclude first element
            if (i != 0) {
                list1.add(nums[i]);
            }
            //exclude last element
            if (i != N-1) {
                list2.add(nums[i]);
            }
        }
        return Math.max(solve(list1), solve(list2));
    }

    int solve(List<Integer> list) {
        int N = list.size();
        int prev = list.get(0);
        int prev2 = 0;

        for (int i = 1; i<N; i++) {
            int pick = list.get(i);
            if (i > 1) {
                pick += prev2;
            }

            int notPick = prev;

            int curr = Math.max(pick, notPick);

            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}