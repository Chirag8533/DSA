
class Solution {
    public int minMoves(int[] nums) {
        int lar = -1;

        for (int i = 0; i < nums.length; i++) {
            lar = Math.max(lar, nums[i]);
        }

        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            count += lar - nums[i];
        }

        return count;
    }
}
