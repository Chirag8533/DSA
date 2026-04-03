class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        Integer[][][] dp=new Integer[n][2][2];
        return solve(0,1,1,prices,dp);
    }
    public static int solve(int i,int flag,int cap,int[] prices,Integer[][][] dp){
        if(i==prices.length|| cap==0){
            return 0;
        }
        if(dp[i][flag][cap]!=null){
            return dp[i][flag][cap];
        }
        int profit=0;
        if(flag==1){
            int buy=-prices[i]+solve(i+1,0,cap,prices,dp);
            int skip=solve(i+1,1,cap,prices,dp);
            profit=Math.max(buy,skip);
        }else{
             int sell=+prices[i]+solve(i+1,1,cap-1,prices,dp);
             int skip=solve(i+1,0,cap,prices,dp);
             profit=Math.max(sell,skip);
        }
        return dp[i][flag][cap]=profit;
    }
}