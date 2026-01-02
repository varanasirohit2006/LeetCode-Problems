import java.util.*;

class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        // sort indices by units per box descending
        Integer[] nums = new Integer[boxTypes.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i;
        }

        Arrays.sort(nums, (i, j) -> boxTypes[j][1] - boxTypes[i][1]);

        int maxunits = 0;

        for (int idx : nums) {
            int boxes = boxTypes[idx][0];
            int unitsPerBox = boxTypes[idx][1];

            if (truckSize >= boxes) {
                maxunits += boxes * unitsPerBox;
                truckSize -= boxes;
            } else {
                maxunits += truckSize * unitsPerBox;
                truckSize = 0;
            }

            if (truckSize == 0) {
                break;
            }
        }

        return maxunits;
    }
}