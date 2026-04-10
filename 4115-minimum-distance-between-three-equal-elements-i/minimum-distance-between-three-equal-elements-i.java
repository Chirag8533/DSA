class Solution {
    public int minimumDistance(int[] nums) {
        int n=nums.length;
        int minDist=Integer.MAX_VALUE;
        int dist=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    if(nums[i]==nums[j] && nums[j]==nums[k]){
                    dist=Math.abs(i-j)+Math.abs(j-k)+Math.abs(k-i);
                    minDist=Math.min(dist,minDist);
                    }
                }
            }
        }
        if(minDist==Integer.MAX_VALUE){
            return -1;
        }
        return minDist;
    }
}