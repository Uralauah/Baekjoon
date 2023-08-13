import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.HashMap;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        Stack <Double> stack = new Stack<>();
        Map<Character,Double> map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());

        String text = br.readLine();
        for (int i=0;i<n;i++){
            double num = Integer.parseInt(br.readLine());
            map.put((char)(65+i),num);
        }

        for (int i=0;i<text.length();i++){
            if (text.charAt(i)>=(char)65&&text.charAt(i)<=(char)90)
                stack.push(map.get(text.charAt(i)));
            else{
                double num1, num2, num3;
                switch (text.charAt(i)){
                    case '+':
                        num1 = stack.pop();
                        num2 = stack.pop();
                        num3=num1+num2;
                        stack.push(num3);
                        break;
                    case '*':
                        num1 = stack.pop();
                        num2 = stack.pop();
                        num3=num1*num2;
                        stack.push(num3);
                        break;
                    case '/':
                        num1 = stack.pop();
                        num2 = stack.pop();
                        num3=num2/num1;
                        stack.push(num3);
                        break;
                    case '-':
                        num1 = stack.pop();
                        num2 = stack.pop();
                        num3=num2-num1;
                        stack.push(num3);
                        break;
                }
            }
        }
        String result = String.format("%.2f",stack.pop());
        System.out.println(result);
    }
}