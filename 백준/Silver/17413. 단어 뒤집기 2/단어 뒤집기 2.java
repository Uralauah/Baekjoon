import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.LinkedList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
        List <String> list = new LinkedList<>();
        Stack <Character> stack = new Stack<>();

        String text = br.readLine();
        int pass=0;
        for (int i=0;i<text.length();i++){
            if (text.charAt(i)=='<'){
                if (!stack.isEmpty())
                    while(!stack.isEmpty())
                        System.out.print(stack.pop());
                System.out.print(text.charAt(i));
                pass=1;
            }
            else if (text.charAt(i)==' '){
                if(!stack.isEmpty())
                    while(!stack.isEmpty())
                        System.out.print(stack.pop());
                System.out.print(' ');
            }
            else if (pass==1)
            {
                System.out.print(text.charAt(i));
                if (text.charAt(i)=='>')
                    pass=0;
            }
            else {
                stack.push(text.charAt(i));
            }
        }
        while(!stack.isEmpty())
            System.out.print(stack.pop());
    }
}
