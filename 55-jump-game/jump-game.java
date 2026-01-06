class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;

        for (int i = 0; i < n; i++) {
            if (!dp[i])
                continue;
            int farthest = Math.min(n - 1, i + nums[i]);
            for (int j = i + 1; j <= farthest; j++) {
                dp[j] = true;
            }
        }
        return dp[n - 1];
    }
}