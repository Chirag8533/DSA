class Solution {
    public int maxDistance(int[] colors) {
        int n=colors.length;
        int maxLen=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(colors[i]!=colors[j]){
                    maxLen=Math.max(maxLen,j-i);
                }
            }
        }
        return maxLen;
    }
}