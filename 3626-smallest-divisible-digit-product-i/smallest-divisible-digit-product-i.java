class Solution {
    public int smallestNumber(int n, int t) {
        int i = n;
        while(true){
            int j = i;
            int prod = 1;
            while(j > 0){
                prod = prod * (j%10);
                j=j/10;
            }
            if((prod % t )== 0 ){
                return i;
            } 
            i++;
        }
    }
}