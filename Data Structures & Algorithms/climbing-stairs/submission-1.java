class Solution {
    int dp[];
    int total(int n, int curr)
    {
        if(curr > n)
        return 0;

        if(curr == n)
        return 1;

        if(dp[curr] != -1)
        return dp[curr];

        int ways = 0;
        ways+= total(n, curr + 1);
        ways+= total(n, curr + 2);
        dp[curr] = ways;
        return ways;
    }
    public int climbStairs(int n) {
        dp = new int[n];
        Arrays.fill(dp, -1);
        return total(n, 0);
    }
}
