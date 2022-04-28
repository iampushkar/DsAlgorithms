class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(
        (n1, n2) -> map.get(n1) - map.get(n2));
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            pq.add(key);
            
            if(pq.size() > k) { pq.poll(); }
        }
        
        int[] top = new int[k];
        int index=0;
        while(!pq.isEmpty()) {
            top[index++] = pq.poll();
        }
        
        return top;
    }
}