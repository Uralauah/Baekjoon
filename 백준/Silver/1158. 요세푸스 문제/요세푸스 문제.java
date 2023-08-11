import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
        List <Integer> list = new LinkedList<>();
        List <Integer> output = new LinkedList<>();

        String text = br.readLine();
        String[] num = text.split(" ");
        int n,k;
        n=Integer.parseInt(num[0]);
        k=Integer.parseInt(num[1]);

        for (int i=1;i<=n;i++)
            list.add(i);
        int sum=list.size();
        for (int i=0;i<n;i++){
            for (int j=0;j<k;j++){
                if(sum>=list.size()-1){
                    sum=0;
                }
                else
                    sum++;
            }
            output.add(list.get(sum));
            list.remove(sum);
            sum--;
        }
        System.out.print('<');
        for (int i=0;i<n;i++){
            System.out.print(output.get(i));
            if (i!=n-1)
                System.out.print(", ");
        }
        System.out.println('>');
    }
}
