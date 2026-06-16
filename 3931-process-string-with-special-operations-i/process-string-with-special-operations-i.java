class Solution {
    public String processStr(String s) {
        ArrayList<Character> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch >= 'a' && ch <= 'z'){
                res.add(ch);
                continue;
            }

            if (ch == '%') {
                if (res.size() > 0) {
                    Collections.reverse(res);
                }
                continue;
            } 
            if (ch == '#') {
                int ArraySize = res.size();
                for (int j = 0; j < ArraySize; j++) {
                    res.add(res.get(j));
                }
                continue;
            } 
             if (ch == '*') {
                if (res.size() >= 1) {
                    res.remove(res.size() - 1);
                }
            } 
        }
         StringBuilder sb = new StringBuilder();
        for(int i=0;i<res.size();i++){
            sb.append(res.get(i));
        }
        return sb.toString();
    }
}