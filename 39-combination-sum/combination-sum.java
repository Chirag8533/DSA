class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>temp=new ArrayList<>();
         solve(0,nums,target,ans,temp);
         return ans;


        
    }
    public static void solve(int i,int[] nums,int target,List<List<Integer>>ans,List<Integer>temp){
       if(target==0){
        ans.add(new ArrayList<>(temp));
        return;
       }
       if(i==nums.length){
        return;
       }
       if(nums[i]<=target){
        temp.add(nums[i]);
        solve(i,nums,target-nums[i],ans,temp);
        temp.remove(temp.size() - 1);
       }
       solve(i+1,nums,target,ans,temp);

        
    }
}