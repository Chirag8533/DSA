class Solution {

    int mod=1000000007;
    int[][][][] dp;

    public int numberOfStableArrays(int zero,int one,int limit){
        dp=new int[zero+1][one+1][3][limit+1];
        for(int i=0;i<=zero;i++){
            for(int j=0;j<=one;j++){
                for(int k=0;k<3;k++){
                    Arrays.fill(dp[i][j][k],-1);
                 }
               }
          }
        return solve(zero,one,2,0,limit);
    }
    public int solve(int z,int o,int last,int count,int limit){
        if(z==0 && o==0){
            return 1;
        }
        if(dp[z][o][last][count]!=-1){
            return dp[z][o][last][count];
        }
        long ans=0;
        if(z>0){
            if(last!=0){
                ans+=solve(z-1,o,0,1,limit);
            }
            else if(count<limit){
                ans+=solve(z-1,o,0,count+1,limit);
            }
        }
        if(o>0){
            if(last!=1){
                ans+=solve(z,o-1,1,1,limit);
            }
            else if(count<limit){
                ans+=solve(z,o-1,1,count+1,limit);
            }
        }
        return dp[z][o][last][count]=(int)(ans%mod);
    }
}