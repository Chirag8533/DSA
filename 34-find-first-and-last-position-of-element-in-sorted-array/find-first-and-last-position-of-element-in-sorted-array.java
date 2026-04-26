class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n=nums.length;
        int low=0;
        int high=n-1;
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                ans=mid;
                high=mid-1;
            }else if(nums[mid]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
            
        }
        int anslast=-1;
        int start=0;
        int end=n-1;
        while(start<=end){
            int mid=start+(end-start)/2;
                if(nums[mid]==target){
                    anslast=mid;
                    start=mid+1;
                }else if(nums[mid]<target){
                    start=mid+1;
                }else{
                    end=mid-1;
                }
            }
        return new int[]{ans,anslast};
    }
}