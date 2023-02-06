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
import java.util.Stack;
import java.util.StringTokenizer;


public class ConnectedComponents_DFS {

	public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        solve(1, in, out);
        out.close();
    }

    static void solve(int testCases, InputReader in, PrintWriter out){
        final int N = 6;
        final int type = 1; //undirected graph
        List<Node> nodes = Arrays.asList(new Node(3,5), new Node(5,2)
        		, new Node(2,0), new Node(4,1)
        		);
        
        Graph graph = new Graph(nodes, N, type);
        graph.printNodes();
        List<List<Integer>> connectedComponents = connectedComponents(graph);
        System.out.println("***** Connected Components *****");
        printConnectedComponents(connectedComponents);
    }
    
    static List<List<Integer>> connectedComponents(Graph graph){ //O(N)
    	ArrayList<Integer> components = new ArrayList<>(graph.n);
    	for (int i = 0; i < graph.n; i++) components.add(-1);
    	int curr_component = 0;
    	
    	for(int i = 0; i < graph.n; i++) {
    		if(components.get(i) == -1) {
    			dfs(graph, i, components, curr_component);
    			curr_component++;
    		}
    	}
    	//Sorting connected components
    	List<List<Integer>> connectedComponents = new ArrayList<>(curr_component);
    	for(int i = 0; i < curr_component; i++) connectedComponents.add(new ArrayList<>()); 
        for(int i = 0; i < components.size(); i++)
        	connectedComponents.get(components.get(i)).add(i);
        
        return connectedComponents;
    }
    
    static void dfs(Graph graph, int v, List<Integer> components, int curr_component) { //O(V + E)
        Stack<Integer> s = new Stack<>();
        s.push(v);
        components.set(v, curr_component);
        
        while(!s.isEmpty()){ //mientras haya nodos por procesar
            v = s.pop();
            for(int u : graph.adjlist.get(v)){ //para cada "u" vecino de "v"
                if(components.get(u) == -1){ //si "u" no fue colocado o visitado aun
                    s.push(u);
                    components.set(u, curr_component);
                }
            }
        }
    }
    
    static void printConnectedComponents(List<List<Integer>> connectedComponents) {
    	
    	for(int component = 0; component < connectedComponents.size(); component++) {
    		for(int node : connectedComponents.get(component)) {
    			System.out.println(node + " -> connected component " + component);
    		}
    	}
    	
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
