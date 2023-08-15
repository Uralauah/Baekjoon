import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] num = new int [3];
        for (int i=0;i<3;i++){
            num[i]=Integer.parseInt(st.nextToken());
        }
        System.out.println((num[0]+num[1])%num[2]);
        System.out.println(((num[0]%num[2])+(num[1]%num[2]))%num[2]);
        System.out.println((num[0]*num[1])%num[2]);
        System.out.println(((num[0]%num[2])*(num[1]%num[2]))%num[2]);
    }
}