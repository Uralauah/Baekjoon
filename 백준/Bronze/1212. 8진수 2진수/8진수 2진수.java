import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String num = br.readLine();
        int len = num.length();
        for (int i=0;i<len;i++){
            StringBuilder sb2 = new StringBuilder();
            int n = Integer.valueOf(num.charAt(i)-48);
            for (int j=0;j<3;j++){
                sb2.append(n%2);
                n/=2;
            }
            sb.append(sb2.reverse());
        }

        int del = sb.indexOf("1");
        if(del>0)
            sb.delete(0,del);
        else if (del==-1){
            sb.delete(0,sb.length()-1);
        }
        System.out.println(sb);
    }
}