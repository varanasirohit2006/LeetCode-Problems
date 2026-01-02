import java.util.*;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        g2(n, n, "", res);
        return res;
    }

    public void g2(int oc, int cc, String s, List<String> res) {

        if (oc == 0 && cc == 0) {
            res.add(s);
            return;
        }

        
        if (oc > 0) {
            g2(oc - 1, cc, s + "(", res);
        }

        
        if (cc > oc) {
            g2(oc, cc - 1, s + ")", res);
        }
    }
}