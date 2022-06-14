class Solution {
    public int longestOnes(int[] nums, int k) {
        int start = 0, end = 0, zeros = 0;
        
        while(end < nums.length) {
            if(nums[end] == 0) {
                zeros++;
            }
            end++;
            
            if(zeros > k) {
                if(nums[start] == 0) {
                    zeros--;
                }
                start++;
            }
        }
        return end-start;
        
    }
}

/*
1,1,1,0,0,0,1,1,1,1,0

1 2 3 0 0 0 1 2 3 4 0
3 2 1 0 0 0 4 3 2 1 0

*/