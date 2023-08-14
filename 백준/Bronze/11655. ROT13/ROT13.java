import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();
        for (int i=0;i<input.length();i++){
            char n = (char)(input.charAt(i));
            if(n>='a'&&n<='z'){
                if (n+13>'z')
                    n-=13;
                else
                    n+=13;
            }
            if(n>='A'&&n<='Z')
                if(n+13>'Z')
                    n-=13;
                else
                    n+=13;
            sb.append(n);
        }
        System.out.println(sb);
    }
}
