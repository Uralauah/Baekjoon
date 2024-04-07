import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {
    public static class Node{
        int value;
        Node left,right;

        Node(int value){
            this.value = value;
        }
        void insert(int input){
            if(input<this.value){
                if(this.left!=null)
                    this.left.insert(input);
                else
                    this.left=new Node(input);
            }
            else{
                if(this.right!=null)
                    this.right.insert(input);
                else
                    this.right=new Node(input);
            }
        }
    }

    public static void post(Node root){
        if(root==null)
            return;
        post(root.left);
        post(root.right);
        System.out.println(root.value);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Node root = new Node(Integer.parseInt(input));
        while((input = br.readLine())!=null&&!input.isEmpty()){
            int val = Integer.parseInt(input);
            root.insert(val);
        }
        post(root);
    }
}

