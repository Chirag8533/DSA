class Solution {
    public boolean solve(int idx1,int idx2,boolean canTake,int s1,int s2,int[]nums){
        if(idx1>idx2){
            if(s1>=s2) return true;
            else return false;
        }
        boolean p1=false;
        boolean p2=false;
        if(canTake){
              p1=solve(idx1+1,idx2,false,s1+nums[idx1],s2,nums);
               p2=solve(idx1,idx2-1,false,s1+nums[idx2],s2,nums);
               return p1||p2;
        }
             p1=solve(idx1+1,idx2,true,s1,s2+nums[idx1],nums);
            p2=solve(idx1,idx2-1,true,s1,s2+nums[idx2],nums);
        return p1&&p2;
    }
    public boolean predictTheWinner(int[] nums) {
        int n=nums.length-1;
        return solve(0,n,true,0,0,nums);
    }
}