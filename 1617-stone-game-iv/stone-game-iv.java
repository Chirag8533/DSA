class Solution {
    public boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n + 1];

        // Precompute all perfect squares <= n
        int[] squares = new int[(int)Math.sqrt(n)];
        int count = 0;

        for (int i = 1; i * i <= n; i++) {
            squares[count++] = i * i;
        }

        // dp[0] = false
        // No move is possible when there are 0 stones.

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < count && squares[j] <= i; j++) {

                // If we can leave a losing state for opponent,
                // then current player wins.
                if (!dp[i - squares[j]]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}