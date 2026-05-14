class Solution {
    public boolean isGood(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int max=n-1;
        int count=2;
        HashSet<Integer>set=new HashSet<>();
        for(int i=0;i<n-1;i++){
            if(nums[i]!=i+1){
                return false;
            }
        }
        if(nums[n-1]!=n-1){
            return false;
        }
        return true;
        
    }
}