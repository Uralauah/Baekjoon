import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        List <String> list = new ArrayList<>();

        String text = br.readLine();
        for (int i=0;i<text.length();i++){
            list.add(text.substring(i));
        }
        list.sort(Comparator.naturalOrder());
        for (int i=0;i<list.size();i++)
            sb.append(list.get(i)).append('\n');
        System.out.println(sb);
    }
}