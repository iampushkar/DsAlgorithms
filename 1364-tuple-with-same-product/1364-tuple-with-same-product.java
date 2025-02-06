class Solution {
    public int tupleSameProduct(int[] nums) {
        int N = nums.length;
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int i = 0; i < N-1; i++) {
            for (int j = i+1; j < N; j++) {
                int pair = nums[i] * nums[j];
                freqMap.put(
                    pair, 
                    freqMap.getOrDefault(pair, 0) + 1
                    );
            }
        }

        int tupleCount = 0;
        for (Map.Entry<Integer, Integer> e : freqMap.entrySet()) {
            int pairProd = e.getKey();
            int freq = e.getValue();

            tupleCount += 8 * N_C_2(freq);
        }

        return tupleCount;
    }

    private int N_C_2(int N) {
        return (N * (N - 1)) / 2;
    }
}


/*
find out all the possible pairs (a, b) : nC2 = (n * (n-1)) / 2
get the freq of occurrence of each pair (a * b) - keep a freq map
    freq = 1 => 0 tuples
    freq = 2 => we have a 2 valid pair => 2C2 => 2C2 * 8 = 8 tuples
    freq = 3 => we can have 3 valid pairs => 3C2 * 8 tuples = 3 * 8 = 24 tuples
    freq = 4 => 4 valid pairs => 4C2 * 8 => (4 * 3)/2 * 8 = 48 tuples
    .
    .
finally we can count the tuples
 */
 
 
 
 // 454 | 1010