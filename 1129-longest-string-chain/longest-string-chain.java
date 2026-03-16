class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words,(a,b)->a.length()-b.length());
        int n=words.length;
        int[][] dp=new int[n][n+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<=n;j++){
                dp[i][j]=-1;
            }
        }

        return solve(0,-1,words,dp);

    }
    public static int solve(int i,int prev,String[] words,int[][] dp){
        if(i==words.length){
            return 0;
        }
        if(dp[i][prev+1]!=-1){
            return dp[i][prev+1];
        }
        int take=0;
        if(prev==-1 || IsPredesor(words[prev],words[i])){
            take=1+solve(i+1,i,words,dp);
        }
        int nottake=solve(i+1,prev,words,dp);
        return dp[i][prev+1]=Math.max(take,nottake);
    }
    public static boolean IsPredesor(String s1,String s2){
        if(s2.length()-s1.length()!=1){
            return false;
        }
        int i=0;
        int j=0;
        while(i<s1.length()&& j<s2.length()){
            if(s1.charAt(i)==s2.charAt(j)){
                i++;
                j++;
            }else{
                j++;
            }
        }
        if(i==s1.length()){
            return true;
        }
        return false;
    }
}