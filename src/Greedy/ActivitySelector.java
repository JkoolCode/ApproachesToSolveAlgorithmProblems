package Greedy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author Junior Oblitas
 * Activity selector problem
 */
public class ActivitySelector {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        solve(1, in, out);
        out.close();
    }

    static void solve(int testCases, InputReader in, PrintWriter out){
        /*Test 1*/
        /*final int N = 7;
        int[] s = {1,3,0,5,3,5,6};
        int[] f = {4,5,6,7,8,9,10};*/
        /*Test 2*/
        final int N = 8;
        int[] s = {1,2,4,4,5,6,7,9};
        int[] f = {7,5,6,9,8,10,11,12};
        /*Test 3*/
        /*final int N = 11;
        int[] s = {1,3,0,5,3,5,6,8,8,2,12};
        int[] f = {4,5,6,7,8,9,10,11,12,13,14};*/
        List<Integer> ans = new ArrayList<>();
        showData(s, f, N, out);
        greedyAlgorithm(s, f, ans ,N, out);
    }
    
    static void makeSort(int[] s, int[] f, final int N, PrintWriter out){
        int aux1, aux2, flag = 1 ;
        for (int i = N-1; i > 0 && flag == 1; i--) { //Bubble sort, O(N^2)
            flag = 0;
            for (int j = 0; j < i; j++) {
                if(f[j] > f[j+1]){
                    aux1 = f[j];
                    f[j] = f[j+1];
                    f[j+1] = aux1;
                    
                    aux2 = s[j];
                    s[j] = s[j+1];
                    s[j+1] = aux2;
                    
                    flag = 1;
                }
            }
        }
        
        showData(s, f, N, out);
    }
    
    static void greedyAlgorithm(int[] s, int[] f, List<Integer> ans, final int N, PrintWriter out){
        makeSort(s, f, N, out);
        int z;
        ans.add(0);
        z = 0; //Last selected activity
       
        for (int i = 1; i < N; i++) {
            if(s[i] >= f[z]){
                ans.add(i); //selected activity
                z = i; 
            }
        }
        
        printActivities(ans, N, out);
    }
    
    static void printActivities(List<Integer> ans, final int N, PrintWriter out){
        for(int item : ans) 
            out.print("A"+(item + 1)+" ");
        out.println();
    }
    
    static void showData(int[] s, int[] f, final int N, PrintWriter out){
        for (int i = 1; i <= N; i++) out.print("A"+i + "\t");
        out.println("");
        for (int i = 0; i < N; i++) out.print(s[i] + "\t");
        out.println("");
        for (int i = 0; i < N; i++) out.print(f[i] + "\t");
        out.println("\n");
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
