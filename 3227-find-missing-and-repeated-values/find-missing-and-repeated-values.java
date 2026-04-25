class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n=grid.length;
        int repeat=0;
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(map.containsKey(grid[i][j])){
                    repeat=grid[i][j];
                }else{
                    map.put(grid[i][j],1);
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