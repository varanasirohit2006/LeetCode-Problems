class Solution {
    public boolean stoneGame(int[] piles) {
        return helper(piles,0,0,0,0,0);
    }
    public boolean helper(int [] piles,int turn,int i,int j,int sum1,int sum2){
        if(i > j){
            return (sum1 > sum2);
        }
        boolean a = false;
        boolean b = false;
        
        if(turn == 0){
            a = helper(piles,Math.abs(1-turn),i+1,j,sum1+piles[i],sum2);
            b = helper(piles,Math.abs(1-turn),i,j-1,sum1+piles[j],sum2);
        }else{
            a = helper(piles,Math.abs(1-turn),i+1,j,sum1,sum2+piles[i]);
            b = helper(piles,Math.abs(1-turn),i,j-1,sum1,sum2+piles[j]);
        }
        return a || b;
    }
}