class Solution {
    public String processStr(String s) {
        ArrayList<Character> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '%') {
                if (res.size() > 0) {
                    Collections.reverse(res);
                }
            } else if (s.charAt(i) == '#') {
                int ArraySize = res.size();
                for (int j = 0; j < ArraySize; j++) {
                    res.add(res.get(j));
                }
            } else if (s.charAt(i) == '*') {
                if (res.size() >= 1) {
                    res.remove(res.size() - 1);
                }
            } else {
                res.add(s.charAt(i));
            }
        }
         StringBuilder sb = new StringBuilder();
        for(int i=0;i<res.size();i++){
            sb.append(res.get(i));
        }
        return sb.toString();
    }
}