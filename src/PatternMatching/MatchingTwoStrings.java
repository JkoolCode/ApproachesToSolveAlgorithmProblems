package PatternMatching;
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
public class MatchingTwoStrings {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        solve(1, in, out);
        out.close();
    }

    static void solve(int testCases, InputReader in, PrintWriter out){
        String p = "abbc";
        String s = "cbabadcbbabbcbabaabccbabc";
        char[] pArr = p.toCharArray();
        char[] sArr = s.toCharArray();
        int pSum = 0, sum = 0, count = 0;
        for (int i = 0; i < pArr.length; i++) pSum += (int) pArr[i];
       
        for (int i = 0; i < sArr.length - 3; i++) {
            for (int j = i; j < pArr.length+i; j++) {
                sum += (int) sArr[j];
            }
            if(sum == pSum) count++;
            sum = 0;
        }
        
        out.println(count); 
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
