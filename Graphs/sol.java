package Graphs;

import java.util.*;

class IslandNavigation {
    private Map<Integer, List<int[]>> graph = new HashMap<>();

    public void buildMap(int n, int[][] edges) {
        // Your code
        for (int i = 0; i < edges.length; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            graph.get(from).add(new int[] { to, weight });
            graph.get(to).add(new int[] { from, weight });

        }
    }

    public List<Integer> getAdjacentIslands(int island) {
        List<Integer> list = new ArrayList<>();
        for (int[] x : graph.get(island)) {
            int index = (island == x[0]) ? x[1] : x[0];
            list.add(index);
        }
        return list;

    }

    public int findShortestPath(int start, int end) {
        int[] dis = new int[graph.size()];
        int[] prev = new int[graph.size()];
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        q.add(new int[] { start, 0 });
        dis[start] = 0;
        while (!q.isEmpty()) {
            int[] nums = q.poll();
            int node = nums[1];
            int dis1 = nums[0];
            for (int[] x : graph.get(node)) {
                if (dis1 + x[2] < dis[n]) {
                    dis[node] = dis1 + x[2];
                    int index = (node == x[0]) ? x[1] : x[0];
                    prev[index] = node;
                }
            }
        }
        return dis[end];
    }

    public List<Integer> findShortestPathRoute(int start, int end) {
        int[] dis = new int[graph.size()];
        int[] prev = new int[graph.size()];
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        q.add(new int[] { start, 0 });
        dis[start] = 0;
        while (!p.isEmpty()) {
            int[] nums = q.poll();
            int node = nums[1];
            int dis1 = nums[0];
            for (int[] x : graph.get(node)) {
                if (dis1 + x[2] < dis[node]) {
                    dis[node] = dis1 + x[2];
                    int index = (node == x[0]) ? x[1] : x[0];
                    prev[index] = node;
                }
            }
        }
        List<Integer> lisr = new ArrayList<>();
        int i=end;
        while(prev[i] != start){
            lisr.add(prev[i]);
            i = prev[i];  
        }
        lisr.add(prev[i]);
        return lisr;

    }

}

public class sol {
    public static void main(String[] args) {

    }
}