class Solution {
    public int maxProduct(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<2; i++) {
            pq.add(nums[i]);
        }
        
        for(int i=2; i<nums.length; i++) {
            int minVal = pq.peek();
            int num = nums[i];
            
            if(num > minVal) {
                pq.poll();
                pq.add(num);
            }
        }
        
        int num1 = pq.poll() - 1;
        int num2 = pq.poll() - 1;
        
        return num1*num2;
    }
}