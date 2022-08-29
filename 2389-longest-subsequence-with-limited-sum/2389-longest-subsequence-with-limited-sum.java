class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int N = nums.length;
        int M = queries.length;
        
        Arrays.sort(nums);
        for(int i=1; i<N; i++) {
            nums[i] += nums[i-1];
        }
        
        int[] ans = new int[M];
        
        for(int i=0; i<M; i++) {
            ans[i] = longestSubSeq(nums, queries[i]);
        }
        
        return ans;
    }
    
    private int longestSubSeq(int[] nums, int s) {
        int size = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] <= s) {
                size = i+1;
                continue;
            } else {
                break;
            }
        }
        return size;
    }
    
}
/*
4 5 2 1
1 2 4 5
1 3 7 12
*/