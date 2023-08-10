import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
        List <Integer> q = new ArrayList<>();

        int n= Integer.parseInt(br.readLine());
        for (int i=0;i<n;i++){
            String command = br.readLine();
            String arr[] = command.split(" ");
            switch (arr[0]){
                case ("push"):
                    q.add(Integer.parseInt(arr[1]));
                    break;
                case ("front"):
                    if (q.size()==0){
                        System.out.println("-1");
                    }
                    else {
                        System.out.println(q.get(0));
                    }
                    break;
                case ("back"):
                    if (q.size()==0){
                        System.out.println("-1");
                    }
                    else{
                        System.out.println(q.get(q.size()-1));
                    }
                    break;
                case ("empty"):
                    if (q.size()==0)
                        System.out.println("1");
                    else
                        System.out.println("0");
                    break;
                case ("pop"):
                    if (q.size()==0)
                        System.out.println("-1");
                    else{
                        System.out.println(q.get(0));
                        q.remove(0);
                    }
                    break;
                case ("size"):
                    System.out.println(q.size());
                    break;
            }
        }

    }
}
