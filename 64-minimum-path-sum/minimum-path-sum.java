class Solution {
    public int minPathSum(int[][] grid) {
    //     int m=grid.length;
    //     int n=grid[0].length;
    //     int[][] dp=new int[m][n];
    //     for(int i=0;i<m;i++){
    //         for(int j=0;j<n;j++){
    //             dp[i][j]=-1;
    //         }
    //     }
    //     return solve(0,0,grid,m,n,dp);
        
    // }
    // public int solve(int i,int j,int[][] grid,int m,int n,int[][] dp){ 
    //     if(i==m-1 && j==n-1){
    //         return grid[i][j];
    //     }
    //     if(i>=m || j>=n){
    //         return Integer.MAX_VALUE;
    //     } 
    //     if(dp[i][j]!=-1){
    //         return dp[i][j];
    //     }
       
       
    //     int bottom=solve(i+1,j,grid,m,n,dp);
    //     int right=solve(i,j+1,grid,m,n,dp);
    //     return dp[i][j]=grid[i][j]+Math.min(bottom,right);
    //TABULATION
    int m=grid.length;
    int n=grid[0].length;
    int[][] dp=new int[m][n];
    dp[0][0]=grid[0][0];
    for(int i=1;i<m;i++){
        dp[i][0]=dp[i-1][0]+grid[i][0];
    }
    for(int j=1;j<n;j++){
        dp[0][j]=dp[0][j-1]+grid[0][j];
    }
    for(int i=1;i<m;i++){
        for(int j=1;j<n;j++){
            dp[i][j]=grid[i][j]+Math.min(dp[i-1][j],dp[i][j-1]);
        }
    }
    return dp[m-1][n-1];

    }
}