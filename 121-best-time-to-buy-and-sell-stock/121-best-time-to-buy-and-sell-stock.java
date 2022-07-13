class Solution {
    public int maxProfit(int[] prices) {
        int minBuy = Integer.MAX_VALUE;
        int profit = 0;
        
        for(int p : prices) {
            if(p < minBuy) {
                minBuy = p;
            } else if(p - minBuy > profit){
                profit = p - minBuy;
            }
        }
        
        return profit;
    }
}