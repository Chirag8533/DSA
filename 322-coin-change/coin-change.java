class Solution {
    public int coinChange(int[] coins, int amount) {
        int [][] dp=new int[coins.length][amount+1];
        for(int i=0;i<coins.length;i++){
            for(int j=0;j<=amount;j++){
                dp[i][j]=-1;
            }
        }
        int ans=solve(0,coins,amount,dp);
        if(ans==Integer.MAX_VALUE){
            return -1;
        }
        return ans;
    }
    public static int solve(int i,int[] coins,int amount,int[][] dp){
        if( amount==0){
            return 0;
        }
        if(i==coins.length && amount>0){
            return Integer.MAX_VALUE;
        }
        if(dp[i][amount]!=-1){
            return dp[i][amount];
        }
        int take=Integer.MAX_VALUE;
        if(coins[i]<=amount){
            int cur=solve(i,coins,amount-coins[i],dp);
            if(cur!=Integer.MAX_VALUE){
                take=1+cur;
            }
        }
        int nottake=solve(i+1,coins,amount,dp);
        return dp[i][amount]=Math.min(take,nottake);
    }
}