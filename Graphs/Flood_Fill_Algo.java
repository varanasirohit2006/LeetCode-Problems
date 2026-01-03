package Graphs;



// You are given a 2D grid image[][],
//  where each image[i][j] represents the color of a pixel in the image. Also provided is a coordinate(sr, sc) representing the starting pixel (row and column) and a new color value newColor.

// Your task is to perform a flood fill starting from 
// the pixel (sr, sc), changing its color and the color of all conne
// cted pixels that have the same original color. Two pixels are considered connected 
// if they are adjacent horizontally or vertically (not diagonally) and have the same original color.
public class Flood_Fill_Algo {
    public static void pro(int [][] nums,int sr1,int sr2,int newColor){
            if(nums==null){
                System.out.println("we can have to modify");
                return;
            }
            bfs(nums,sr1,sr2,newColor);

    }
    public static  void bfs(int [][] nums,int i,int j,int newc){
        if(nums[i][j])
        nums[i][j] = newc;
        int[] d1 = {-1,1,0,0};
        int [] d2 ={0,0,-1,1};
        for(int i=0;i<nums[])

    }



    public static void main(String[] args) {
        int [][] nums={{1,1,1,0},{0,1,1,1},{1,0,1,1}};

    }
}
