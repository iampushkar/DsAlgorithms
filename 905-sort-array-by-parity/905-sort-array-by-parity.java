class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int start = 0, end = nums.length-1;
        int[] ans = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            int val = nums[i];
            //even odd
            if(val % 2 == 0) { ans[start] = val; start++; }
            else { ans[end] = val; end--; }
        }
        return ans;
    }
}