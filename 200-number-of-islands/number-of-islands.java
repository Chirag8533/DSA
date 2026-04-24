class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] visited=new boolean[n][m];
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j] && grid[i][j]=='1'){
                    dfs(i,j,grid,visited);
                    count++;
                }
            }
        }
        return count;
        
    }
    public static void dfs(int i,int j,char[][] grid,boolean[][] visited){
        if(i<0 || i>=grid.length ||  j<0 || j>=grid[0].length){
            return;
        }
        if(grid[i][j]=='0'){
            return;
        }
        if(visited[i][j]){
            return;
        }
        visited[i][j]=true;
        dfs(i+1,j,grid,visited);
        dfs(i-1,j,grid,visited);
        dfs(i,j+1,grid,visited);
        dfs(i,j-1,grid,visited);
        return;
    }
}