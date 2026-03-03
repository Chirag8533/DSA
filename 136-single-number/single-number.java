class Solution {
    public int singleNumber(int[] nums) {
        // HashSet<Integer> set=new HashSet<>();
        // for(int i=0;i<nums.length;i++){
        //     if(!set.contains(nums[i])){
        //     set.add(nums[i]);
        //     }else{
        //         set.remove(nums[i]);
        //     }
        // }
        // for(int ele:set){
        //     return ele;
        // }
        // return 0;
        //USINT BIT MANUIPULATION no extra sapce;
        int curr=nums[0];
        for(int i=1;i<nums.length;i++){
            curr=curr^nums[i];
        }
        return curr;



    }
}