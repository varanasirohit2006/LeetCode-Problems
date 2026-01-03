package Leetcode;
//number of islands:
// Leetcode 200 
public class Solution1 {
    public int numIslands(char[][] grid) {
        int l = grid.length;
        int k = grid[0].length;
        int count = 0;
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < k; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    func(grid, i, j);
                }
            }
        }
        return count;
    }

    public void func(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        }
        if (grid[i][j] == '0' || grid[i][j] == 'x') {
            return;
        } else {
            grid[i][j] = 'x';
            int[] nums1 = { 0, 0, 1, -1 };
            int[] nums2 = { 1, -1, 0, 0 };
            for (int m = 0; m < nums1.length; m++) {
                func(grid, i + nums1[m], j + nums2[m]);
            }
        }
    }
}