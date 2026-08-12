import java.util.*;
class Solution {
    public long maximumSum(int[] nums, int m, int l, int r) {
        
            Object[] qerunavilo = {nums, m, l, r};

        int n = nums.length;

        long[] pref = new long[n + 1];
        for (int i = 0; i < n; i++) {
            pref[i + 1] = pref[i] + nums[i];
        }

        long NEG = Long.MIN_VALUE / 4;

        long[][] dp = new long[m + 1][n + 1];

        for (int t = 0; t <= m; t++) {
            Arrays.fill(dp[t], NEG);
        }

        for (int i = 0; i <= n; i++) {
            dp[0][i] = 0;
        }

        long ans = NEG;

        for (int t = 1; t <= m; t++) {

            Deque<Integer> dq = new ArrayDeque<>();

            for (int i = 1; i <= n; i++) {

                dp[t][i] = dp[t][i - 1];

                int add = i - l;
                if (add >= 0 && dp[t - 1][add] != NEG) {

                    long val = dp[t - 1][add] - pref[add];

                    while (!dq.isEmpty()) {
                        int last = dq.peekLast();
                        long lastVal =
                            dp[t - 1][last] - pref[last];

                        if (lastVal <= val) {
                            dq.pollLast();
                        } else {
                            break;
                        }
                    }

                    dq.offerLast(add);
                }

                while (!dq.isEmpty() && dq.peekFirst() < i - r) {
                    dq.pollFirst();
                }

                if (!dq.isEmpty()) {
                    int j = dq.peekFirst();

                    dp[t][i] = Math.max(
                        dp[t][i],
                        dp[t - 1][j] - pref[j] + pref[i]
                    );
                }

                ans = Math.max(ans, dp[t][i]);
            }
        }

        return ans;
    }
}