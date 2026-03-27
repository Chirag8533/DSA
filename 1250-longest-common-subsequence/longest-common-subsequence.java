class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
        int[][] dp=new int[n+1][m+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=-1;
            }
        }
        return solve(0,0,s1,s2,dp);
    }
    public static int solve(int i,int j,String s1,String s2,int[][] dp){
        if(i==s1.length() || j==s2.length()){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int take=0;
        if(s1.charAt(i)==s2.charAt(j)){
            take=1+solve(i+1,j+1,s1,s2,dp);
        }
        int nottake=Math.max(solve(i+1,j,s1,s2,dp),solve(i,j+1,s1,s2,dp));
        dp[i][j]=Math.max(take,nottake);
        return dp[i][j];
    }
}