class Solution {
    public int maxProfit(int[] prices) {
        int maxprofit=0;
        int bestbuy=prices[0];
        int n=prices.length;
        for(int i=1;i<n;i++){
            if(prices[i]>bestbuy){
                maxprofit=Math.max(maxprofit,prices[i]-bestbuy);
            }
            bestbuy=Math.min(bestbuy,prices[i]);

        }
        return maxprofit;
    }
}