import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        String text= br.readLine();
        for (int i=0;i<text.length();i++)
            stack1.push(text.charAt(i));

        int m= Integer.parseInt(br.readLine());
        for (int i=0;i<m;i++) {
            String command = br.readLine();
            char menu = command.charAt(0);
            if (menu == 'L'){
                if (stack1.size()!=0){
                    stack2.push(stack1.pop());
                }
            }
            if (menu == 'D'){
                if (stack2.size()!=0){
                    stack1.push(stack2.pop());
                }
            }
            if (menu == 'B'){
                if(!stack1.isEmpty())
                    stack1.pop();
            }
            if (menu == 'P'){
                char a = command.charAt(2);
                stack1.push(a);
            }
        }
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        while(!stack2.isEmpty()){
            bw.write(stack2.pop());
        }
        bw.flush();
        bw.close();
    }
}