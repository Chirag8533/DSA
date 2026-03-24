import java.util.*;

class Solution {
    public int minCost(int n,int[] cuts) {
        int m=cuts.length;
        int[] newCuts=new int[m+2];
        newCuts[0]=0;
        newCuts[m+1]=n;
        for(int i=0;i<m;i++){
            newCuts[i+1]=cuts[i];
        }
        Arrays.sort(newCuts);
        int[][] dp=new int[m+2][m+2];
        for(int i=0;i<m+2;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(newCuts,0,m+1,dp);
    }
    int solve(int[] cuts,int i,int j,int[][] dp){
        if(j-i<=1){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans=Integer.MAX_VALUE;
        for(int k=i+1;k<j;k++){
            int cost1=solve(cuts,i,k,dp);
            int cost2=solve(cuts,k,j,dp);
            int cost=cuts[j]-cuts[i];
            ans=Math.min(ans,cost1+cost2+cost);
        }
        dp[i][j]=ans;
        return ans;
    }
}