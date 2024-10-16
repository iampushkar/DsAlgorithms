class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int first = m-1, second = n-1;
        int pointer = m + n - 1;
        while (first >= 0 && second >= 0) {
            if (nums1[first] >= nums2[second]) {
                nums1[pointer--] = nums1[first--];
            } else {
                nums1[pointer--] = nums2[second--];
            }
        }

        while (first >= 0) {
            nums1[pointer--] = nums1[first--];
        }
        while (second >= 0) {
            nums1[pointer--] = nums2[second--];
        }
    }
}
/*
[1 2 3 0 0 0]    [2 5 6]
     ^                ^

*/