class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int N = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        
        for(int i=0; i<N-2; i++) {
            
            if(i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                int start = i+1, end = N-1;
                
                while(start < end) {
                    int sum = nums[i] + nums[start] + nums[end];
                    
                    if(sum == 0) {
                        List<Integer> l = Arrays.asList(nums[i], nums[start], nums[end]);
                        list.add(l);
                        
                        while(start< end && nums[start] == nums[start+1]) {
                            start++;
                        }
                        
                        while(start< end && nums[end] == nums[end-1]) {
                            end--;
                        }
                        
                        start++;
                        end--;
                    } else if(sum < 0) {
                        start++;
                    } else {
                        end--;
                    }
                }
            }
        }
        
        return list;
        
    }
}