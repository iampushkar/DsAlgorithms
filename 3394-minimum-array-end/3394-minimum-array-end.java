class Solution {
    public long minEnd(int n, int x) {
        long res = x;

        for(int i=1; i<n; i++) {
            res += 1;
            res = res | x;
        }

        return res;
    }
}
/*
n1 AND n2 AND n3 = x

*/