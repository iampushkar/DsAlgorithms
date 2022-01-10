class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int N = nums.length;
        int subsetSize = 1<<N;
        
        for(int i=0; i<subsetSize; i++) {
            List<Integer> subList = new ArrayList<>();
            for(int j=0; j<N; j++) {
                if(checkBit(i, j)) {
                    subList.add(nums[j]);
                }
            }
            list.add(subList);
        }
        return list;
    }
    
    private static boolean checkBit(int N, int i) {
        return ((N>>i) & 1) == 1;
    }
}