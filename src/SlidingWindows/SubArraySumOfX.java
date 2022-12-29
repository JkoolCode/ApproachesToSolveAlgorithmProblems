package SlidingWindows;
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
public class SubArraySumOfX {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        solve(1, in, out);
        out.close();
    }

    static void solve(int testCases, InputReader in, PrintWriter out){
        int[] arr = {2,3,2,5,1,5,2,3};
        int x = 8;
        int j = 0, sum = 0;
        final int N = arr.length;
        int iR = -1, jR = -1;
        
        //Sliding windows o two pointer technique
        for (int i = 0; i < N; i++) { //O(n)
        	//Into the window up to get the right sum or overcome the sum from i
            while(j < N && sum < x){
                sum += arr[j];
                j++;
            }
            
            if(sum == x){
                iR = i;
                jR = j - 1;
                break;
            }
            sum -= arr[i]; //remove the most left value
        }
        
        if(iR != -1 && jR != -1)
            out.println("[" + iR + " , " + jR + "]");
        else out.println("No existe");
            
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
