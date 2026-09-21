class Solution {

    public long[] resultArray(int[] nums, int k) {

        long[] ans = new long[k]; 
        int[] dp = new int[k];

        for (int num : nums) {

            int[] next = new int[k];

            next[num % k]++;

            for (int r = 0; r < k; r++) {

                int newRemainder = (r * (num % k)) % k;

                next[newRemainder] += dp[r];
            }
            for (int r = 0; r < k; r++) {

                ans[r] += next[r];
            }
            dp = next;
        }
        return ans;
    }
}
