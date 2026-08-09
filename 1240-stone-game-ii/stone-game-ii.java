class Solution {
    int n;
    int[][] dp;
    int[] suffix;

    public int stoneGameII(int[] piles) {
        n = piles.length;

        suffix = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }

        dp = new int[n][n + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }

        return solve(0, 1);
    }

    private int solve(int i, int m) {
        if (i >= n) {
            return 0;
        }

        if (2 * m >= n - i) {
            return suffix[i];
        }

        if (dp[i][m] != -1) {
            return dp[i][m];
        }

        int ans = 0;

        for (int x = 1; x <= 2 * m && i + x <= n; x++) {
            int nextM = Math.max(m, x);

            int current = suffix[i] - solve(i + x, nextM);

            ans = Math.max(ans, current);
        }

        return dp[i][m] = ans;
    }
}