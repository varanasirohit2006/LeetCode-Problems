package exam_pra;

import java.util.*;

public class Graph {
    // Nested static class for Node
    static class Node {
        // Alist in Python is likely an Adjacency List, storing connected Edges
        private List<Edge> adjacencyList; 
        private int value; // 'e' from Python is the node's value/element

        public Node(int e) {
            this.adjacencyList = new ArrayList<>();
            this.value = e;
        }

        public void addtoAlist(Edge e) {
            this.adjacencyList.add(e);
        }

        // Getters are typically added in Java for access
        public int getValue() {
            return value;
        }

        public List<Edge> getAdjacencyList() {
            return adjacencyList;
        }
    }
    
    // Nested static class for Edge
    static class Edge {
        private int v1;
        private int v2;
        private int weight; // 'e' from Python is the edge's weight

        public Edge(int v1, int v2, int e) {
            this.v1 = v1;
            this.v2 = v2;
            this.weight = e;
        }

        // Getters
        public int getV1() {
            return v1;
        }

        public int getV2() {
            return v2;
        }

        public int getWeight() {
            return weight;
        }
    }

    // Main Graph structure
    // Using a HashMap to store nodes, mapping an Integer (ID) to a Node object
    private Map<Integer, Node> nodes;

    // Constructor
    public Graph() {
        this.nodes = new HashMap<>();
    }

    // Method to insert a Node
    public void insertNode(int e) {
        // This implementation assumes the key for the HashMap is the node's value (e)
        // or a sequential ID. Using a simple sequential counter for key generation
        // for better consistency with the Python printGraph loop (range(0, len(self.nodes)))
        int nodeId = this.nodes.size(); 
        Node newNode = new Node(e);
        this.nodes.put(nodeId, newNode);
    }

    // Method to insert an Edge
    public void insertEdge(int v1, int v2, int w) {
        Edge newEdge = new Edge(v1, v2, w);
        // Assuming v1 and v2 are the keys/IDs of the nodes
        Node node1 = this.nodes.get(v1);
        Node node2 = this.nodes.get(v2);

        if (node1 != null) {
            node1.addtoAlist(newEdge);
        }
        // For an undirected graph, you would also add the edge to node2
        if (node2 != null) {
             node2.addtoAlist(newEdge);
         }
    }
    
    // Method to get a Node
    public Node getNode(int e) {
        // Assuming 'e' is the key/ID in the nodes map
        return this.nodes.get(e);
    }
    
    // Placeholder methods (not implemented)
    public void DFS(int v) {
        Set <Integer> set1 = new HashSet<>();
        pro(v,set1);
        return; 
    }
    public void pro(int v,Set<Integer> set){
        Node pre = this.nodes.get(v);
        System.out.println(pre.getValue());
        set.add(v);
        for(int i=0;i<pre.getAdjacencyList().size();i++){
            if(!set.contains(pre.getAdjacencyList().get(i).getV2())){
                pro(pre.getAdjacencyList().get(i).getV2(),set);
                set.add(pre.getAdjacencyList().get(i).getV2());
            }
        }
    }
    //how dfs works if the root is in the first iterate to the node print and go it its depth

    public void BFS(int v) {
        Set<Integer> vis = new HashSet<>();
        Queue<Integer> que = new LinkedList<>();
        que.add(v);
        vis.add(v);
        while(!que.isEmpty()){  
            int p =que.poll();
            Node pre = this.nodes.get(p);
            for(int i=0;i<pre.getAdjacencyList().size();i++){
                if(!vis.contains(pre.getAdjacencyList().get(i).getV2())){
                    que.add(pre.getAdjacencyList().get(i).getV2());
                    vis.add(pre.getAdjacencyList().get(i).getV2());
                }
            }
        }
        return;
    }
    //Bfs is more complex having more complex then before so we have to take a queue data structure
    //than add this into the queue and iterate through the queueu when it will become empty 
    //it it is emprty the loops will end so this the answer for the question
    
    public void MST_prims() {
        return; 
    }

    public void MST_Krushkal() {
        return; 
    }
    
    public void ShortestPath(int start) {
        PriorityQueue<int []> que = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        Map<Integer,Integer> mp = new HashMap<>();
        for(int node:nodes.keySet()){
            mp.put(node, Integer.MAX_VALUE);
        }
        mp.put(start,0);
        que.offer(new int[]{start,0});
        while(!que.isEmpty()){
            int [] current = que.poll();
            int cur = current[0];
            int dis = current[1];
            Node pr = nodes.get(cur);
            for(Edge e: pr.getAdjacencyList()){
                int b = 0;
                if(cur == e.v1){
                    b = e.v2;
                }else{
                    b= e.v1;
                }
                int dis1 = dis+e.weight;
                if(dis1<dis){
                    mp.put(b, dis1);
                    que.offer(new int[]{b,dis1});
                }
            }

        }



        return;
    }

    // Method to print the Graph
    public void printGraph() {
        // Iterate over keys 0 up to (but not including) the size, 
        // to mimic the Python range(0, len(self.nodes))
        for (int i = 0; i < this.nodes.size(); i++) {
            Node node = this.nodes.get(i);
            
            // Check if node exists for the current index i (in case of non-sequential keys)
            if (node == null) continue; 
            
            System.out.print("Node : " + i + " element: " + node.getValue() + " ");
            
            // Iterate through the Adjacency List of the current node
            for (Edge a : node.getAdjacencyList()) {
                System.out.print("(" + a.getV1() + "," + a.getV2() + ") ");
            }
            System.out.println("");
        }
    }
}