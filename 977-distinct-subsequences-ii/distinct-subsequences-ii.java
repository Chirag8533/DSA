class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1000000007;
        int n = s.length();

        long[] last = new long[26];

        long dp = 1; 

        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';

            long newDp = (2 * dp - last[c] + MOD) % MOD;
            last[c] = dp;

            dp = newDp;
        }

        return (int) ((dp - 1 + MOD) % MOD);
    }
}