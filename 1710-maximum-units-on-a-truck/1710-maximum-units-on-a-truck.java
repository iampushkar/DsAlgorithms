class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        //greedy algorithm
        int N = boxTypes.length;
        
        Arrays.sort(boxTypes, (a,b) -> b[1] - a[1]);
        //Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[0],a[0]));
        int maxUnit = 0;
        
        for(int i=0; i<N; i++) {
            int box = boxTypes[i][0];
            int unit = boxTypes[i][1];
            
            if(box <= truckSize) {
                maxUnit += box * unit;
                truckSize -= box;
            } else {
                maxUnit += truckSize * unit;
                break;
            }
        }
        
        return maxUnit;
    }
}
