import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.Provider;
import java.util.*;

public class Main {
    public static int N, F;
    public static HashMap<String, String> network;
    public static HashMap<String, Integer> friendNum;

    public static String find(String name) {
        if (!network.get(name).equals(name)) {
            network.put(name, find(network.get(name)));
        }
        return network.get(name);
    }

    public static void union(String n1, String n2) {
        String p1 = find(n1);
        String p2 = find(n2);
        int num1 = friendNum.get(p1);
        int num2 = friendNum.get(p2);
        if (!p1.equals(p2)) {
            network.put(p2, p1);
            friendNum.put(p1, num1 + num2);
        }
    }

    public static int getFriendNum(String name) {
        String parent = find(name);
        return friendNum.get(parent);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();
        N = Integer.parseInt(br.readLine());
        network = new HashMap<>();
        friendNum = new HashMap<>();
        for (int i = 0; i < N; i++) {
            F = Integer.parseInt(br.readLine());
            network.clear();
            friendNum.clear();

            for (int j = 0; j < F; j++) {
                String n1, n2;
                st = new StringTokenizer(br.readLine());
                n1 = st.nextToken();
                n2 = st.nextToken();

                if (!network.containsKey(n1)) {
                    network.put(n1, n1);
                    friendNum.put(n1, 1);
                }

                if (!network.containsKey(n2)) {
                    network.put(n2, n2);
                    friendNum.put(n2, 1);
                }

                String p1 = find(n1);
                String p2 = find(n2);

                if (!p1.equals(p2)) {
                    union(n1, n2);
                }
                sb.append(getFriendNum(n1)).append("\n");
            }
        }
        System.out.println(sb);
    }
}