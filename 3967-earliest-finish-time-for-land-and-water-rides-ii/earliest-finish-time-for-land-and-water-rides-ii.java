class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
      int n = landStartTime.length;
      int m = waterStartTime.length; 
      int mini = Integer.MAX_VALUE;
       for(int i=0;i<n;i++){
         mini = Math.min(landStartTime[i] + landDuration[i], mini); 
         }
         int ans = Integer.MAX_VALUE;
         for(int i=0;i<m;i++){
             ans = Math.min(ans, Math.max(mini, waterStartTime[i]) + waterDuration[i]); 
           }
        int mini1 = Integer.MAX_VALUE;
        for(int i=0;i<m;i++){
            mini1 = Math.min(waterStartTime[i] + waterDuration[i], mini1);
         }
        int ans1 = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            ans1 = Math.min(ans1, Math.max(mini1, landStartTime[i]) + landDuration[i]);
        }
        return Math.min(ans, ans1);
    }
}