class Solution {
    public int search(int[] nums, int target) {
        int N = nums.length;
        int k = findRotationFactor(nums);
        if(k == 0) { k = N; }
        
        if(target == nums[0]) {
            return 0;
        } else if(target > nums[0]) {
            //we have to search in 1st array - [0, k-1]
            return binarySearch(nums, target, 0, k-1);
        } else {
            //we have to search in 2nd sorted array - [k, N-1]
            return binarySearch(nums, target, k, N-1);
        }
    }
    
    private static int binarySearch(int[] arr, int target, int start, int end) {
        while(start <= end) {
            int mid = (start+end)/2;
            if(arr[mid] == target) {
                return mid;
            } else if(arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
    
    private static int findRotationFactor(int[] arr) {
        int N = arr.length;
        int start = 0, end = N-1;
        int k = 0; //rotation factor
        while(start <= end) {
            int mid = (start + end) / 2;
            if(arr[mid] < arr[0]) {
                //we are at 2nd array
                k = mid;
                end = mid - 1;
            } else {
                //we are at 1st array
                start = mid + 1;
            }
        }
        return k;
    }
}
/*
1. find the rotation factor - k
2. based on condition split the array into 2 sorted arra : [0, k-1] or [k, N-1]
3. apply binary search depending on the condition
*/