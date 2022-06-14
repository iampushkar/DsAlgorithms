class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int num1 = -1, num2 = -1, c1 = 0, c2 = 0;
        
        for(int ele : nums) {
            if(num1 == ele) c1++;
            else if(num2 == ele) c2++;
            else if(c1 == 0) { num1 = ele; c1 = 1; }
            else if(c2 == 0) { num2 = ele; c2 = 1; }
            else { c1--; c2--; }
        }
        
        //after this we can have num1 and num2 as possible majority element
        List<Integer> ans = new ArrayList<>();
        
        if(checkMajority(num1, nums)) { 
            //System.out.println(num1 + " is majority ");
            ans.add(num1); 
        }
        if(num1 != num2 && checkMajority(num2, nums)) { 
            //System.out.println(num2 + " is majority ");
            ans.add(num2); 
        }
        
        return ans;
    }
    
    private boolean checkMajority(int num, int[] nums) {
        int count = 0;
        int N = nums.length;
        
        for(int n : nums) {
            if(num == n) count++;
        }
        
        if(count > N/3) {
            return true;
        } else {
            return false;
        }
    }
}