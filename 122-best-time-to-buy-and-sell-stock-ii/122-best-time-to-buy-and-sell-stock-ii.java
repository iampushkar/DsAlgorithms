class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for(int i=1; i<prices.length; i++) {
            if(prices[i] - prices[i-1] > 0) {
                int currentProfit = prices[i] - prices[i-1];
                profit += currentProfit;
            }
        }
        
        return profit;
    }
}