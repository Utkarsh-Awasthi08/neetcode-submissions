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
// Here we first suppose that we purchase stock on day 1. Then we proceed by checking if coming days have lesser or greater value than our current date of purchasing. If the price is less then there is no need to purchase on current day as we can prchase on a day with lower price. If price is greater then we calculate profit by assuming that we sell on that day. we then take max of all the possible profits.