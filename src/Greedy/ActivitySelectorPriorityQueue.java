package Greedy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @author Junior Oblitas
 * Activity selector problem
 */
public class ActivitySelectorPriorityQueue {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        solve(1, in, out);
        out.close();
    }

    static void solve(int testCases, InputReader in, PrintWriter out){
        PriorityQueue<Pair<Integer, Integer>> minHeap = new PriorityQueue<>();
        minHeap.offer(new Pair(1, 7));
        minHeap.offer(new Pair(2, 5));
        minHeap.offer(new Pair(4, 6));
        minHeap.offer(new Pair(4, 9));
        minHeap.offer(new Pair(5, 8));
        minHeap.offer(new Pair(6, 10));
        minHeap.offer(new Pair(7, 11));
        minHeap.offer(new Pair(9, 12));     
        greedyAlgorithm(minHeap, out);
    }
    
    static void greedyAlgorithm(PriorityQueue<Pair<Integer, Integer>> minHeap, PrintWriter out){
        List<Pair<Integer, Integer>> ans = new ArrayList<>();
        ans.add(minHeap.peek()); //The first position is always the first optimal activity.
        
        Pair<Integer, Integer> p1 = minHeap.poll();
        Pair<Integer, Integer> p2;
        
        while(!minHeap.isEmpty()){
            p2 = minHeap.poll();
            if(p2.start >= p1.finish){
                ans.add(p2);
                p1 = p2;
            }
        }
        
        out.println("Total: "+ans.size());
        for(Pair<Integer, Integer> pair : ans){
            out.println(pair);    
        }
    }
    
    static class Pair<Item extends Number, Item2 extends Number> implements Comparable<Pair>{
        private Item start;
        private Item2 finish;
        public Pair(Item start, Item2 finish){
            this.start = start;
            this.finish = finish;
        }

        @Override
        public int compareTo(Pair o) {
            /*int rs = 0;
            if(this.finish.intValue() > o.finish.intValue()) rs = 1;
            else rs = -1;
            return rs;*/
            return (this.finish.intValue() - o.finish.intValue());
        }
        
        @Override
        public String toString() {
            return "Pair{" + "start=" + start + ", finish=" + finish + '}';
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
