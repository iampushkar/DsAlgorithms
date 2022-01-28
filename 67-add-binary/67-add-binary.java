class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length()-1;
        int j = b.length()-1;
        int carry = 0;
        
        while(i>=0 || j>=0) {
            int bit1 = (i>=0) ? a.charAt(i)-'0' : 0;
            int bit2 = (j>=0) ? b.charAt(j)-'0' : 0;
            
            int sum = bit1 + bit2 + carry;
            int digit = sum % 2;
            sb.append(String.valueOf(digit));
            carry = sum / 2;
            
            i--;
            j--;
        }
        
        if(carry == 1) sb.append("1");
        
        return sb.reverse().toString();
    }
}