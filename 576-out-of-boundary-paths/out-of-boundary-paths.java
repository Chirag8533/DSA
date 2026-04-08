class Solution {
    static int mod=1000000007;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] dp=new int[m][n][maxMove+1];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<=maxMove;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        return solve(startRow,startColumn,m,n,maxMove,dp);
        
    }
    public static int solve(int i,int j,int m,int n,int moves,int[][][] dp){
        if(i<0 ||j<0 || i>=m ||j>=n){
           return 1;
        }
        if(moves==0){
            return 0;
        }
        if(dp[i][j][moves]!=-1){
            return dp[i][j][moves];
        }
        int up=solve(i-1,j,m,n,moves-1,dp);
        int down=solve(i+1,j,m,n,moves-1,dp);
        int right=solve(i,j+1,m,n,moves-1,dp);
        int left=solve(i,j-1,m,n,moves-1,dp);
        return dp[i][j][moves]=((up+down)%mod+(right+left)%mod)%mod;
    }
}