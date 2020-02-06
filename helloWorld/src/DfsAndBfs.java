import java.util.*;

public class DfsAndBfs {
    static class Graph{
        int V;
        int E;
        List<Integer>[] edges ;
        public Graph(int vertices){
        this.V= vertices;
        edges = new LinkedList[V];
        for(int v= 0;v<V;v++){
            edges[v] = new LinkedList<>();
        }
        }
        public void addEdge(int u,int v){
            if (v < 0 || v >= V) throw new IndexOutOfBoundsException();
            if (u < 0 || u >= V) throw new IndexOutOfBoundsException();
            E++;
        edges[u].add(v);
        edges[v].add(u);
        }
        public List<Integer> getNeighbours(int v){
            if (v < 0 || v >= V) throw new IndexOutOfBoundsException();
            return edges[v];
        }
        public int V() {
            return V;
        }

        /**
         * Returns the number of edges in the graph.
         * @return the number of edges in the graph
         */
        public int E() {
            return E;
        }
        public String toString() {
            StringBuilder s = new StringBuilder();
            String NEWLINE = System.getProperty("line.separator");
            s.append(V + " vertices, " + E + " edges " + NEWLINE);
            for (int v = 0; v < V; v++) {
                s.append(v + ": ");
                for (int w : edges[v]) {
                    s.append(w + " ");
                }
                s.append(NEWLINE);
            }
            return s.toString();
        }

        public void dfs(int source) {
            boolean[] visited = new boolean[V];
             dfsMe(source,visited);
        }

        private void dfsMe(int at,boolean[] visited) {
            if(visited[at]){
                return;
            }
            System.out.println("visiting vertix = "+ at);
            visited[at]= true;
            List<Integer> neighbours = getNeighbours(at);
            System.out.println(" neighbours =" + neighbours.toString());
            for(int n :neighbours){
                dfsMe(n,visited);
            }
        }

        public void bfs(int source) {
            boolean[] visited = new boolean[V];
            Queue<Integer> queue = new LinkedList<>();
            queue.add(source);
            while(!queue.isEmpty()){
                Integer v = queue.poll();
                if(visited[v]){
                    continue;
                }
                queue.addAll(getNeighbours(v));
                System.out.println("Visiting : "+ v);
                visited[v] = true;
            }
        }

        public void dfsWithStack(int source) {
            boolean[] visited = new boolean[V];
            Stack<Integer> stack = new Stack<>();
            stack.push(source);
            while(!stack.isEmpty()){
                Integer v = stack.pop();
                if(visited[v]){
                    continue;
                }
                stack.addAll(getNeighbours(v));
                System.out.println("Visiting : "+ v);
                visited[v] = true;
            }
        }
/*
use dfs over all the items and keep each dfs to count and colour that vertex.
 */
        public void findConnectedComponents() {
            int count =0;
            int[] component = new int[V];
            boolean[] visited = new boolean[V];
            for(int v =0; v< V; v++){
                if(!visited[v]){
                    count++;
                    dfs(v,count,component,visited);
                }
            }
            System.out.println("connected components are: "+ count);
            for(int i:component){
                System.out.println(" colours are : "+ i);
            }

        }

        private void dfs(int v, int count, int[] component,boolean[] visited) {
            if(visited[v]){
                return;
            }
            visited[v]= true;
            component[v] = count;
            List<Integer> neighbours = getNeighbours(v);
            for(int n:neighbours){
                dfs(n,count,component,visited);
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(12);
        graph.addEdge(0,1);
        graph.addEdge(0,9);
        graph.addEdge(1,8);
        graph.addEdge(9,8);
       // graph.addEdge(8,7);
        graph.addEdge(7,10);
        graph.addEdge(7,11);
        graph.addEdge(10,11);
        graph.addEdge(7,3);
        graph.addEdge(7,6);
        graph.addEdge(5,3);
        graph.addEdge(5,6);
        graph.addEdge(3,4);
        graph.addEdge(3,2);
        System.out.println(graph.E());
        graph.dfs(0);
        graph.bfs(0);
        System.out.println("dfs with stack ");
        graph.dfsWithStack(0);
        graph.findConnectedComponents();
    }
}
