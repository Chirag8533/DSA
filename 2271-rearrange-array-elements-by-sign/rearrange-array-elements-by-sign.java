class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n=nums.length;
        int[] pos=new int[n/2];
        int[] neg=new int[n/2];
        int i=0;
        int j=0;
        for(int k=0;k<n;k++){
             if(nums[k]>0){
                pos[i]=nums[k];
                 i++;
             }else{
                neg[j]=nums[k];
                j++;
            }
        }
        int[] ans=new int[n];
        i=0;
        j=0;
        int k=0;
        while(k<n){
             ans[k]=pos[i];
             k++;
             i++;
             ans[k]=neg[j];
             k++;
             j++;
        }
        return ans;
        
    }
}