class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] original = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                original[i][j] = mat[i][j];
            }
        }
        while(k-- > 0){
            for(int i=0;i<m;i++){
                if(i % 2 == 0){
                    int first = mat[i][0];
                    for(int j=0;j<n-1;j++){
                        mat[i][j] = mat[i][j+1];
                    }
                    mat[i][n-1] = first;
                } else {
                    int last = mat[i][n-1];
                    for(int j=n-1;j>0;j--){
                        mat[i][j] = mat[i][j-1];
                    }
                    mat[i][0] = last;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j] != original[i][j]) return false;
            }
        }
        return true;
    }
}