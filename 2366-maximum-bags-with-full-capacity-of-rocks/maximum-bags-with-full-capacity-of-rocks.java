class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        for(int i=0;i<capacity.length;i++){
            capacity[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(capacity);
        int count = 0;
        for(int x : capacity){
            if(x == 0){
                count++;
                continue;
            }
            if(additionalRocks - x >= 0 ){
                additionalRocks = additionalRocks - x;
                count++;
            }
        }
        return count;
    }
}