class Solution {
    public int countCommas(int n) {
        int count = 0;
        long factor = 1000; // Start at the first comma threshold (1,000)

        // Count how many numbers in the range [1, n] cross each threshold
        while (n >= factor) {
            count += (n - factor + 1);
            factor *= 1000; // Move to the next comma threshold (1,000,000)
        }

        return count;
    }
}
