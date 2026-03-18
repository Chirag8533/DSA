class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int[][] ans=new int[grid.length+1][grid[0].length+1];
        for(int i=1;i<=grid.length;i++){
            for(int j=1;j<=grid[0].length;j++){
                ans[i][j]=grid[i-1][j-1]+ans[i-1][j]+ans[i][j-1]-ans[i-1][j-1];
            }
        }
        int count=0;
        for(int i=1;i<=grid.length;i++){
            for(int j=1;j<=grid[0].length;j++){
                if(ans[i][j]<=k){
                    count++;
                }
            }
        }
        return count;
    }
}