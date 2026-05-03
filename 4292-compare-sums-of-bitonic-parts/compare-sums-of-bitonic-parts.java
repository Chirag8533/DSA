class Solution {
    public int compareBitonicSums(int[] nums) {
        int n=nums.length;
        int peak=nums[0];
        for(int i=1;i<n;i++){
            if(nums[i-1]<nums[i] && nums[i]>nums[i+1]){
                peak=i;
                break;
            }
        }
        long asc=0;
        for(int i=0;i<=peak;i++){
            asc=asc+nums[i];
        }
        long dsc=0;
        for(int i=peak;i<n;i++){
            dsc=dsc+nums[i];
        }
        if(asc>dsc){
            return 0;
        }else if(asc<dsc){
            return 1;
        }
        return -1;
        
    }
}