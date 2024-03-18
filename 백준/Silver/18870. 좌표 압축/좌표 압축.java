
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<Integer> hs = new HashSet<>(n);
        ArrayList<Integer> input = new ArrayList<>(n);
        HashMap<Integer,Integer> ans = new HashMap<>();
        while(st.hasMoreTokens()){
            int tmp = Integer.parseInt(st.nextToken());
            hs.add(tmp);
            input.add(tmp);
        }
        ArrayList<Integer> temp = new ArrayList<>(hs);
        Collections.sort(temp);
        for(int i=0;i<temp.size();i++){
            ans.put(temp.get(i),i);
        }

        for(int i=0;i<input.size();i++){
            sb.append(ans.get(input.get(i))+" ");
        }
        System.out.println(sb);


    }
}
