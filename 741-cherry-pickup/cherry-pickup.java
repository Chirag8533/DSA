class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        Integer[][][] dp = new Integer[n][n][n];
        return Math.max(0, solve(0,0,0,grid,dp));
    }
    public int solve(int r1, int c1, int r2, int[][] grid, Integer[][][] dp){
        int n = grid.length;
        int c2 = r1 + c1 - r2;
        if(r1>=n || c1>=n || r2>=n || c2>=n || grid[r1][c1]==-1 || grid[r2][c2]==-1){
            return Integer.MIN_VALUE;
        }
        if(r1==n-1 && c1==n-1){
            return grid[r1][c1];
        }
        if(dp[r1][c1][r2] != null){
            return dp[r1][c1][r2];
        }
        int cherries = 0;
        if(r1==r2 && c1==c2){
            cherries += grid[r1][c1];
        } else {
            cherries += grid[r1][c1] + grid[r2][c2];
        }
        int max = Math.max(
            Math.max(solve(r1+1,c1,r2+1,grid,dp), solve(r1,c1+1,r2,grid,dp)),
            Math.max(solve(r1+1,c1,r2,grid,dp), solve(r1,c1+1,r2+1,grid,dp)));
        cherries += max;
        return dp[r1][c1][r2] = cherries;
    }
}