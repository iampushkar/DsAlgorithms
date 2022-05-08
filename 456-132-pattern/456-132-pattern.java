class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int N = nums.length;
        int thirdVal = Integer.MIN_VALUE;
        
        for(int i=N-1; i>=0; i--) {
            int firstVal = nums[i];
            
            if(firstVal < thirdVal) return true;
            
            while(!st.isEmpty() && firstVal > st.peek()) {
                thirdVal = st.pop();
            }
            st.push(firstVal);
        }
        return false;
    }
}