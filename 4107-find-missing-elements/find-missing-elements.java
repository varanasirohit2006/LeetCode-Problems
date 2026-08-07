class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int min1 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE;
        HashSet<Integer> set = new HashSet<>();
        for(int x : nums){
            min1 = Math.min(min1,x);
            max1 = Math.max(max1,x);
            set.add(x);
        }

        ArrayList<Integer> res = new ArrayList<>();
        for(int i=min1;i<=max1;i++){
            if(!set.contains(i)){
                res.add(i);
            }
        }

        return res;



    }
}