class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n=nums.length;
        ArrayList<Integer>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(nums[i]==target){
                adj.add(i);
                break;
            }
        }
        for(int i=n-1;i>=0;i--){
            if(nums[i]==target){
                adj.add(i);
                break;
            }
        }
        if(adj.size()==0){
            adj.add(-1);
            adj.add(-1);
        }
        int[] arr=new int[adj.size()];
        for(int i=0;i<adj.size();i++){
           arr[i]=adj.get(i);
        }
        return arr;
    }
}