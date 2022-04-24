class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<k; i++) {
            pq.add(nums[i]);
        }
        
        for(int i=k; i<nums.length; i++) {
            int minVal = pq.peek();
            int num = nums[i];
            
            if(num > minVal) {
                pq.poll();
                pq.add(num);
            }
        }
        
        return pq.peek();
    }
}