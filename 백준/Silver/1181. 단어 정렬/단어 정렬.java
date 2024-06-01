import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        Set<String> set = new HashSet<>();
        for(int i=0;i<N;i++){
            set.add(br.readLine());
        }
        arr = set.toArray(new String[0]);
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()<o2.length())
                    return -1;
                else if(o1.length()>o2.length())
                    return 1;
                else
                    return o1.compareTo(o2);
            }
        });
        for(String ans : arr){
            System.out.println(ans);
        }
    }
}