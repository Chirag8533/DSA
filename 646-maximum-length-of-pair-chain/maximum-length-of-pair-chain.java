class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b)->a[1]-b[1]);
        int[][] dp=new int[pairs.length][pairs.length+1];
        for(int i=0;i<pairs.length;i++){
            for(int j=0;j<=pairs.length;j++){
                dp[i][j]=-1;
            }
        }
        return solve(0,-1,pairs,dp);
        

    }
    public static int solve(int i,int prev,int[][] pairs,int[][] dp){
        if(i==pairs.length){
            return 0;
        }
        if(dp[i][prev+1]!=-1){
            return dp[i][prev+1];
        }
        int take=0;
        if(prev==-1 || pairs[i][0]>pairs[prev][1]){
            take=1+solve(i+1,i,pairs,dp);
        }
        int nottake=solve(i+1,prev,pairs,dp);
        return dp[i][prev+1]=Math.max(take,nottake);

    }
}