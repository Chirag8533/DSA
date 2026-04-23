class Solution {
    public int removeDuplicates(int[] nums) {
        int n=nums.length;
        Set<Integer>set=new LinkedHashSet<>();
        for(int i:nums){
            set.add(i);
        }
        int i=0;
        for(int val:set){
            nums[i]=val;
            i++;
        }
        return i;
    }
}