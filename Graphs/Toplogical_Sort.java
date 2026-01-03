package Graphs;
import java.util.*;
public class Toplogical_Sort {

    public List<Integer> Toplogical_Sort1(List<List<Integer>> list , int v){
        int indegree[] = new int[v];
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<v;i++){
            for(int j=0;j<list.get(i).size();j++){
                int k= list.get(i).get(j);
                indegree[k]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<v;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int g = q.poll();   
            ans.add(g);
            for(int x:list.get(g)){
                indegree[x]--;
                if(indegree[x]==0){
                    q.add(x);
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        
    }    
}


