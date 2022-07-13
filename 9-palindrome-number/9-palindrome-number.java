class Solution {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        char[] ch = s.toCharArray();
        
        int i=0, j=s.length()-1;
        while(i <= j) {
            if(ch[i] == ch[j]) {
                i++; j--;
            } else {
                return false;
            }
        }
        return true;
    }
}