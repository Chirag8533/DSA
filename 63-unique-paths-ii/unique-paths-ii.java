class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        return solve(0,0,obstacleGrid,dp);
    }
    public static int solve(int i,int j,int[][] obstacleGrid,int[][] dp){
        if(i>=obstacleGrid.length ||j>=obstacleGrid[0].length){
            return 0;
        }
        if(obstacleGrid[i][j]==1){
            return 0;
        }
        if(i==obstacleGrid.length-1 && j==obstacleGrid[0].length-1){
            return 1;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        
        int right=solve(i+1,j,obstacleGrid,dp);
        int bottom=solve(i,j+1,obstacleGrid,dp);
        return dp[i][j]=right+bottom;
    }
}