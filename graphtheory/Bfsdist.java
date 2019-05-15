import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

 class Solution {

    // Complete the bfs function below.
    static int[] bfs(int n, int m, int[][] edges, int s) {
     ArrayList<ArrayList<Integer>> li=new ArrayList<ArrayList<Integer>>();
     for(int i=0;i<=n;i++)
     {
         ArrayList<Integer> v=new ArrayList<Integer>();
         li.add(v);

     }
     for(int i=0;i<edges.length;i++)
     {
         li.get(edges[i][0]).add(edges[i][1]);
         li.get(edges[i][1]).add(edges[i][0]);

     }
     int arr[]=new int[n+1];
     Queue<Integer> q = new LinkedList<>(); 
     q.add(s);
     q.add(null);
     boolean visited[]=new boolean[n+1];
     int c=6;
     while(q.size()!=0)
     {
         Integer source=q.remove();
        // System.out.println(source);
         if(!(source==null)){
         for(int t:li.get(source))
         {
            if(visited[t]==false){
           visited[t]=true;
           arr[t]=c;
           q.add(t);
            }
         }
         }
         else{
             if(q.size()!=0){
         c=c+6;
         q.add(null);
             }
         }
     }
     
     int res[]=new int[n-1];
     int j=0;
     for(int i=1;i<=n;i++)
     {
         if(i!=s)
         {
             if(visited[i]==true)
             res[j++]=arr[i];
             else
             res[j++]=-1;
         }
     }
     return res;
     
     

     


    }
    

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0]);

            int m = Integer.parseInt(nm[1]);

            int[][] edges = new int[m][2];

            for (int i = 0; i < m; i++) {
                String[] edgesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2; j++) {
                    int edgesItem = Integer.parseInt(edgesRowItems[j]);
                    edges[i][j] = edgesItem;
                }
            }

            int s = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] result = bfs(n, m, edges, s);

            for (int i = 0; i < result.length; i++) {
                bufferedWriter.write(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
