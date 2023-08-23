import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long upper = Integer.parseInt(st.nextToken());
        long lower = Integer.parseInt(st.nextToken());

        long c_five = five(upper) - five(upper-lower) - five(lower);
        long c_two = two(upper) - two (upper-lower) - two(lower);
        if (c_five>=c_two)
            System.out.println(c_two);
        else
            System.out.println(c_five);
    }

    public static long five(long num){
        int count = 0;
        while(num>=5){
            count +=num/5;
            num/=5;
        }
        return count;
    }
    public static long two (long num){
        int count=0;
        while(num>=2){
            count+=num/2;
            num/=2;
        }
        return count;
    }
}