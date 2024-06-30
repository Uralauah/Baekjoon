import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int[] ans = new int[100001];
    public static int N, K;


    public static void find(int x) {
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        ans[x]=0;

        while(!q.isEmpty()){
            int cur = q.poll();
            int time = ans[cur];
            if(cur==K){
                continue;
            }
            if(cur+1<100001&&ans[cur+1]>time+1){
                q.add(cur+1);
                ans[cur+1]=time+1;
            }
            if(cur-1>=0&&ans[cur-1]>time+1){
                q.add(cur-1);
                ans[cur-1]=time+1;
            }
            if(cur*2<100001&&ans[cur*2]>time){
                q.add(cur*2);
                ans[cur*2]=time;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<100001;i++){
            ans[i]=Integer.MAX_VALUE;
        }
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        find(N);
        System.out.println(ans[K]);

    }
}