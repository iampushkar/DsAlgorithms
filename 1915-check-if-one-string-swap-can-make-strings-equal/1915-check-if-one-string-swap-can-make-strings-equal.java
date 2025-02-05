class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }

        List<Integer> idxs = new ArrayList<>();
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                idxs.add(i);
            }

            if (idxs.size() > 2) {
                return false;
            }
        }

        if (idxs.size() == 2) {
            int i = idxs.get(0);
            int j = idxs.get(1);

            return  s1.charAt(i) == s2.charAt(j) && s1.charAt(j) == s2.charAt(i);
        }

        return (idxs.size() == 0);
    }
}