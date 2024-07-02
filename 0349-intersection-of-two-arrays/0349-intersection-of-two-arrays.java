class Solution {

public int[] intersection(int[] nums1, int[] nums2) {
    // Convert nums1 to a Set<Integer>
    Set<Integer> set = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
    Set<Integer> ans = new HashSet<>();

    // Check for intersection
    for (int n : nums2) {
        if (set.contains(n)) {
            ans.add(n);
        }
    }

    // Convert the Set<Integer> to int[]
    return ans.stream().mapToInt(Integer::intValue).toArray();
}
}