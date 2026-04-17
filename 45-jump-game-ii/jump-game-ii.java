class Solution {
    public int jump(int[] nums) {
        int n=nums.length;
        int maxReach=0;
        int jump=0;
        int innerReach=0;
        for(int i=0;i<n-1;i++){
            innerReach=Math.max(innerReach,i+nums[i]);
            if(i==maxReach){
                maxReach=innerReach;
                jump++;
            }
        }
        return jump;
    }
}