class Solution {
    public int maxDiff(int num) {
        int maxNum = getMaxNum(num);
        int minNum = getMinNum(num);
        var result = maxNum - minNum;

        System.out.println(maxNum + " - " + minNum + " = " + result);

        return result;
    }

    private int getMaxNum(int num) {
        String str = String.valueOf(num);

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '9') {
                char toReplace = str.charAt(i);
                return Integer.valueOf(str.replace(toReplace, '9'));
            }
        }

        return num;
    }

    private int getMinNum(int num) {
        String str = String.valueOf(num);
        char toReplace;
        char replacement;

        if (str.charAt(0) != '1') {
            // Replace first digit with '1'
            toReplace = str.charAt(0);
            replacement = '1';
        } else {
            // Replace first digit (not equal to first) and not '0' with '0'
            toReplace = 0;
            replacement = '0';
            for (int i = 1; i < str.length(); i++) {
                if (str.charAt(i) != '0' && str.charAt(i) != str.charAt(0)) {
                    toReplace = str.charAt(i);
                    break;
                }
            }
            if (toReplace == 0)
                return num; // No change needed
        }

        return Integer.valueOf(str.replace(toReplace, replacement));
    }

}