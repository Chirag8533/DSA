class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] visited=new boolean[n][m];
        int maxArea=0;
        int area=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)
            if(!visited[i][j]){
               area=dfs(i,j,grid,visited);
               maxArea=Math.max(area,maxArea);
            }
        }
        return maxArea;
        
    }
    public static int dfs(int i,int j,int[][] grid,boolean[][] visited){
        if(i<0 || i>=grid.length || j<0 ||j>=grid[0].length){
            return 0;
        }
        if(grid[i][j]==0){
            return 0;
        }
        if(visited[i][j]){
            return 0;
        }
        visited[i][j]=true;
        int count=1;
        count+= dfs(i+1,j,grid,visited);
        count+= dfs(i,j+1,grid,visited);
        count+= dfs(i,j-1,grid,visited);
        count+= dfs(i-1,j,grid,visited);
        return count;
    }
}