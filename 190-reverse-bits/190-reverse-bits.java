public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for(int i=0; i<=31; i++) {
            if(checkBit(n, i)) {
                int pos = 31 - i;
                res = (1 << pos) | res; //setting the bit at pos
            }
        }
        return res;
    }
    
    private boolean checkBit(int N, int i) {
        return ((N>>i) & 1) == 1;
    }
    
}