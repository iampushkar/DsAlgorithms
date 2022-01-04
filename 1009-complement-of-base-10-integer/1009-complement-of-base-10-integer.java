class Solution {
    public int bitwiseComplement(int n) {
        if(n == 0) return 1;
        
        int i=0, j=0;
        while(i < n) {
            i += Math.pow(2, j);
            j++;
        }
        int ans = n ^ i;
        return ans;
    }
}