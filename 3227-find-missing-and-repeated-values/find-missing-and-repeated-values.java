class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n=grid.length;
        int repeat=0;
        HashSet<Integer>set=new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(set.contains(grid[i][j])){
                    repeat=grid[i][j];
                }else{
                    set.add(grid[i][j]);
                }
            }
        }
        int sum=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                sum=sum+grid[i][j];
            }
        }
        int N=n*n;
        int totalSum=N*(N+1)/2;
        int diff=sum-repeat;
        int number=totalSum-diff;
        return new int[]{repeat,number};
    }
}