//maxAreaOfIsland LeetCode-695
package Leetcode;
public class Solution2 {
    public int maxAreaOfIsland(int[][] grid) {
        int l = grid.length;
        int k = grid[0].length;
        int max = 0;
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < k; j++) {
                if (grid[i][j] == 1) {
                    max=Math.max(func(grid, i, j),max);
                }
            }
        }
        return max;
    }

    public int func(int [][] grid,int i,int j){
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return 0;
        }
        if (grid[i][j] == 0 || grid[i][j] == 3) {
            return 0;
        }
        grid[i][j] = 3;
        int to = 0;
        int [] nums1 = {-1,1,0,0};
        int [] nums2 = {0,0,1,-1};
        for(int m=0;m<nums1.length;m++){
            to+=func(grid,i+nums1[m],j+nums2[m]);
        }
        return to+1;
    }
}