class Solution {
    // public int[] maxSlidingWindow(int[] nums, int k) {
    //     return 
    // }
    
    public int[] maxSlidingWindow(final int[] A, int B) {
        int N = A.length;
        if(B >= N) {
            return maxOfArray(A);
        }

        Deque<Integer> deque = new ArrayDeque<>(); // Possible Candidate List
        List<Integer> list = new ArrayList<>();
        
        // this is for the first window
        for(int i=0; i<B; i++) {
            while(!deque.isEmpty() && deque.peekLast() < A[i]) {
                deque.pollLast();
            }
            deque.addLast(A[i]);
        }
        list.add(deque.peekFirst());

        //after sliding the window
        int L = 1, R = B;
        while(R < N) {
            if(!deque.isEmpty() && deque.peekFirst() == A[L-1]) {
                deque.pollFirst();
            }
            while(!deque.isEmpty() && deque.peekLast() < A[R]) {
                deque.pollLast();
            }
            deque.addLast(A[R]);
            list.add(deque.peekFirst());
            L++; R++;
        }

        //converting list to integer array
        int[] ans = list.stream()
                        .mapToInt(Integer::intValue)
                        .toArray();
        return ans;
    }

    private static int[] maxOfArray(int[] A) {
        int maxAns = Integer.MIN_VALUE;
        for(int i=0; i<A.length; i++) {
            maxAns = Math.max(maxAns, A[i]);
        }
        return new int[] {maxAns};
    }
}