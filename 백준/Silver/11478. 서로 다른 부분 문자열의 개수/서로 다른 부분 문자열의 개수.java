import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        HashSet<String> hs = new HashSet<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine(),temp;

        for(int i=0;i<input.length();i++){
            for(int j=i+1;j<=input.length();j++){
                temp = input.substring(i,j);
                hs.add(temp);
            }
        }

        System.out.println(hs.size());
    }

}

