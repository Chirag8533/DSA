class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        if(sum%2!=0){
            return false;
        }
        int target=sum/2;
        Boolean[][] dp=new Boolean[n][target+1];
        return solve(0,target,nums,dp);
    }
    public static boolean solve(int i,int target,int[] nums,Boolean[][] dp){
        if(i>=nums.length){
            return false;
        }
        if(target==0){
            return true;
        }
        if(dp[i][target]!=null){
            return dp[i][target];
        }
        boolean take=false;
        if(nums[i]<=target){
            take=solve(i+1,target-nums[i],nums,dp);
        }
        boolean nottake=solve(i+1,target,nums,dp);
        return dp[i][target]=take|| nottake;
    }
}