import java.util.*;



public class Sol21 {
    public static void main(String[] args) {
        int arr [][] ={{0, 1, 2},{0, 3, 6},
            {1, 2, 3},
            {1, 3, 8},
            {1, 4, 5},
            {2, 4, 7},
            {3, 4, 9}};
        sol s = new sol(5); // corrected vertex count to match max node index
        s.builtgraph(arr);
        System.out.println(s.adj(3));
        System.out.println(s.shortespath(1, 4));
        System.out.println(s.primsMst(4));
    }
}


class sol{
    public Map<Integer,List<int[]>> map = new HashMap<>();
    int v ;
    public sol(int v){
        this.v = v;
    }

    public void builtgraph(int [][] edges){
        for(int i=0;i<v;i++){
            map.put(i, new ArrayList<>());
        }

        for(int i=0;i<v;i++){
            int [] nums = edges[i];
            int from = nums[0];
            int to = nums[1];
            int wei = nums[2];
            map.get(from).add(new int[]{to,wei});
            map.get(to).add(new int[]{from,wei});
        }
    }
    public List<Integer> adj(int c){
        List<Integer> list = new ArrayList<>();
        for(int [] x: map.get(c)){
            list.add(x[0]);
        }
        return list;
    }
    public List<Integer> shortespath(int a,int b){
        int dis [] = new int[v];
        PriorityQueue <int[]> pq = new PriorityQueue<>((x,y)->x[1]-y[1]);
        Arrays.fill(dis,Integer.MAX_VALUE);
        pq.add(new int[]{a,0});
        int path[] = new int[v];
        Arrays.fill(path, -1);
        while(!pq.isEmpty()){
            int [] arr = pq.poll();
            int node = arr[0];
            int dis1 = arr[1];
            if(dis1 > dis[node]) continue;
            for(int[] x:map.get(node)){
                int n1 = x[0];
                int wei = x[1];
                if(dis1+wei < dis[n1]){
                    dis[n1] = dis1+wei;
                    pq.add(new int[]{n1,dis1+wei});
                    path[n1] = node;
                }
            }
        }
        List<Integer> list4 = new ArrayList<>();
        int i = b;
        list4.add(path[i]);
        while (i!=a) {
            i=path[i];
            list4.add(i);
        }
        Collections.reverse(list4); 
        return list4;
    }

    public int primsMst(int start){
        int vis[] = new int[v];
        Arrays.fill(vis, 0);
        PriorityQueue <int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        int total = 0;
        pq.add(new int[]{start,0});
        while(!pq.isEmpty()){
            int[] n = pq.poll();
            int x = n[0];
            int y = n[1];
            if(vis[x]==1) continue;
            total+=y;
            vis[x] = 1;
            for(int[] z: map.get(x)){
                if(vis[z[0]]==0)
                pq.add(new int []{z[0],z[1]});
            }
        }   
        return total;
    }

}