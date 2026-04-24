class Solution {
    class Triplet{
        int row;
        int col;
        int time;
        Triplet(int row,int col,int time){
            this.row=row;
            this.col=col;
            this.time=time;
        }
    }
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<Triplet>q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new Triplet(i,j,0));
                }
            }
        }
        int maxTime=0;
        while(!q.isEmpty()){
            Triplet node=q.poll();
            int r=node.row;
            int c=node.col;
            int time=node.time;
            maxTime=Math.max(maxTime,time);
            if(r-1>=0 && grid[r-1][c]==1){
                grid[r-1][c]=2;
                q.add(new Triplet(r-1,c,time+1));
            }
            if(r+1<grid.length && grid[r+1][c]==1){
                grid[r+1][c]=2;
                q.add(new Triplet(r+1,c,time+1));
            }
            if(c-1>=0 && grid[r][c-1]==1){
                grid[r][c-1]=2;
                q.add(new Triplet(r,c-1,time+1));
            }
            if(c+1<grid[0].length && grid[r][c+1]==1){
                grid[r][c+1]=2;
                q.add(new Triplet(r,c+1,time+1));
            }

        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        return maxTime;
    }
}