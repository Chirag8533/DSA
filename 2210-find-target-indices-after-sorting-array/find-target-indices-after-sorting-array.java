class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        ArrayList<Integer>adj=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                adj.add(i);
            }
        }
        return adj;
    }
}