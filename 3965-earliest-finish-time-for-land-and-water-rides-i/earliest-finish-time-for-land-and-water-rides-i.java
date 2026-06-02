class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int n=landStartTime.length;
        int m=waterStartTime.length;
        int minTime=Integer.MAX_VALUE;
        int totalland=0;
        int totalwater=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int landFinish=landStartTime[i]+landDuration[i];
                int waterBegin=Math.max(landFinish,waterStartTime[j]);
                int totalLandFirst=waterBegin+waterDuration[j];
                int waterFinish=waterStartTime[j]+waterDuration[j];
                int landBegin=Math.max(waterFinish,landStartTime[i]);  
                int totalWaterFirst=landBegin+landDuration[i];   
                minTime=Math.min(minTime,
                Math.min(totalLandFirst,totalWaterFirst));
            }
        }
        return minTime;



        
    }
}