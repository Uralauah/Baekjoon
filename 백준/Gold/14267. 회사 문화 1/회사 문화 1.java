import java.util.*;
import java.io.*;

public class Main{

    public static ArrayList<Integer>[] arr;
    public static int[] compl;

    public static void dfs(int p){

        for(int i=0;i<arr[p].size();i++){
            int a = arr[p].get(i);

            compl[a] += compl[p];
            dfs(a);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new ArrayList[n];

        for(int i=0;i<n;i++){
            arr[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            int boss = Integer.parseInt(st.nextToken())-1;

            if(boss >= 0){
                arr[boss].add(i);
            }
        }

        compl = new int[n];

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken());

            compl[a] += b;
        }

        dfs(0);

        for(int i=0;i<n;i++){
            System.out.print(compl[i]+" ");
        }

    }
}