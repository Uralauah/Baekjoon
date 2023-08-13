import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));


        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] input = new int [n];
        int [] list = new int[n];
        for (int i=0;i<n;i++)
            input[i]=Integer.parseInt(st.nextToken());

        int top=-1;
        for (int i=0;i<n;i++){
            while(top!=-1&&input[list[top]]<input[i]){
                input[list[top]]=input[i];
                top--;
            }
            top++;
            list[top]=i;
        }

        for (int i=top;i>=0;i--)
            input[list[i]]=-1;

        for (int i=0;i<n;i++){
            bw.write(input[i]+" ");
        }
        bw.flush();
        bw.close();
    }
}
