import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int G,P,max=0;
    public static int[] input,parent;

    public static int find(int idx){
        if(parent[idx] == idx)
            return idx;
        else {
            parent[idx] = find(parent[idx]);
            return parent[idx];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        G = Integer.parseInt(br.readLine());
        P = Integer.parseInt(br.readLine());
        input = new int[P+1];
        parent = new int[G+1];
        for(int i=0;i<P;i++){
            input[i] = Integer.parseInt(br.readLine());
        }
        for(int i=0;i<=G;i++){
            parent[i] = i;
        }
        for(int i=0;i<P;i++){
            int val = find(input[i]);
            
            if(val==0){
                break;
            }
            parent[val] = val-1;
            max++;
        }
        System.out.println(max);
    }
}
