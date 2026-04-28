class Solution {
    public int largestAltitude(int[] gain) {
        int max=0;
        int sum=0;
        for(int i=0;i<gain.length;i++){
            sum=sum+gain[i];
            if(gain[i]>0){
                max=Math.max(max,sum);
            }
        }
        return max;
            

    }
}