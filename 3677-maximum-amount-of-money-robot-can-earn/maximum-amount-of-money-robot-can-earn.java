class Solution {
    public int maximumAmount(int[][] coins) {
        int n=coins.length;
        int m=coins[0].length;
        Integer[][][] dp=new Integer[n][m][3];
        return solve(0,0,2,coins,dp);   
    }
    public static int solve(int i,int j,int k,int[][] coins,Integer[][][] dp){
        if(i==coins.length ||j==coins[0].length){
            return Integer.MIN_VALUE;
        }
        if(i==coins.length-1 && j==coins[0].length-1){
            if(coins[i][j]<0 && k>0){
                return 0;
            }
            return coins[i][j];
        }
        if(dp[i][j][k]!=null){
            return dp[i][j][k];
        }

        int val=coins[i][j];
        int down=solve(i+1,j,k,coins,dp);
        int right=solve(i,j+1,k,coins,dp);
        int take=val + Math.max(down,right);

        int skip=Integer.MIN_VALUE;
        if(val<0 && k>0){
            skip=Math.max( solve(i+1,j,k-1,coins,dp),solve(i,j+1,k-1,coins,dp) );
        }

        return  dp[i][j][k]=Math.max(take,skip);
    }
}