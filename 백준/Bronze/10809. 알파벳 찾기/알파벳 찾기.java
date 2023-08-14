import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Map <Character,Integer> map = new HashMap<>();

        for (int i=0;i<26;i++){
            map.put((char)('a'+i),-1);
        }

        String text = br.readLine();
        for (int i=0;i<text.length();i++){
            if(map.get(text.charAt(i))==-1)
                map.replace(text.charAt(i),i);
        }

        for (int i=0;i<26;i++){
            sb.append(map.get((char)('a'+i))).append(' ');
        }
        System.out.println(sb);
    }
}
