import java.util.LinkedList;
import java.util.List;

public class DirectedGraphs {
    public static void main(String[] args) {
 DirectedGraph directedGraph = new DirectedGraph(6);
        directedGraph.addEdge(0,1);
        directedGraph.addEdge(0,2);
        directedGraph.addEdge(1,3);
        directedGraph.addEdge(2,3);
        directedGraph.addEdge(3,4);
        directedGraph.addEdge(5,0);
  int order[] =directedGraph.topological();
        for (int i = 0; i <order.length ; i++) {
            System.out.println(" "+order[i]);
        }
    }
    public  static class DirectedGraph{
        int V;
        int E;
        List<Integer> adj[];
        public DirectedGraph(int vertices){
            this.V= vertices;
            adj = new LinkedList[V];
            for(int v=0;v<V; v++){
                adj[v] = new LinkedList<>();
            }
        }
        public void addEdge(int from, int to){
            if(from >=V || from<0|| to >=V|| to <0){
                throw new IllegalArgumentException("invalid vertex indices.");
            }
            E++;
            adj[from].add(to);
        }
        public int E(){
            return this.E;
        }
        public int V(){
            return this.V;
        }
        public List<Integer> getNeighbours(int v){
            if(v >=V|| v <0){
                throw new IllegalArgumentException("invalid vertex indices.");
            }
            return adj[v];
        }
        public String toString() {
            StringBuilder s = new StringBuilder();
            String NEWLINE = System.getProperty("line.separator");
            s.append(V + " vertices, " + E + " edges " + NEWLINE);
            for (int v = 0; v < V; v++) {
                s.append(v + ": ");
                for (int w : adj[v]) {
                    s.append(w + " ");
                }
                s.append(NEWLINE);
            }
            return s.toString();
        }

        public int[] topological() {
            int order[] = new int[V];
            boolean visited[]= new boolean[V];
            int i= V-1;
            for(int v=0;v<V;v++){
                if(!visited[v]){
                    i=dfs(i,v, visited,order);
                }
            }
            return order;
        }

        private int dfs(int i, int v, boolean[] visited, int[] order) {
            visited[v] = true;
            List<Integer> edges = getNeighbours(v);
            for(int j=0; j<edges.size();j++){
                if(!visited[edges.get(j)])
                i=dfs(i,edges.get(j),visited,order);
            }
            order[i] = v;
            return i-1;
        }
    }
}
