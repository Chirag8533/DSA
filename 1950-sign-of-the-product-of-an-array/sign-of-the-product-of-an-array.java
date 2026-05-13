class Solution {
    public int arraySign(int[] nums) {
        double prod=1;
        int n=nums.length;
        for(int i=0;i<n;i++){
            prod=prod*nums[i];
        }
        if(prod>=1){
            return 1;
        }else if(prod<0){
            return -1;
        }
        return 0;
    }
}