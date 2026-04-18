class Solution {
    public int longestOnes(int[] nums, int k) {
        int n=nums.length;
        int maxlength=0;
        int i=0;
        int zeroes=0;
        for(int j=0;j<n;j++){
            if(nums[j]==0){
                zeroes++;
            }
            while(zeroes>k){
                if(nums[i]==0){
                    zeroes--;
                    
                }
                i++;
            }
            maxlength=Math.max(maxlength,j-i+1);
        }
        
        
        return maxlength;

    }
}