package exam_pra;
import java.util.*;
import java.io.*;

public class PirateNavigationSystem {
    
    static class Node {
        int value;
        List<Edge> Alist;
        
        Node(int e) {
            // TO DO: Initialize node
            this.value = e;
            this.Alist = new ArrayList<>();
        }
        
        void addtoAlist(Edge e) {
            this.Alist.add(e);
        }
    }
    
    static class Edge {
        int v1, v2, weight;
        
        Edge(int v1, int v2, int e) {
            this.v1 = v1;
            this.v2 = v2;
            this.weight = e;
        }
    }
    
    static class Graph_AList {
        Map<Integer, Node> nodes;
        
        Graph_AList() {
            nodes = new HashMap<>();
        }
        
        void BuildMap(int N, List<int[]> edges) {
            for(int i=0;i<N;i++){
                Node node = new Node(i);
                nodes.put(i, node);
                Edge edge = new Edge(edges.get(i)[0],edges.get(i)[1] , edges.get(i)[2]);
                node.Alist.add(edge);
            }

        }
        
        void insertNode(int e) {
            // TO DO: Insert a node
            if(!nodes.containsKey(e)){
                Node node = new Node(e);
                nodes.put(e,node);
            }
        }
        
        void insertEdge(int v1, int v2, int w) {
            // TO DO: Insert an edge between v1 and v2 with weight w
            if(!nodes.containsKey(v1))  {Node node1 = new Node(v1);
                nodes.put(v1,node1);}
            if(!nodes.containsKey(v2))  {Node node2 = new Node(v2);
                nodes.put(v2,node2);}
            Edge edge = new Edge(v1, v2, w);
            nodes.get(v1).Alist.add(edge);
            nodes.get(v2).Alist.add(edge);
        }
        
        Node getNode(int e) {
            // TO DO: Return node with value e
            if(nodes.containsKey(e)){
                return nodes.get(e);
            }
            return null;
        }
        
        List<Integer> LoggerPose(int C) {
            List<Integer> list1 = new ArrayList<>();
            // TO DO: Return list of adjacent islands to island C
            if(!nodes.containsKey(C)){
                System.out.println("there is no island in the graph");
                return null;
            }
            List<Edge> list = nodes.get(C).Alist;
            for(int i=0;i<list.size();i++){
                if(list.get(i).v1 == C){
                    list1.add(list.get(i).v2);
                }else{
                    list1.add(list.get(i).v1);
                }
            }
            return list1;
        }
        
        int RoutePlanner(int C) {
            // TO DO: Return minimum cost to visit all islands starting from C (MST)
            PriorityQueue <int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
            int sum=0;
            int n1 =nodes.size();
            int [] visited = new int[n1];
            for(int i=0;i<n1;i++){
                visited[i] = 0;
            }
            pq.add(new int []{0,C});
            while(!pq.isEmpty()){
                int [] m = pq.poll();
                int dis = m[0];
                int node = m[1];
                if(visited[node]==1){
                    continue;
                }
                sum+=dis;
                Node n = nodes.get(node);
                for(Edge edge:n.Alist){
                    int weight = edge.weight;
                    int n3 = (node==edge.v1)? edge.v2 : edge.v1;
                    if(visited[n3]==0){
                        pq.add(new int[]{weight,n3});
                    }
                }
            }

            return sum;
        }
        //dijkistra algorithm
        List<Integer> ShortestPath(int C, int K) {

            int [] dis = new int[nodes.size()];
            for(int i=0;i<nodes.size();i++){
                dis[i] = Integer.MAX_VALUE;
            }
            int [] pre = new int[nodes.size()];
           PriorityQueue <int []> pq = new PriorityQueue<>((a,b)->Integer.compare(a[0], b[0]));
            pq.add(new int []{0,0});
            while (!pq.isEmpty()) {
                int [] w = pq.poll();
                for(Edge  edge: nodes.get(w[1]).Alist){
                    int nweight  = w[0]+edge.weight;
                    if(dis[w[1]]>nweight){
                        dis[w[1]] = nweight;
                        pre[w[1]] = w[1];
                    }
                }
            }
            return new ArrayList<>();
        }
        
        void printGraph() {
            // TO DO: Print graph structure (optional for debugging)
        }
    }
    
    public static void main(String[] args) {
        Graph_AList graph = new Graph_AList();
        Scanner scanner = new Scanner(System.in);
        List<String> outputs = new ArrayList<>();
        
        try {
            int opCount = Integer.parseInt(scanner.nextLine().trim());
            
            String[] graphInfo = scanner.nextLine().split(" ");
            int N = Integer.parseInt(graphInfo[0]);
            List<int[]> edges = new ArrayList<>();
            
            for (int i = 1; i < graphInfo.length; i += 3) {
                int u = Integer.parseInt(graphInfo[i]);
                int v = Integer.parseInt(graphInfo[i + 1]);
                int w = Integer.parseInt(graphInfo[i + 2]);
                edges.add(new int[]{u, v, w});
            }
            
            graph.BuildMap(N, edges);
            
            for (int i = 0; i < opCount; i++) {
                String[] operation = scanner.nextLine().split(" ");
                String command = operation[0];
                
                switch (command) {
                    case "B":
                        outputs.add("Map built successfully");
                        break;
                        
                    case "LP":
                        int currentIsland = Integer.parseInt(operation[1]);
                        List<Integer> adjacent = graph.LoggerPose(currentIsland);
                        StringBuilder sb = new StringBuilder();
                        for (int j = 0; j < adjacent.size(); j++) {
                            if (j > 0) sb.append(" ");
                            sb.append(adjacent.get(j));
                        }
                        outputs.add(sb.toString());
                        break;
                        
                    case "RP":
                        int startIsland = Integer.parseInt(operation[1]);
                        int cost = graph.RoutePlanner(startIsland);
                        outputs.add(String.valueOf(cost));
                        break;
                        
                    case "SP":
                        int from = Integer.parseInt(operation[1]);
                        int to = Integer.parseInt(operation[2]);
                        List<Integer> path = graph.ShortestPath(from, to);
                        StringBuilder pathSb = new StringBuilder();
                        for (int j = 0; j < path.size(); j++) {
                            if (j > 0) pathSb.append(" ");
                            pathSb.append(path.get(j));
                        }
                        outputs.add(pathSb.toString());
                        break;
                }
            }
            
            for (String output : outputs) {
                System.out.println(output);
            }
            
        } catch (Exception e) {
            System.err.println("Error processing input: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}