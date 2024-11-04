class Solution {
    public String makeFancyString(String s) {
        char[] arr = s.toCharArray();
        int N = s.length();
        if (N < 3) {
            return s;
        }
        StringBuilder ans = new StringBuilder();
        for (int i=0; i<N-2; i++) {
            if (arr[i] == arr[i+1] && arr[i+1] == arr[i+2]) {
                continue;
            } else {
                ans.append(arr[i]);
            }
        }
        ans.append(arr[N-2]).append(arr[N-1]);
        return ans.toString();
    }
}

/*
 l e e e t c o d e
                   
window = 3
i, i+1, i+2

ans = leetco
*/