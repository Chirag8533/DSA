class Solution {
    public boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n + 1];
        int[] squares = new int[(int)Math.sqrt(n)];
        int count = 0;
        for (int i = 1; i * i <= n; i++) {
            squares[count++] = i * i;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < count && squares[j] <= i; j++) {
                if (!dp[i - squares[j]]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}