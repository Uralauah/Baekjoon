import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        Stack <Character> stack = new Stack<>();

        String stick = br.readLine();
        int result = 0;
        for (int i=0;i<stick.length();i++){
            if (stick.charAt(i) == ')') {
                if (stick.charAt(i-1)=='('){
                    stack.pop();
                    result+=stack.size();
                }
                else {
                    stack.pop();
                    result++;
                }
            }
            else
                stack.push(stick.charAt(i));
        }
        System.out.println(result);
    }
}