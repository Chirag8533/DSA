class Solution {
    public int minimumDeletions(int[] nums) {
        int n=nums.length;
        int min=nums[0];
        int max=nums[0];
        for(int i=0;i<n;i++){
            if(nums[i]<min){
                min=nums[i];
            }
            if(nums[i]>max){
                max=nums[i];
            }
        }
        int minIndex=0;
        int maxIndex=0;
        for(int i=0;i<n;i++){
            if(nums[i]==min){
                minIndex=i;
            }

            if(nums[i]==max){
                maxIndex=i;
            }
        }
        int total1=Math.max(minIndex,maxIndex)+1;
        int total2=n-Math.min(minIndex,maxIndex);
        int total3=minIndex+1+n-maxIndex;
        int total4=maxIndex+1+n-minIndex;
        return Math.min(Math.min(total1,total2),Math.min(total3,total4));



    }
}