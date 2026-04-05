class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int rows=image.length;
        int cols=image[0].length;
        boolean[][] visited=new boolean[rows][cols];
        int prevColor=image[sr][sc];
        if(prevColor==color){
            return  image;
        }
        dfs(sr,sc,image,prevColor,color);
        return image;


    }
    public static void dfs(int i,int j,int[][] image,int prevColor,int currColor){
        if(i<0 || j<0 || i>=image.length || j>=image[0].length){
            return;
        }
        if(image[i][j]!=prevColor){
            return ;
        }
        image[i][j]=currColor;
        dfs(i-1,j,image,prevColor,currColor);
        dfs(i+1,j,image,prevColor,currColor);
        dfs(i,j-1,image,prevColor,currColor);
        dfs(i,j+1,image,prevColor,currColor);
    


    }
}