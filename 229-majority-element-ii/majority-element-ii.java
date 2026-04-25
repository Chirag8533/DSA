class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n=nums.length;
        int target=n/3;
        List<Integer>adj=new ArrayList<>();
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<n;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }
        }
        for(int key:map.keySet()){
            if(map.get(key)>target){
                adj.add(key);
            }
        }
        return adj;
    }
}