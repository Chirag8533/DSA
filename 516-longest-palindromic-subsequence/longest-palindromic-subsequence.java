class Solution {
    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        return solve(0,n-1,s,dp);

    }
    public static int solve(int i,int j,String s,int[][] dp){
        if(i==j){
            return 1;
        }
        if(i>j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int take=0;
        if(s.charAt(i)==s.charAt(j)){
            take=2+solve(i+1,j-1,s,dp);
        }
        int nottake=Math.max(solve(i+1,j,s,dp),solve(i,j-1,s,dp));
        dp[i][j]= Math.max(take,nottake);
        return dp[i][j];

    }
}