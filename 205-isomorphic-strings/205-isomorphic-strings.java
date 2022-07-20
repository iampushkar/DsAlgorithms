class Solution {
    public boolean isIsomorphic(String s, String t) {
//         HashMap<Character, Integer> freq1 = new HashMap<>();
//         for(char c : s.toCharArray()) {
//             freq1.put(c, freq1.getOrDefault(c, 0) + 1);
//         }
        
//         HashMap<Character, Integer> freq2 = new HashMap<>();
//         for(char c : t.toCharArray()) {
//             freq2.put(c, freq2.getOrDefault(c, 0) + 1);
//         }
        
//         int[] arr1 = new int[s.length()];
//         int i=0;
//         for(char c : s.toCharArray()) {
//             arr1[i++] = freq1.get(c);
//         }
        
//         int[] arr2 = new int[t.length()];
//         int j=0;
//         for(char c : t.toCharArray()) {
//             arr2[j++] = freq2.get(c);
//         }
        
//         for(int k=0; k<arr1.length; k++) {
//             if(arr1[k] != arr2[k]) {
//                 return false;
//             }
//         }
        
//         return true;
        
        
        Map<Character, Character> map = new HashMap<>();
        Set<Character> assignedValues = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) != t.charAt(i)) {
                return false;
            }
            if (!map.containsKey(s.charAt(i)) && assignedValues.contains(t.charAt(i))) {
                return false;
            }
            map.put(s.charAt(i), t.charAt(i));
            assignedValues.add(t.charAt(i));
        }
        return true;
    
    }
}

/*
"bbbaaaba : 1 2 3 1 2 3 4 4
"aaabbbba : 1 2 3 1 2 3 4 4
*/
