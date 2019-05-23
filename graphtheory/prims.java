import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the prims function below.
    static int prims(int n, int[][] edges, int start) {
             ArrayList<ArrayList<Integer>> al=new ArrayList<ArrayList<Integer>>();
             int w[][]=new int[n+1][n+1];
             int c[]=new int[n+1];
             boolean visited[]=new boolean[n+1];
             int intmax=(int)(1e9+7);
             for(int i=0;i<=n;i++){
                 ArrayList<Integer> sl=new ArrayList<Integer>();
             al.add(sl);
             c[i]=intmax;
             }
             for(int i=0;i<edges.length;i++)
             {
                 al.get(edges[i][0]).add(edges[i][1]);
                 al.get(edges[i][1]).add(edges[i][0]);
                 w[edges[i][0]][edges[i][1]]=edges[i][2];
                  w[edges[i][1]][edges[i][0]]=edges[i][2];

             }
             //visited[start]=true;
             c[start]=0;
           for(int i=0;i<=n;i++)
           {
                int source=findmin(c,visited);
                visited[source]=true;
                for(Integer v: al.get(source))
                {
                    if(visited[v]==false){
                    if(c[v]>w[source][v])
                    c[v]=w[source][v];
                    }
                    
                }
           }
           System.out.println(w[1][2]);
           int ans=0;
           for(int i=1;i<=n;i++){
           ans=ans+c[i];
           System.out.println(c[i]);
           }
           return ans;
           

           }
        static int findmin(int c[],boolean visited[])
        {
            int min=(int)1e9+7;int index=0;
            for(int i=1;i<c.length;i++)
            {
                if(c[i]<min && (visited[i]!=true)){
                index=i;
                min=c[i];
                }
            }
            return index;
        }
             



    

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] edges = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] edgesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int edgesItem = Integer.parseInt(edgesRowItems[j]);
                edges[i][j] = edgesItem;
            }
        }

        int start = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int result = prims(n, edges, start);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
