package BinarySearch;
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
public class BinarySearchByHand {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        solve(1, in, out);
        out.close();
    }

    static void solve(int testCases, InputReader in, PrintWriter out){
        int x = 3;
        int[] arr = {2,3,4,8,9,11,25};
        int index = binarySearch(arr, x);
        
        if(index == -1) out.println("No existe en numero " + x + " dentro del arreglo");
        else out.println("Existe en numero " + x + " dentro del arreglo");
    }
    
    static int binarySearch(int[] arr, int target){
        int a = -1, b = arr.length;
        int mid = 0;
        while(b - a > 1){
            mid = (a + b) / 2;
            if(arr[mid] < target)
                a = mid;
            else
                b = mid;
        }
        if(b < arr.length && arr[b] == target)
            return b;
        return -1;
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
