class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        int i=0;
        int maxJump=0;
        while(i<n){
            if(i>maxJump){
                return false;
            }
            int jump=i+nums[i]; 
            maxJump=Math.max(jump,maxJump);
            i++;
        }
        if(maxJump>=n-1){
            return true;
        }
        return false;
    
    }
}