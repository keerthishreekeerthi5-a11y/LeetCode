class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
          int n = items.length;

        int[] factor = new int[n];
        int[] price = new int[n];

        for (int i = 0; i < n; i++) {
            factor[i] = items[i][0];
            price[i] = items[i][1];
        }

        // gain from buying first copy of each item
        int[] gain = new int[n];

        for (int i = 0; i < n; i++) {
            gain[i] = 1; // purchased copy

            for (int j = 0; j < n; j++) {
                if (i != j && factor[j] % factor[i] == 0) {
                    gain[i]++;
                }
            }
        }

        int[] dp = new int[budget + 1];

        // First copies (0/1 knapsack)
        for (int i = 0; i < n; i++) {
            for (int b = budget; b >= price[i]; b--) {
                dp[b] = Math.max(dp[b],
                        dp[b - price[i]] + gain[i]);
            }
        }

        // Extra copies (unbounded knapsack)
        for (int i = 0; i < n; i++) {
            for (int b = price[i]; b <= budget; b++) {
                dp[b] = Math.max(dp[b],
                        dp[b - price[i]] + 1);
            }
        }
        return dp[budget];
    }
}            
    
