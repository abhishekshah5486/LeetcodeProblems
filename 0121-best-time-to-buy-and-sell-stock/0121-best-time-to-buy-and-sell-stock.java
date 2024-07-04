class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for (int j=0; j<dp.length; j++){
            for (int k=0; k<2; k++){
                dp[j][k] = -1;
            }
        }
        int ans = solveBuySellStock(dp, prices, 0, 1);
        if (ans < 0) return 0;
        return ans;
    }
    public int solveBuySellStock(int[][] dp, int[] prices, int idx, int canBuy){
        if(canBuy==-1) return 0;
        if (idx == prices.length) return 0;
        if (dp[idx][canBuy] == -1){
            int ans1 = 0;
            if (canBuy == 1){
                ans1 = - prices[idx] + solveBuySellStock(dp, prices, idx+1, 0);
            }
            else ans1 = prices[idx] + solveBuySellStock(dp, prices, idx+1, -1);
            int ans2 = solveBuySellStock(dp, prices, idx + 1, canBuy);
            dp[idx][canBuy] = Math.max(ans1, ans2);
        }
        return dp[idx][canBuy];
    }
}