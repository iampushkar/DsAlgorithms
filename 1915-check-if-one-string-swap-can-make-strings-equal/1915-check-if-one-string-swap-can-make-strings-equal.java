class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) return true;

        List<Integer> idxs = new ArrayList<>();

        for (int i = 0; i < s1.length(); i++) {  
            if (s1.charAt(i) != s2.charAt(i)) 
                idxs.add(i);  
                
            if (idxs.size() > 2) 
                return false;  
        }

        return idxs.size() == 2 &&  
               s1.charAt(idxs.get(0)) == s2.charAt(idxs.get(1)) &&  
               s1.charAt(idxs.get(1)) == s2.charAt(idxs.get(0));  
    }  
}