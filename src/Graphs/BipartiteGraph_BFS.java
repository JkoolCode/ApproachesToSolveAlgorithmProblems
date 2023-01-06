package Graphs;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class BipartiteGraph_BFS {

	public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        solve(1, in, out);
        out.close();
    }

    static void solve(int testCases, InputReader in, PrintWriter out){
        final int N = 9;
        final int V = 0;
        final int type = 1; //undirected graph
        List<Node> nodes = Arrays.asList(new Node(0,1), new Node(1,2), new Node(1,7)
        		, new Node(2,3), new Node(3,5), new Node(4,6), new Node(4,8), new Node(7,8)
        		//, new Node(1,3) //non-bipartite input
        		);
        
        Graph graph = new Graph(nodes, N, type);
        graph.printNodes();
        boolean isBipartite = isBipartite(graph, V);
        System.out.println(isBipartite ? "Graph is bipartite" : "Graph is not bipartite");
    }
    
    static boolean isBipartite(Graph graph, int v){ //O(m)
        ArrayList<Integer> d = new ArrayList<>(graph.n);
        for (int i = 0; i < graph.n; i++) d.add(-1);
        //int x ;
        Queue<Integer> q = new LinkedList<>();
        d.set(v, 0);
        q.offer(v);
        while(!q.isEmpty()){ //mientras haya nodos por procesar
            v = q.poll();
            for(int u : graph.adjlist.get(v)){ //para cada "u" vecino de "v"
                if(d.get(u) == -1){ //si "u" no fue colocado o visitado aun
                    d.set(u, (d.get(v) + 1));
                    q.offer(u);
                }else {
                	if(d.get(u) == d.get(v)) return false;
                }
            }
        }
        return true;
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;
 
        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }
 
        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }
 
        public int nextInt() {
            return Integer.parseInt(next());
        }
 
        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
