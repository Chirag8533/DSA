class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        ArrayList<Integer>adj=new ArrayList<>();
        HashSet<Integer>set=new HashSet<>();
        int n=nums.length;
        Arrays.sort(nums);
        int largest=nums[n-1];
        int smallest=nums[0];
        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }
        for(int i=smallest+1;i<largest;i++){
            if(!set.contains(i)){
                    adj.add(i);
            }
        }
        Collections.sort(adj);
        return adj;
    }
}