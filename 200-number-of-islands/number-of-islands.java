class Solution {
    public int numIslands(char[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        boolean[][] visited=new boolean[row][col];
        int count=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(!visited[i][j]){
                    if(grid[i][j]=='1'){
                    dfs(i,j,visited,grid);
                    count++;
                    }
                }
            }
            
        }
        return count;
    }
    public static void dfs(int i,int j,boolean[][] visited,char[][] grid){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length){
            return;
        }
        if(grid[i][j]=='0'){
            return;
        }
        if(visited[i][j]){
            return;
        }
        visited[i][j]=true;
        dfs(i+1,j,visited,grid);
        dfs(i-1,j,visited,grid);
        dfs(i,j+1,visited,grid);
        dfs(i,j-1,visited,grid);
        return;

    }
}