class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int len = 0;
        int single = 0;
        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            char c = entry.getKey();
            int freq = entry.getValue();
            
            if(freq % 2 == 0) {
                len += freq;
            } else {
                len += freq - 1;
                single++;
            }
        }
        
        if(single > 0) {
            len++;
        }
        return len;
    }
}