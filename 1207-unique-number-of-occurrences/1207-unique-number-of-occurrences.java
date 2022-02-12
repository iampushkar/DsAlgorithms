class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int N = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<N; i++) {
            if(map.containsKey(arr[i])) {
                int val = map.get(arr[i]);
                map.put(arr[i], val+1);
            } else {
                map.put(arr[i], 1);
            }
        }
        
        HashSet<Integer> set = new HashSet<>();
        for(Map.Entry<Integer, Integer> e : map.entrySet()) {
            if(set.contains(e.getValue())) {
                return false;
            } else {
                set.add(e.getValue());
            }
        }
        return true;
    }
}