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
import java.util.StringTokenizer;

/**
 * @author Junior Oblitas
 */
public class BFS {

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
        final int N = 6;
        final int V = 3;
        initGraph(graph, N);
        ArrayList<Integer> distances = bfs(graph, V);
        
        //show all the distances from V to each neighbor node
        for (int i = 0; i < distances.size(); i++) {
            out.println(distances.get(i));
        }
        
    }
    
    static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> graph, int v){ //O(m)
        ArrayList<Integer> d = new ArrayList<>(graph.size());
        for (int i = 0; i < graph.size(); i++) d.add(-1);
        int x ;
        Queue<Integer> q = new LinkedList<>();
        d.set(v, 0);
        q.offer(v);
        while(!q.isEmpty()){ //mientras haya nodos por procesar
            x = q.poll();
            for(int y : graph.get(x)){ //para cada "y" vecino de "x"
                if(d.get(y) == -1){ //si "y" no fue colocado aun
                    d.set(y, (d.get(x) + 1));
                    q.offer(y);
                }
            }
        }
        return d;
    }
    
    static void initGraph(ArrayList<ArrayList<Integer>> graph, int N){
        for (int i = 0; i < N; i++) {
        	graph.add(new ArrayList<Integer>());    
        }
        
        graph.get(0).add(1);
        graph.get(1).add(0);
        
        graph.get(0).add(2);
        graph.get(2).add(0);
        
        graph.get(2).add(4);
        graph.get(4).add(2);
        
        graph.get(4).add(3);
        graph.get(3).add(4);
        
        graph.get(3).add(5);
        graph.get(5).add(3);
        
        //Look distribution
        /*for (int i = 0; i < N; i++) {
            ArrayList<Integer> vector = graph.get(i);
            for (int j = 0; j < vector.size(); j++) {
                System.out.print(vector.get(j) + " ");
            }
            System.out.println("");
        }*/
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
