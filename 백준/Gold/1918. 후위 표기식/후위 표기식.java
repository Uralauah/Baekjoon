import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack <Character> stack = new Stack<>();
        Map <Character,Integer> map = new HashMap<>();

        map.put('(',0);
        map.put('*',1);
        map.put('/',1);
        map.put('+',2);
        map.put('-',2);

        String text = br.readLine();
        for (int i=0;i<text.length();i++){
            if (text.charAt(i)>='A'&&text.charAt(i)<='Z')
                sb.append(text.charAt(i));
            else if (stack.isEmpty()){
                if (text.charAt(i)!=')')
                    stack.push(text.charAt(i));
            }
            else {
                if (text.charAt(i) == ')') {
                    while (stack.peek() != '(')
                        sb.append(stack.pop());
                    if (!stack.isEmpty())
                        stack.pop();
                }
                else if (stack.peek() == '('){
                    stack.push(text.charAt(i));
                }
                else if (map.get(text.charAt(i)) < map.get(stack.peek())) {
                    stack.push(text.charAt(i));
                }
                else if (map.get(text.charAt(i)) == map.get(stack.peek())) {
                    sb.append(stack.pop());
                    stack.push(text.charAt(i));
                }
                else if (map.get(text.charAt(i)) > map.get(stack.peek())) {
                    while (!stack.isEmpty()){
                        if (stack.peek()=='('){
                            break;
                        }
                        else
                            sb.append(stack.pop());
                    }

                    stack.push(text.charAt(i));
                }
            }
        }
        while(!stack.isEmpty())
            sb.append(stack.pop());
        System.out.println(sb);
    }
}