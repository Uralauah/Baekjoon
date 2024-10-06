import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int d = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] oven = new int[d];
        int[] pizza = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < d; i++) {
            int a = Integer.parseInt(st.nextToken());
            if (i > 0 && a > oven[i - 1])
                oven[i] = oven[i - 1];
            else
                oven[i] = a;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            pizza[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();

        stack.push(0);
        int j = 0;
        for (int i = 0; i < d; i++) {
            if (pizza[0] <= oven[i]) {
                stack.push(oven[i]);
                j++;
            } else {
                break;
            }
        }
        stack.pop();
//        System.out.println(j);
        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty()) {
                j--;
                if (stack.peek() < pizza[i]) {
                    stack.pop();
                } else {
                    stack.pop();
                    break;
                }
            }
        }
        if (stack.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(j);
        }
    }
}