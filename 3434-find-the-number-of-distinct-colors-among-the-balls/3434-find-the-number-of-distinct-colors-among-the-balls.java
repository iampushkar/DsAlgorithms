class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int N = queries.length;
        int balls = limit + 1;
        int[] result = new int[N];
        Map<Integer, Integer> ballToColor = new HashMap<>(); // [1, 4] [2, 5]
        Map<Integer, Integer> colorToBallFreq = new HashMap<>(); // [5, 1]

        for(int i = 0; i < N; i++) {
            int[] query = queries[i]; // 1, 3
            int ball = query[0];
            int color = query[1];

            // old ball arrives
            if (ballToColor.containsKey(ball)) { // 1
                int prevColor = ballToColor.get(ball); // 4

                if (colorToBallFreq.containsKey(prevColor)) {
                    int prevCount = colorToBallFreq.get(prevColor); // 1
                    if (prevCount == 1) {
                        colorToBallFreq.remove(prevColor);
                    } else {
                        colorToBallFreq.put(prevColor, prevCount-1);
                    }
                }
            }

            ballToColor.put(ball, color);
            colorToBallFreq.put(
                    color,
                    colorToBallFreq.getOrDefault(color, 0) + 1
            );

            int uniqueColors = colorToBallFreq.size();
            result[i] = uniqueColors; // 1, 2
        }
        return result;
    }
}

/*
limtit = 4
balls = 5

0 1 2 3 4
o o o o o
  4          = 1
    5        = 2
  3          = 2
      4      = 3

limit - 10^9 -> O(N)
result = []
counter will increase or remain same 

balls -> colors 
1     -> 4 updates to 3
2     -> 5
3.    -> 4

colors -> list of balls 
4     -> [3]  => 1 - remove if empty list
5     -> [2]  => 2
3     -> [1] 

 */