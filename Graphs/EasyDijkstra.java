package Graphs;
import java.util.*;

public class EasyDijkstra {
    
    public static void dijkstra(int[][] graph, int start) {
        int n = graph.length;
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{start, 0});
        
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int u = current[0];
            
            // CORRECT: Loop through all vertices
            for (int v = 0; v < n; v++) {
                // Check if there's an edge from u to v
                if (graph[u][v] != 0) {
                    int newDist = dist[u] + graph[u][v];
                    if (newDist < dist[v]) {
                        dist[v] = newDist;
                        pq.add(new int[]{v, dist[v]});
                    }
                }
            }
        }
        
        // Print results
        for (int i = 0; i < n; i++) {
            System.out.println("Vertex " + i + ": " + dist[i]);
        }
    }
    
    public static void main(String[] args) {
        int[][] graph = {
            {0, 4, 2, 0, 0},
            {4, 0, 1, 5, 0},
            {2, 1, 0, 8, 10},
            {0, 5, 8, 0, 2},
            {0, 0, 10, 2, 0}
        };
        
        dijkstra(graph, 0);
    }
}