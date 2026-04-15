class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
        HashMap<Integer,Integer>map=new HashMap<>();
        int maxFreq=-1;
        int number=-1;
        for(int i=0;i<n;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }
            if(maxFreq<map.get(nums[i])){
                maxFreq=map.get(nums[i]);
                number=nums[i];
            }
        }
        return number;
    }
}