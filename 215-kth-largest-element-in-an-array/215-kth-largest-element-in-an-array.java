class Solution {
    public int findKthLargest(int[] nums, int k) {
        int N = nums.length;
        
        for(int i=0; i<k; i++) {
            int maxVal = nums[i];
            int index = i;
            for(int j=i; j<N; j++) {
                if(nums[j] > maxVal) {
                    maxVal = nums[j];
                    index = j;
                }
            }
            //swap
            int temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;
        }
        return nums[k-1];
    }
}
/* 
This is Selection sort.
get the smallest amd swap it with first
*/
