class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n=cardPoints.length;
        int sum=0;
        int maxSum=0;
        for(int i=0;i<k;i++){
           sum=sum+cardPoints[i];
        }
        maxSum=sum;
        int i=k-1;
        int r=n-1;
        while(i>=0 ){
            sum=sum-cardPoints[i]+cardPoints[r];
            i--;
            r--;
            maxSum=Math.max(maxSum,sum);
        }
        return maxSum;
    }
}