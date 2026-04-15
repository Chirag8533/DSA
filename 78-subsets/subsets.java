class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>adj=new ArrayList<>();
        ArrayList<Integer> current=new ArrayList<>();
        solve(0,nums,current,adj);
        return adj;
    }
    public static void solve(int i,int[] nums,ArrayList<Integer>current,List<List<Integer>> adj){
        if(i==nums.length){
            adj.add(new ArrayList<>(current));
            return;
        }
        current.add(nums[i]);
        solve(i+1,nums,current,adj);
        current.remove(current.size()-1);
        solve(i+1,nums,current,adj);
    }
}