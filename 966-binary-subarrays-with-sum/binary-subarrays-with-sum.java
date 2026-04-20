class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atmost(nums,goal)-atmost(nums,goal-1);
    }
    public static int atmost(int[] nums,int goal){
        if(goal<0){
            return 0;
        }
        int n=nums.length;
        int count=0;
        int left=0;
        int sum=0;
        for(int right=0;right<n;right++){
            sum=sum+nums[right];
            while(sum>goal){
                sum=sum-nums[left];
                left++;
            }
            count=count+(right-left+1);
        }
        return count;
    }
}