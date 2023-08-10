import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Stack;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int n, num=0;
        int exit=0;
        int a;
        n=in.nextInt();
        Stack<Integer> stack=new Stack<>();
        List<Character> output=new ArrayList<>();
        for (int i=0;i<n;i++){
            a=in.nextInt();
            if (i==0)
            {
                for (int j=1;j<=a;j++)
                {
                    stack.push(j);
                    output.add('+');
                }
                num=stack.peek();
                stack.pop();
                output.add('-');
            }
            else if (a>num){
                for (int j=num+1;j<=a;j++){
                    stack.push(j);
                    output.add('+');
                }
                num=stack.peek();
                stack.pop();
                output.add('-');
            }
            else if (a<num){
                if(stack.peek()<a){
                    exit=1;
                }
                else if (stack.peek()!=a){
                    exit=1;
                }
                else{
                        stack.pop();
                        output.add('-');
                }
            }
        }

        Iterator<Character> iterator = output.iterator();
        if (exit==0){
            while (iterator.hasNext()) {
                Character element = iterator.next();
                System.out.println(element);
            }
        }
        else{
            System.out.println("NO");
        }
    }
}
