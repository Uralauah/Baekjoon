import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Map <Character,Integer> map = new HashMap<>();

        String input="";
        while((input=br.readLine())!=null&&!input.isEmpty()){
            int[]num=new int[4];
            for (int i=0;i<input.length();i++){
                if (input.charAt(i)>='a'&&input.charAt(i)<='z')
                    num[0]++;
                else if (input.charAt(i)>='A'&&input.charAt(i)<='Z')
                    num[1]++;
                else if (input.charAt(i)>='0'&&input.charAt(i)<='9')
                    num[2]++;
                else if (input.charAt(i)==' ')
                    num[3]++;
            }
            for (int i=0;i<4;i++){
                System.out.print(num[i]);
                System.out.print(' ');
            }
            System.out.println();
        }
    }
}
