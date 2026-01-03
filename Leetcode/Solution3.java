package Leetcode;
import java.util.*;
//Leetcode problem number 841 (Keys and Rooms)
public class Solution3 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        HashMap<Integer,Boolean> map = new HashMap<>();
        return dfs(rooms,map,0);
    }
    public boolean dfs(List<List<Integer>> rooms,HashMap<Integer,Boolean> map,int i){
        for(int j=0;j<rooms.get(i).size();j++){
            int m = rooms.get(i).get(j);
            if(!map.containsKey(m)){
                map.put(m,true);
                dfs(rooms,map,m);
            }
        }
        for(int l=1;l<rooms.size();l++){
            if(!map.containsKey(l)){
                return false;
            }
        }
        return true;
    }
}