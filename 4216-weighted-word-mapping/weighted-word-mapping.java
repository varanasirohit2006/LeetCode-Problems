class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder s = new StringBuilder();
        
        for (int i = 0; i < words.length; i++) {
            int ans = 25 - (weightcal(words[i], weights) % 26);

            s.append((char)('a' + ans));
            
        }
        return s.toString();
    }

    public int weightcal(String s, int[] weights) {
        int weight = 0;
        for (int i = 0; i < s.length(); i++) {
            // Standard direct mapping: 'a' -> weights[0], 'b' -> weights[1], etc.
            int c = s.charAt(i) - 'a';
            weight += weights[c];
        }
        return weight;
    }
}
