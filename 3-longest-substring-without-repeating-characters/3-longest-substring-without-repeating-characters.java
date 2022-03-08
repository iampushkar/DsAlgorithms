class Solution {
    public int lengthOfLongestSubstring(String s) {
        int N = s.length();
        int i=0, j=0, count=0, ans=Integer.MIN_VALUE;
        HashSet<Character> set = new HashSet<>();
        char[] arr = s.toCharArray();
        while(i<N && j<N) {
            char val = arr[j];
            if(!set.contains(val)) {
                set.add(val);
                count=j-i+1;
                ans = Math.max(ans, count);
                j++;
            } else {
                if(set.contains(arr[i])) {
                    set.remove(arr[i]);
                    i++;
                }
                count = 0;
            }
        }
        if(ans == Integer.MIN_VALUE) {
            ans = 0;
        }
        return ans;
    }
}