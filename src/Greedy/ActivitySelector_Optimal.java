package Greedy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author Junior Oblitas
 * Activity selector problem
 */
public class ActivitySelector_Optimal {

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
        /*//N = 7;
        int[] s = {1,3,0,5,3,5,6};
        int[] f = {4,5,6,7,8,9,10};*/
        /*Test 2*/
        //N = 8;
        int[] s = {1,2,4,4,5,6,7,9};
        int[] f = {7,5,6,9,8,10,11,12};
        /*Test 3*/
        /*//N = 11;
        int[] s = {1,3,0,5,3,5,6,8,8,2,12};
        int[] f = {4,5,6,7,8,9,10,11,12,13,14};*/
        
        List<Pair<Integer>> activities = new ArrayList<>();
        for(int i = 0; i < s.length; i++)
        	activities.add(new Pair(s[i], f[i]));
        List<Integer> ans = new ArrayList<>();
        
        showData(activities, out);
        greedyAlgorithm(activities, ans, out);
    }
     
    static void makeSort(List<Pair<Integer>> activities, PrintWriter out){
        Collections.sort(activities, (a, b) -> a.finish - b.finish); //O(n*lg(n))
        showData(activities, out);
    }
    
    static class Pair<T>{
        T start;
        T finish;
        Pair(T start, T finish){
        	this.start = start;
        	this.finish = finish;
        }
    }
    
    static void greedyAlgorithm(List<Pair<Integer>> activities, List<Integer> ans, PrintWriter out){
    	makeSort(activities, out); //O(n*lg(n))
        int z;
        ans.add(0);
        z = 0; //Last selected activity
       
        for (int i = 1; i < activities.size(); i++) { //O(n)
            if(activities.get(i).start >= activities.get(z).finish){
                ans.add(i); //selected activity
                z = i; 
            }
        }
        
        printActivities(ans, out);
    }
    
    static void printActivities(List<Integer> ans, PrintWriter out){
        for(int item : ans) 
            out.print("A"+(item + 1)+" ");
        out.println();
    }
    
    static void showData(List<Pair<Integer>> activities, PrintWriter out){
        for (int i = 1; i <= activities.size(); i++) out.print("A"+i + "\t");
        out.println("");
        for (int i = 0; i < activities.size(); i++) out.print(activities.get(i).start + "\t");
        out.println("");
        for (int i = 0; i < activities.size(); i++) out.print(activities.get(i).finish + "\t");
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
