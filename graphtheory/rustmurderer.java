import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the rustMurdered function below.
     */
    static int[] rustMurderer(int n, int[][] roads,int start) {
        int res[]=new int[n+1];
        ArrayList<ArrayList<Integer>> li=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<=n;i++)
        {
             ArrayList<Integer>sl=new ArrayList<Integer>();
             li.add(sl);
             
        }
        for(int i=1;i<=n;i++)
        {
            for(int j=i+1;j<=n;j++)
            {
                li.get(i).add(j);
                li.get(j).add(i);
            }
        }
        for(int i=0;i<roads.length;i++){
         li.get(roads[i][0]).remove((Integer)roads[i][1]);
         li.get(roads[i][1]).remove((Integer)roads[i][0]);
        }
        //System.out.println(li);
        boolean visited[]=new boolean[n+1];
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        q.add(null);
        visited[start]=true;
        int count=1;
        int j=0;
        while(q.size()!=0)
        {
            Integer source=q.poll();
            if(source!=null)
            {
                for(Integer i: li.get(source))
                {
                    if(visited[i]==false)
                    {
                        visited[i]=true;
                        res[i]=count;
                        q.add(i);
                    }
                }
            }
            else
            {
                if(q.size()!=0)
                {
                    count=count+1;
                    q.add(null);
                }
            }
        }

        int r[]=new int[n-1];
         j=0;
        for(int i=0;i<res.length;i++)
        {
            if(res[i]!=0)
            {
                r[j++]=res[i];
            }
        
        }
        return r;

        
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(scanner.nextLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0].trim());

            int m = Integer.parseInt(nm[1].trim());

            int[][] roads = new int[m][2];

            for (int roadsRowItr = 0; roadsRowItr < m; roadsRowItr++) {
                String[] roadsRowItems = scanner.nextLine().split(" ");

                for (int roadsColumnItr = 0; roadsColumnItr < 2; roadsColumnItr++) {
                    int roadsItem = Integer.parseInt(roadsRowItems[roadsColumnItr].trim());
                    roads[roadsRowItr][roadsColumnItr] = roadsItem;
                }
            }

            int s = Integer.parseInt(scanner.nextLine().trim());

            int[] result = rustMurderer(n, roads,s);

            for (int resultItr = 0; resultItr < result.length; resultItr++) {
                bufferedWriter.write(String.valueOf(result[resultItr]));

                if (resultItr != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedWriter.close();
    }
}
