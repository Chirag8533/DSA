class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        int maxJump=0;
        for(int i=0;i<n;i++){
            if(i>maxJump){
                return false;
            }
            int jump=i+nums[i];
            maxJump=Math.max(jump,maxJump);
            if(maxJump>=n-1){
                return true;
            }
        }
        return false;
    }
}