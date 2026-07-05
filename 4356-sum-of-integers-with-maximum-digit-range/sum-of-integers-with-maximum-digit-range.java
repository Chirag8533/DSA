class Solution {
    public int maxDigitRange(int[] nums) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int n=nums.length;
        int maxrange=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int cur=nums[i];
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        while(cur>0){
            int digit=cur%10;
            cur=cur/10;
            if(digit>max){
                max=digit;
            }
            if(digit<min){
                min=digit;
            }
            int range=max-min;
            map.put(nums[i],range);
            if(range>maxrange){
                maxrange=range;
            }
        }
        }
        int sum=0;
        for(int i=0;i<n;i++){
            if(map.get(nums[i])==maxrange){
                sum+=nums[i];
            }
        }
        return sum;
      
       
    }
}