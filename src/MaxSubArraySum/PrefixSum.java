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
public class PrefixSum {

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
        int[] prefixSum = new int[N];
        
        prefixSum[0] = arr[0];
        for (int i = 1; i < N; i++) prefixSum[i] = prefixSum[i - 1] + arr[i];
        
        int minValue = 0;
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            maxValue = Math.max(maxValue, prefixSum[i] - minValue);
            minValue = Math.min(minValue, prefixSum[i]);
        }
        out.println(maxValue);
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
