class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n=nums.length;
        int maxLen=Integer.MAX_VALUE;
        int count=0;
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                sum+=nums[j];
                if(sum==goal){
                    maxLen=Math.max(maxLen,j-i+1);
                    count++;
                }
            }
        }
        return count;
        
    }
}