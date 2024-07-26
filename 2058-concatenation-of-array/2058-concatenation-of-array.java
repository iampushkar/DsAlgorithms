class Solution {
    public int[] getConcatenation(int[] nums) {
        int size = nums.length;
        int[] ans = new int[2*size];
        int k = 0;
        for (int i=0; i<ans.length; i++) {
            ans[i] = nums[k];
            k++;
            if (k == size) {
                k = 0;
            }
        }
        return ans;
    }
}