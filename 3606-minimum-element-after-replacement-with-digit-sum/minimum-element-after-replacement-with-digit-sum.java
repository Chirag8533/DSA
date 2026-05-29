class Solution {
    public int minElement(int[] nums) {
        int n=nums.length;
        int[] arr=new int[n];
        int j=0;
        for(int i=0;i<n;i++){
            arr[j]=solve(nums[i]);
            j++;
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<min){
                min=arr[i];
            }
        }
        return min;
        
    }
    public static int solve(int n){
        int cur=n;
        int sum=0;
        while(cur!=0){
            int digit=cur%10;
            sum+=digit;
            cur=cur/10;
        }
        return sum;

    }
}