class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = firstPos(nums, target);
        int last = lastPos(nums, target);
        int[] ans = new int[2];
        ans[0] = first; ans[1] = last;
        return ans;
    }
    
    private static int firstPos(int[] A, int K) {
        int N = A.length;
        int start=0, end=N-1, ans = -1;
        
        while(start <= end) {
            int mid = (start+end)/2;
            if(A[mid] == K) {
                ans = mid; 
                end = mid -1;
            } else if(A[mid] < K) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }
    
    private static int lastPos(int[] A, int K) {
        int N = A.length;
        int start=0, end=N-1, ans = -1;
        
        while(start <= end) {
            int mid = (start+end)/2;
            if(A[mid] == K) {
                ans = mid; 
                start = mid + 1;
            } else if(A[mid] < K) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }
}