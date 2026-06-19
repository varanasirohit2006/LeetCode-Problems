class Solution {
    public int largestAltitude(int[] gain) {
        int max1 = 0;
        int runningSum = 0;
        for(int i=0;i<gain.length;i++){
            runningSum+=gain[i];
            max1  = Math.max(max1,runningSum);
        }

        return max1;
    }
}