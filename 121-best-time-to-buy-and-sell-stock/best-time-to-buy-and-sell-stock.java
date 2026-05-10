class Solution {
    public int maxProfit(int[] nums) {
        int n=nums.length;
        int maxProfit=Integer.MIN_VALUE;
        int buy=nums[0];
        for(int i=1;i<n;i++){
            int profit=0;
            if(buy<nums[i]){
                profit=nums[i]-buy;
                maxProfit=Math.max(maxProfit,profit);
            }else{
                buy=Math.min(buy,nums[i]);
            }
        }
         if(maxProfit==Integer.MIN_VALUE){
            return 0;
         }
         return maxProfit;
    }
}