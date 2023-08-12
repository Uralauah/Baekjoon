import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
        List <String> list = new LinkedList<>();

        int n=Integer.parseInt(br.readLine());
        for (int i=0;i<n;i++){
            String command = br.readLine();
            String[] arr = command.split(" ");
            switch(arr[0]){
                case "push_front":
                    list.add(0,arr[1]);
                    break;
                case "push_back":
                    list.add(arr[1]);
                    break;
                case "pop_front":
                    if (list.size()==0)
                        System.out.println(-1);
                    else
                        System.out.println(list.remove(0));
                    break;
                case "pop_back":
                    if (list.size()==0)
                        System.out.println(-1);
                    else
                        System.out.println(list.remove(list.size()-1));
                    break;
                case "size":
                    System.out.println(list.size());
                    break;
                case "empty":
                    if (list.size()==0)
                        System.out.println(1);
                    else
                        System.out.println(0);
                    break;
                case "front":
                    if (list.size()==0)
                        System.out.println(-1);
                    else
                        System.out.println(list.get(0));
                    break;
                case "back":
                    if (list.size()==0)
                        System.out.println(-1);
                    else
                        System.out.println(list.get(list.size()-1));
            }
        }

    }
}