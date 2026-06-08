class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        ArrayList<Integer>adj1=new ArrayList<>();
        ArrayList<Integer>adj2=new ArrayList<>();
        ArrayList<Integer>adj3=new ArrayList<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]<pivot){
                adj1.add(nums[i]);
            }else if(nums[i]==pivot){
                adj2.add(nums[i]);
            }else{
                adj3.add(nums[i]);
            }
        }
        int[] ans=new int[n];
        int idx=0;
        for(int i=0;i<adj1.size();i++){
            ans[idx]=adj1.get(i);
            idx++;
        }
        for(int i=0;i<adj2.size();i++){
            ans[idx]=adj2.get(i);
            idx++;
        }
        for(int i=0;i<adj3.size();i++){
            ans[idx]=adj3.get(i);
            idx++;
        }

            return ans;
        
    }
}