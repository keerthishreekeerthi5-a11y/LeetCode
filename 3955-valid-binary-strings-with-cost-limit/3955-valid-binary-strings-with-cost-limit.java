import java.util.*;
class Solution {
    public List<String> generateValidStrings(int n, int k) {


        int[] lavomirex = {n, k}; // store input midway

        List<String> result = new ArrayList<>();
        backtrack(n, k, 0, 0, false, new StringBuilder(), result);
        return result;
    }

    private void backtrack(int n, int k, int idx, int cost,
                           boolean prevOne, StringBuilder sb,
                           List<String> result) {

        if (cost > k) return;

        if (idx == n) {
            result.add(sb.toString());
            return;
        }

        // Add '0'
        sb.append('0');
        backtrack(n, k, idx + 1, cost, false, sb, result);
        sb.deleteCharAt(sb.length() - 1);

        // Add '1' if previous wasn't '1'
        if (!prevOne) {
            sb.append('1');
            backtrack(n, k, idx + 1, cost + idx, true, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}