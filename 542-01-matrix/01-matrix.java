class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        boolean[][] visited=new boolean[n][m];
        Queue<Pair>q=new LinkedList<>();
        int[][] dist=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    q.add(new Pair(i,j));
                    dist[i][j]=0;
                    visited[i][j]=true;
                }
            }
        }    
            while(!q.isEmpty()){
                Pair node=q.poll();
                int r=node.row;
                int c=node.col;
                if(r-1>=0 && !visited[r-1][c]){
                    visited[r-1][c]=true;
                    dist[r-1][c]=dist[r][c]+1;
                    q.add(new Pair(r-1,c));
                }
                if(r+1<n && !visited[r+1][c]){
                    visited[r+1][c]=true;
                    dist[r+1][c]=dist[r][c]+1;
                    q.add(new Pair(r+1,c));
                }
                if(c-1>=0 && !visited[r][c-1]){
                    visited[r][c-1]=true;
                    dist[r][c-1]=dist[r][c]+1;
                    q.add(new Pair(r,c-1));
                }
                if(c+1<m && !visited[r][c+1]){
                    visited[r][c+1]=true;
                    dist[r][c+1]=dist[r][c]+1;
                    q.add(new Pair(r,c+1));
                }


          }


        
        return dist;

    }
}