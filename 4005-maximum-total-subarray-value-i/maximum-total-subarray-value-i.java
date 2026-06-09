class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int n=nums.length;
        Arrays.sort(nums);
        return 1L *(nums[n-1] -nums[0])* k;
}
}