package exam_pra;

import java.util.*;

public class Shortes_Distance_In_Binary_Maze {
    
    static class Point {
        int x, y, dist;
        Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    
    public static int shortestDistance(int[][] grid, int[] start, int[] end) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(start[0], start[1], 0));
        visited[start[0]][start[1]] = true;
        
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        
        while (!queue.isEmpty()) {
            Point curr = queue.poll();
            if (curr.x == end[0] && curr.y == end[1]) {
                return curr.dist;
            }
            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new Point(nx, ny, curr.dist + 1));
                }
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        int[][] grid = {
            {1, 0, 1, 1, 1},
            {1, 0, 1, 0, 1},
            {1, 1, 1, 0, 1},
            {0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1}
        };
        int[] start = {0, 0};
        int[] end = {4, 4};
        System.out.println(shortestDistance(grid, start, end));
    }
}
