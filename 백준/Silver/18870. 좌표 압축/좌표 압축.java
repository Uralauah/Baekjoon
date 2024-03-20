

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
        ArrayList<Integer> temp = new ArrayList<>(n);
        ArrayList<Integer> input = new ArrayList<>(n);
        HashMap<Integer,Integer> ans = new HashMap<>();
        while(st.hasMoreTokens()){
            int tmp = Integer.parseInt(st.nextToken());
            input.add(tmp);
            temp.add(tmp);
        }
        Collections.sort(input);
        int cnt=0;
        for(int i=0;i<input.size();i++){
            if(!ans.containsKey(input.get(i))){
                ans.put(input.get(i),cnt++);
            }
        }

        for(int i=0;i<n;i++){
            sb.append(ans.get(temp.get(i))+" ");
        }
        System.out.println(sb);


    }
}
