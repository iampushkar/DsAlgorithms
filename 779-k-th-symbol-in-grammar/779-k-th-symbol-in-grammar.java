class Solution {
    public int kthGrammar(int n, int k) {
        return solve(n,k) ? 1:0;
    }
    
    private static boolean solve(int n, int k) {
        if(n==1 || k==1) return false;
        
        int mid = (int)Math.pow(2, n-1) / 2;
        if(k <= mid) {
            return solve(n-1, k);
        } else {
            return !solve(n-1, k-mid);
        }
    }
}