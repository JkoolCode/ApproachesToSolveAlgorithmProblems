package SlidingWindows;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @author Junior Oblitas
 */
public class SumOfTwoElements {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        solve(1, in, out);
        out.close();
    }

    static void solve(int testCases, InputReader in, PrintWriter out){
        int x = 12;
        int[] arr = {7,10,4,1,9,5,9,6};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) map.put(arr[i], i);    
        
        Pair<Integer> pair = new Pair();
        boolean result = exists(arr, pair, x);
        
        if(result){ 
            out.println("Existe");
            int index1 = map.get(pair.x);
            int index2 = map.get(pair.y);
            out.println(index1 + ", " + index2);
        } else{ 
            out.println("No existe");
        }
    }
    
    static boolean exists(int[] arr, Pair<Integer> pair, int target){
        Arrays.sort(arr);
        int i = 0, j = arr.length - 1;
        int sum = 0;
        
        while(i < j){
            sum = arr[j] + arr[i];
            if(sum == target) {
                pair.x = arr[i];
                pair.y = arr[j];
                return true;
            }
            if(sum < target) i++;
            else j--;
        }
        return false;
    }
    
    static class Pair<T>{
        T x;
        T y;
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
