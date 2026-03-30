class Solution {
    public int sortableIntegers(int[] nums) {
        int n=nums.length;
        long result=0;
        for(int k=1;k<=n;k++){
            if(n%k!=0) continue;
            if(isSortable(nums,n,k)){
                result+=k;
            }
        }
        return (int)result;
        
    }
    private boolean isSortable(int[] arr,int n,int k){
        int blocks=n/k;
        int[] blockStart=new int[blocks];
        for(int b=0;b<blocks;b++){
            int start=b*k;
            int end=start+k;
            int Idx=-1;
            int Count=0;
            for(int i=start;i<end-1;i++){
                if(arr[i]>arr[i+1]){
                    Count++;
                    Idx=i;
                }
            }
            if(Count>1){
                return false;
            }
            if(Count==0){
                blockStart[b]=start;
            }else{
                blockStart[b]=Idx+1;
                if(arr[end-1]>arr[start]){
                    return false;
                }
            }
        }
            for(int b=0;b<blocks-1;b++){
                int currEnd=(blockStart[b]==b*k)?b*k+k-1:blockStart[b]-1;
                int nextBegin=blockStart[b+1];
                if(arr[currEnd]>arr[nextBegin]){
                    return false;
                }
                
            }
        return true;
        
    }
}