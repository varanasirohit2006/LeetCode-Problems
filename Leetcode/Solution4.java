// User function Template for Java
package Leetcode;
//shortest distance in maze from source to destination
import java.util.*;
class Solution {
    class Tuple{
        int dis;
        int x;
        int y;
        Tuple(int dis,int x,int y){
            this.dis = dis;
            this.x = x;
            this.y = y;
        }
    }
    
    boolean isSafe(int [][] grid,int x,int y){
        int a = grid.length;
        int b = grid[0].length;
        if(x<0 || y<0 || x>=a || y>=b || grid[x][y]==0){
            return false;
        }
        return true;
    }

    int shortestPath(int[][] grid, int[] source, int[] destination) {
        if (grid[source[0]][source[1]] == 0 || grid[destination[0]][destination[1]] == 0) return -1;
        Queue<Tuple> q = new LinkedList<>();
        int [][] dist = new int[grid.length][grid[0].length];
        for(int i=0;i<dist.length;i++){
            for(int j=0;j<dist[0].length;j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        
        dist[source[0]][source[1]] = 0;
        q.add(new Tuple(0,source[0],source[1]));
        while(!q.isEmpty()){
            Tuple t = q.poll();
            int [] nums1 = {-1,1,0,0};
            int [] nums2 = {0,0,1,-1};
            for(int i=0;i<nums1.length;i++){
                int r = t.x+nums1[i];
                int c = t.y +nums2[i];
                //we are traversing only shortest path so if we get first this is the 
                //shortest amoung all so we should return this while we enter the destination
                //or you can traverse through all the one so you get the same answer 
                //because we are only incrementing only one by once so...
                if(r == destination[0] && c==destination[1]){
                    return t.dis+1;
                }
                if(isSafe(grid,r,c) && t.dis+1<dist[r][c] ){
                    dist[r][c] = t.dis+1;
                    q.add(new Tuple(t.dis+1,r,c));
                }
            }
        }
        return -1;

        
    }
}
