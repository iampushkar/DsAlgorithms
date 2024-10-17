class Solution {
    public int maximumSwap(int num) {
        String val = String.valueOf(num);

        int maxNum = 0;
        int maxi = -1;

        int swapi = -1;
        int swapj = -1;

        for (int i = val.length() - 1; i >= 0; i--) {
            int curr = Integer.valueOf(val.charAt(i));

            if (curr > maxNum) {
                maxNum = curr;
                maxi = i;
            }

            // swap
            if (curr < maxNum) {
                swapi = i;
                swapj = maxi;
            }
        }

        // If a valid swap was found
        if (swapi != -1 && swapj != -1) {
            // Convert the string to a character array for swapping
            char[] arr = val.toCharArray();
            // Perform the swap
            char temp = arr[swapi];
            arr[swapi] = arr[swapj];
            arr[swapj] = temp;

            // Convert the character array back to an integer
            return Integer.parseInt(new String(arr));
        }

        // If no swap is needed, return the original number
        return num;

    }
}