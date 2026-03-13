class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp=new int[nums.length][nums.length+1];
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<=nums.length;j++){
                dp[i][j]=-1;
            }
        }
        return solve(0,nums,-1,dp);
    }
    public static int solve(int i,int[] nums,int prev,int[][] dp){
        if(i==nums.length){
            return 0;
        }
        if(dp[i][prev+1]!=-1){
            return dp[i][prev+1];
        }
        int take=0;
        if(prev==-1 || nums[i]>nums[prev]){
            take=1+solve(i+1,nums,i,dp);
        }
        int nottake=solve(i+1,nums,prev,dp);
        return dp[i][prev+1]=Math.max(take,nottake);
    }
}