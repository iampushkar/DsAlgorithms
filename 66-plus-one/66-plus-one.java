class Solution {
    public int[] plusOne(int[] digits) {
        int N = digits.length;
        for(int i=N-1; i>=0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            } 
            digits[i] = 0;
        }
        
        int[] newNum = new int[N+1];
        newNum[0] = 1;
        return newNum;
        
    }
}