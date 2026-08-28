class Solution {
    int dp[];
    int minCost(int[] cost, int i)
    {
        if(i >= cost.length)
        return 0;

        if(dp[i] != -1)
        return dp[i];

        int cost1 = cost[i] + minCost(cost, i + 1);
        int cost2 = cost[i] + minCost(cost, i + 2);
        
        return dp[i] = Math.min(cost1, cost2);
    }
    public int minCostClimbingStairs(int[] cost) {
        dp = new int[cost.length];
        Arrays.fill(dp, -1);
        int cost1 = Math.min(minCost(cost, 0), minCost(cost, 1));
        return cost1;

    }
}
