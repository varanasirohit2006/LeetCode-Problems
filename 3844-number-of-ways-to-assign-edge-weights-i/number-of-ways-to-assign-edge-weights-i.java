import java.util.*;

class Solution {

    private static final int MOD = 1_000_000_007;

    public int assignEdgeWeights(int[][] edges) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> children = new HashSet<>();

        for (int[] edge : edges) {
            map.computeIfAbsent(edge[0], k -> new ArrayList<>())
               .add(edge[1]);

            children.add(edge[1]);
        }

        // Find root
        int root = -1;
        for (int[] edge : edges) {
            if (!children.contains(edge[0])) {
                root = edge[0];
                break;
            }
        }

        int maxDepth = dfs(map, root);

        return (int) power(2, maxDepth - 1);
    }

    private int dfs(Map<Integer, List<Integer>> map, int node) {

        if (!map.containsKey(node)) {
            return 0;
        }

        int maxDepth = 0;

        for (int child : map.get(node)) {
            maxDepth = Math.max(maxDepth, 1 + dfs(map, child));
        }

        return maxDepth;
    }

    private long power(long a, int b) {

        if (b < 0) return 1;

        long ans = 1;

        while (b > 0) {

            if ((b & 1) == 1) {
                ans = (ans * a) % MOD;
            }

            a = (a * a) % MOD;
            b >>= 1;
        }

        return ans;
    }
}