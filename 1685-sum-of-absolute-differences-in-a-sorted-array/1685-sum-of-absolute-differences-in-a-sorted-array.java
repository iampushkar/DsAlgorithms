class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int N = nums.length;
        int[] pre = new int[N];
        pre[0] = nums[0];
        for(int i=1; i<N; i++) {
            pre[i] = nums[i] + pre[i-1];
        }
        
        int[] res = new int[N];
        for(int i=0; i<N; i++) {
            int left = 0;
            if(i > 0) {
                left = (nums[i] * i) - pre[i-1];
            }
            int right = (pre[N-1] - pre[i]) - (nums[i] * (N-1-i));
            res[i] = left+right;
        }
        return res;
    }
}

/*
nums : 1 4 6 8 10 | N=5 | 
for val=1
[4-1] + [6-1] + [8-1] + [10-1]
[4+6+8+10] - 1*4

for val=6
[6-1] + [6-4] + [8-6] + [10-6]
6*2 - [1+4] + [8+10] - 6*2

nums[i]*i - pre[i-1] + pre[i+1, N-1] - nums[i]*(n-1-i)


For every element, we will calculate the sum -> O(n2)
*/