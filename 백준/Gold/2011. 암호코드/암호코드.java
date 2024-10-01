import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int n = input.length();
        input = '9' + input;
        int[] dp = new int[input.length() + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
//            System.out.println(input.charAt(i));
            if (input.charAt(i) == '0' && (input.charAt(i - 1) != '1' && input.charAt(i - 1) != '2')) {
                dp[n] = 0;
                break;
            } else if (input.charAt(i) == '0' && (input.charAt(i - 1) == '1' || input.charAt(i - 1) == '2')) {
                dp[i] = dp[i - 2] % 1000000;
                dp[i-1] = dp[i];
            } else if (input.charAt(i - 1) == '1') {
                dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000;
            } else if (input.charAt(i - 1) == '2') {
                if (input.charAt(i) <= '6') {
                    dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000;
                } else {
                    dp[i] = dp[i - 1] % 1000000;
                }
            } else {
                dp[i] = dp[i - 1] % 1000000;
            }
        }

//        for (int i = 0; i <= n; i++) {
//            System.out.printf(dp[i] + " ");
//        }
//        System.out.println();

        System.out.println(dp[n]);
    }
}