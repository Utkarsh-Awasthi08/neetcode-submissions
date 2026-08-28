class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int i = 0;
        for(int j = 1; j < prices.length; j++)
        {
            if(prices[j] < prices[i])
            {
                i = j;
                continue;
            }
            int profit = prices[j] - prices[i];
            max = Math.max(max, profit);
        }
        return max;
    }
}
