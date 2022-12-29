package MaxSubArraySum;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author Junior Oblitas
 */
public class PrefixSum_base {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        solve(1, in, out);
        out.close();
    }

    static void solve(int testCases, InputReader in, PrintWriter out){
        int[] arr = {-1,2,4,-3,5,2,-5,2};
        final int N = arr.length;
        int[] prefixSum = new int[N+1];
        
        prefixSum[0] = 0;
        for (int i = 1; i < prefixSum.length; i++) prefixSum[i] = prefixSum[i - 1] + arr[i-1];
        
        //print arrays
        for(int x : arr)
        	out.print(x + " ");
        out.println();
        
        for(int x : prefixSum)
        	out.print(x + " ");
        out.println();
        
        //Making queries to get the sum from a to b in O(1)
        int a, b, subArraySum = 0;
        a = 0; 
        b = 2;
        subArraySum = prefixSum[b+1] - prefixSum[a];
        out.println(subArraySum);
        
        a = 2; 
        b = 5;
        subArraySum = prefixSum[b+1] - prefixSum[a];
        out.println(subArraySum);
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
