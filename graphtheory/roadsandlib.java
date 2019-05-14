import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

 class Solution {
    static int nodes;

    // Complete the roadsAndLibraries function below.
    static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {
          long cost_by_road=0;
          long cost_by_lib=0;
          int orignal=0;
          ArrayList<ArrayList<Integer>> li=new ArrayList<ArrayList<Integer>>();
          for(int i=0;i<=n;i++){
          ArrayList s=new ArrayList<Integer>();
          li.add(s);
          }
          
          for(int i=0;i<cities.length;i++){
          li.get(cities[i][0]).add(cities[i][1]);
          li.get(cities[i][1]).add(cities[i][0]);
          }
          int noc=0;
      boolean visited[]=new boolean[n+1];
      long total=0;
      for(int i=1;i<=n;i++){
      if(visited[i]!=true){
          visited[i]=true;
          nodes=1;
     noc= bfs(i,visited,li);
    
     cost_by_lib= (long)noc*c_lib;
     
     cost_by_road=(long)(noc-1)*c_road+c_lib;
     
     if(cost_by_lib<cost_by_road)
     total=total+cost_by_lib;
     else
     total=total+cost_by_road;
      
      }
      
      }

     return total;
        


    }
    static int bfs(int u,boolean visited[],ArrayList<ArrayList<Integer>>li)
    {

       // visited[u]=true;
        for(int p:li.get(u))
        {
            if(visited[p]!=true)
            {
                nodes++;
                visited[p]=true;
                bfs(p,visited,li);
            }
        }
        return nodes;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nmC_libC_road = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nmC_libC_road[0]);

            int m = Integer.parseInt(nmC_libC_road[1]);

            int c_lib = Integer.parseInt(nmC_libC_road[2]);

            int c_road = Integer.parseInt(nmC_libC_road[3]);

            int[][] cities = new int[m][2];

            for (int i = 0; i < m; i++) {
                String[] citiesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2; j++) {
                    int citiesItem = Integer.parseInt(citiesRowItems[j]);
                    cities[i][j] = citiesItem;
                }
            }

            long result = roadsAndLibraries(n, c_lib, c_road, cities);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
