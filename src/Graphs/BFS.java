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
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
        final int N = 6;
        final int V = 3;
        initMatrix(matrix, N);
        ArrayList<Integer> result = bfs(matrix, V);
        
        //show all the distances from V to each neighbor node
        for (int i = 0; i < result.size(); i++) {
            out.println(result.get(i));
        }
        
    }
    
    static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> matrix, int v){
        ArrayList<Integer> d = new ArrayList<>(matrix.size());
        for (int i = 0; i < matrix.size(); i++) d.add(-1);
        int x ;
        Queue<Integer> q = new LinkedList<>();
        d.set(v, 0);
        q.offer(v);
        while(!q.isEmpty()){ //mientras haya nodos por procesar
            x = q.poll();
            for(int y : matrix.get(x)){ //para cada "y" vecino de "x"
                if(d.get(y) == -1){ //si "y" no fue colocado aun
                    d.set(y, (d.get(x) + 1));
                    q.offer(y);
                }
            }
        }
        return d;
    }
    
    static void initMatrix(ArrayList<ArrayList<Integer>> matrix, int N){
        for (int i = 0; i < N; i++) {
            matrix.add(new ArrayList<Integer>());    
        }
        
        matrix.get(0).add(1);
        matrix.get(1).add(0);
        
        matrix.get(0).add(2);
        matrix.get(2).add(0);
        
        matrix.get(2).add(4);
        matrix.get(4).add(2);
        
        matrix.get(4).add(3);
        matrix.get(3).add(4);
        
        matrix.get(3).add(5);
        matrix.get(5).add(3);
        
        //Look distribution
        /*for (int i = 0; i < N; i++) {
            ArrayList<Integer> vector = matrix.get(i);
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
