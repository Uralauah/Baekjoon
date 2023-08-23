import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());
        BigInteger n = BigInteger.valueOf(1);
        int num=0;
        for (int i=1;i<=input;i++){
            n=n.multiply(BigInteger.valueOf(i));
        }
        BigInteger a = BigInteger.valueOf(0);
        while(true){
            if (a.compareTo(n.mod(BigInteger.valueOf(10)))!=0||a.compareTo(n)==0)
                break;
            else{
                n=n.divide(BigInteger.valueOf(10));
                num++;
            }
        }
        System.out.println(num);
    }
}