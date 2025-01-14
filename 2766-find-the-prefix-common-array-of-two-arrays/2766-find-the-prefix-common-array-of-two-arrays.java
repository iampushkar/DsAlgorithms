class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int N = A.length;
        int[] result = new int[N];

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int i = 0; i<N; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
            if (map.get(A[i]) == 2) {
                count++;
            }

            map.put(B[i], map.getOrDefault(B[i], 0) + 1);
            if (map.get(B[i]) == 2) {
                count++;
            }

            result[i] = count;
        }

        return result;
    }
}