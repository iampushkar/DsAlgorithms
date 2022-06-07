class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // if(m == 0) return nums2;
        // if(n == 0) return nums1;
        
        int[] merged = new int[m+n];
        int p1 = 0, p2 = 0, p3 = 0;
        
        while(p1 < m && p2 < n) {
            if(nums1[p1] < nums2[p2]) {
                merged[p3] = nums1[p1];
                p1++; p3++;
            } else {
                merged[p3] = nums2[p2];
                p2++; p3++;
            }
        }
        
        while(p1 < m) {
            merged[p3] = nums1[p1];
            p3++; p1++;
        }
        
        while(p2 < n) {
            merged[p3] = nums2[p2];
            p3++; p2++;
        }
        
        //copying to nums1
        for(int i=0; i<m+n; i++) {
            nums1[i] = merged[i];
        }
    }
}