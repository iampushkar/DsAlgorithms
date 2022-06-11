class Solution {
    public int numSquarefulPerms(int[] nums) {
        int N = nums.length;
        
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        permutate(nums, 0, set);

        return set.size();
    }
    
    private void permutate(int[] nums, int pos, HashSet<ArrayList<Integer>> set) {
        if(pos == nums.length) {
            ArrayList<Integer> list = new ArrayList<>();
            for(int n : nums) {
                list.add(n);
            }
            set.add(list);
        }

        for(int i=pos; i<nums.length; i++) {
            if(i != pos && nums[i] == nums[pos]) continue;
            swap(nums, i, pos);
            if(pos == 0 || (pos > 0 && checkPerfectSquare(nums[pos-1] + nums[pos]))) {
                permutate(nums, pos+1, set);
            }
            swap(nums, i, pos);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private boolean checkPerfectSquare(int num) {
        double perfectSquare = (double)Math.sqrt(num);
        if(Math.floor(perfectSquare) != Math.ceil(perfectSquare)) {
            return false;
        }
        return true;
    }
}