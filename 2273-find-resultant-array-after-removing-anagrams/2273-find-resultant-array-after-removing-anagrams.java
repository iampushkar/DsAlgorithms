class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>();
        int N = words.length;
        for(int i=0; i<N; ) {
            int j = i+1;
            
            while(j < N && isAnagram(words[i], words[j])) {
                j++;
            }
            
            ans.add(words[i]);
            i = j;
        }
        
        
        return ans;
    }
    
    private boolean isAnagram(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        
        for(int i=0; i<ch1.length; i++) {
            if(ch1[i] != ch2[i]) return false;
        }
        
        return true;
    }
}