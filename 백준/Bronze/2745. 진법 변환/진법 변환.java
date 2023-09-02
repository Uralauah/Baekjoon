import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        String n=st.nextToken();
        int b=Integer.parseInt(st.nextToken());
        int a=1,result=0;

        for (int i=0;i<n.length();i++){
            int c = change(n.charAt(n.length()-1-i));
            result+=a*c;
            a*=b;
        }
        System.out.println(result);
    }

    static int change(char n){
        int num;
        if (n>=48&&n<=57)
            num=n-48;
        else
            num=n-55;
        return num;
    }
}
