class Solution {
     public static final long MOD1=1000000007L;
     public static final long MOD2=998244353L;
     public static final long BASE1=131L;
     public static final long BASE2=137L;
    public int smallestUniqueSubarray(int[] nums) {
        int n=nums.length;
        int start=1;
        int end=n;
        int ans=n;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(hasUnique(nums,n,mid)){
                ans=mid;
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return ans;
    }
    public static boolean hasUnique(int[] arr,int n,int len){
        long pow1=1L;
        long pow2=1L;
        for(int i=0;i<len-1;i++){
            pow1=(pow1*BASE1)%MOD1;
            pow2=(pow2*BASE2)%MOD2;
        }
        long h1=0L,h2=0L;
        for(int i=0;i<len;i++){
            h1=(h1*BASE1+arr[i])%MOD1;
            h2=(h2*BASE2+arr[i])%MOD2;
        }
        HashMap<Long,Integer>seen=new HashMap<>();
        long combined=h1*MOD2+h2;
        seen.put(combined,1);
        for(int i=len;i<n;i++){
            h1=(h1-arr[i-len]*pow1%MOD1+MOD1)%MOD1;
            h1=(h1*BASE1+arr[i])%MOD1;
            h2=(h2-arr[i-len]*pow2%MOD2+MOD2)%MOD2;
            h2=(h2*BASE2+arr[i])%MOD2;
            combined=h1*MOD2+h2;
            seen.merge(combined,1,Integer::sum);
        }
        for(int freq:seen.values()){
            if(freq==1){
                return true;
            }
        }
        return false;
    }
}