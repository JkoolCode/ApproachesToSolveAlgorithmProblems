package Graphs;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @author Junior Oblitas
 */
public class DFS {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        solve(1, in, out);
        out.close();
    }

    static void solve(int testCases, InputReader in, PrintWriter out){
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        final int N = 8;
        final int node = 0; //initial node, you could initialize from any node
        initGraph(graph, N);
        boolean[] checked = new boolean[graph.size()]; //elements are false by default
        System.out.println("Showing the travel in DFS fashion");
        dfs(graph, node, checked); //show the travel in dfs fashion
    }
    
    static void dfs(ArrayList<ArrayList<Integer>> graph, int node, boolean[] checked){ //O(V + E)
        Stack<Integer> s = new Stack<>();
        s.push(node);
        while(!s.empty()) {
        	int x = s.pop();
        	System.out.println(x); //the travel in dfs fashion
        	checked[x] = true;
        	for(int y : graph.get(x)) { // for each 'y' neighbor of 'x'
        		if(!checked[y]) { // if 'y' didn't go visited 
        			s.push(y);
        		}
        	}
        }
    }
    
    static void initGraph(ArrayList<ArrayList<Integer>> graph, int N){
        for (int i = 0; i < N; i++) {
        	graph.add(new ArrayList<Integer>());    
        }
        //Undirected graph
        graph.get(0).add(1);
        graph.get(1).add(0);
        
        graph.get(0).add(2);
        graph.get(2).add(0);
        
        graph.get(0).add(3);
        graph.get(3).add(0);
        
        graph.get(1).add(4);
        graph.get(4).add(1);
        
        graph.get(1).add(5);
        graph.get(5).add(1);
        
        graph.get(5).add(7);
        graph.get(7).add(5);
        
        graph.get(3).add(6);
        graph.get(6).add(3);    
        
        //Look distribution
        for (int i = 0; i < N; i++) {
            ArrayList<Integer> vector = graph.get(i);
            System.out.print("Node " + i + " -> ");
            for (int j = 0; j < vector.size(); j++) {
                System.out.print(vector.get(j) + " ");
            }
            System.out.println("");
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
