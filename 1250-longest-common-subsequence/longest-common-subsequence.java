class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=-1;

            }
        }
        return solve(0,0,text1,text2,dp);
    }
    public static int solve(int i,int j,String text1,String text2,int[][] dp){
        if(i==text1.length() || j==text2.length()){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int take=0;
        if(text1.charAt(i)==text2.charAt(j)){
            take=1+solve(i+1,j+1,text1,text2,dp);
        }
        int nottake=Math.max(solve(i+1,j,text1,text2,dp),solve(i,j+1,text1,text2,dp));
        dp[i][j]=Math.max(take,nottake);
        return dp[i][j];
    }

}