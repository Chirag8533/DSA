class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int row=mat.length;
        int col=mat[0].length;
        int index=0;
        int maxCount=0;
        for(int i=0;i<row;i++){
            int count=0;
            for(int j=0;j<col;j++){
                count+=mat[i][j];
            }
            if(count>maxCount){
                maxCount=count;
                index=i;
            }
        }
        return new int[]{index,maxCount};
    }
}