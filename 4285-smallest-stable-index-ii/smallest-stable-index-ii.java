class Solution { 
    public int firstStableIndex(int[] nums, int k) { 
        int n = nums.length; 
        int[] ArrayMax = new int[n]; 
        int[] ArrayMin = new int[n]; 
        
        int max_value = Integer.MIN_VALUE; 
        for(int i = 0; i < n; i++){ 
            ArrayMax[i] = Math.max(nums[i], max_value); 
            max_value = ArrayMax[i]; 
        } 
        
        int min_value = Integer.MAX_VALUE; 
        for(int i = n - 1; i >= 0; i--){ 
            ArrayMin[i] = Math.min(nums[i], min_value); 
            min_value = ArrayMin[i]; 
        } 
        
        // Loop from left to right to find the FIRST stable index
        for(int i = 0; i < n; i++){ 
            int dummy = ArrayMax[i] - ArrayMin[i]; 
            if(dummy <= k){ 
                return i; // Found the first index matching the criteria
            } 
        } 
        
        return -1; 
    } 
}
