class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {

        HashMap<String, Integer> freqMap = new HashMap<>();
        String[] words1 = s1.split(" ");
        String[] words2 = s2.split(" ");

        for (String word : words1) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        for (String word : words2) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        List<String> ans = new ArrayList<>();
        for (Map.Entry<String, Integer> entry: freqMap.entrySet()) {
            if (entry.getValue() == 1) {
                ans.add(entry.getKey());
            }
        }

        return ans.toArray(new String[0]);
    }
}