class Solution {
    public void moveZeroes(int[] nums) {
        int N = nums.length;
        int current = 0;
        int lastZero = 0;
        while(current < N) {
            if(nums[current] != 0) {
                //swap current with lastzero
                int temp = nums[current];
                nums[current] = nums[lastZero];
                nums[lastZero] = temp;
                lastZero++;
            }
            current++;
        }
    }
}
/*
[0,1,0,3,12] -> 1 0
current -> 0 1
lastZero -> 1

*/