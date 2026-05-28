class Solution {
    public int mostFrequentEven(int[] nums) {
        int n=nums.length;
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<n;i++){
            if(nums[i]%2==0){
                if(map.containsKey(nums[i])){
                    map.put(nums[i],map.get(nums[i])+1);
                }else{
                    map.put(nums[i],1);
                }
            }
        }
        int candidate=-1;
        int maxFreq=0;
        for(int key:map.keySet()){
            if(map.get(key)>maxFreq){
                maxFreq=map.get(key);
                candidate=key;
            }else if(map.get(key)==maxFreq && key<candidate){
                candidate=key;
            }
        }
        return candidate;
        
    }
}