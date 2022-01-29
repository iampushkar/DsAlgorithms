class Solution {
    public int firstMissingPositive(int[] nums) {
        int N = nums.length;
        
        //modifying the array -> negative numbers with N+2
        for(int i=0; i<N; i++) {
            if(nums[i] <= 0) {
                nums[i] = N+2;
            }
        }
        
        //making numbers negative
        for(int i=0; i<N; i++) {
            int element = Math.abs(nums[i]);
            if(element >= 1 && element <= N) {
                int index = element-1;
                nums[index] = -1 * Math.abs(nums[index]);
            }
        }
        
        for(int i=0; i<N; i++) {
            if(nums[i] > 0) {
                return i+1;
            }
        }
        
        return N+1;
    }
}