class Solution {
    public int[] decrypt(int[] code, int k) {
        int N = code.length;
        int[] res = new int[N];

        if (k == 0) {
            return res;
        }

        for (int i = 0; i < N; i++) {
            if (k > 0) {
                for (int j = i + 1; j < i + 1 + k; j++) {
                    res[i] += code[j % N];
                }
            } else if (k < 0) {
                for (int j = i - 1; j > i - 1 - Math.abs(k); j--) {
                    res[i] += code[Math.abs((j +  N) % N)];
                    System.out.println(i + ":" + j + " => " + res[i]);
                }
            }
        }

        return res;
    }
}