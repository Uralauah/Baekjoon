import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        String [] num=new String [4];
        String num1, num2;
        long result;
        for (int i=0;i<4;i++)
            num[i]=st.nextToken();
        num1=num[0]+num[1];
        num2=num[2]+num[3];
        result=Long.parseLong(num1)+Long.parseLong(num2);
        System.out.println(result);
    }
}
