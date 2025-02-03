import java.util.*;

class Node{
    private Integer num, x, y;
    private Node left;
    private Node right;
    
    public Node(int num, int x, int y){
        this.x = x;
        this.y = y;
        this.num = num;
    }
    
    public void setLeft(Node left){
        this.left = left;
    }
    
    public void setRight(Node right){
        this.right = right;
    }
    
    public Integer getX(){
        return x;
    }
    
    public Integer getY(){
        return y;
    }
    
    public Integer getNum(){
        return num;
    }
    
    public Node getRight(){
        return right;
    }
    
    public Node getLeft(){
        return left;
    }
}

class Solution {
    public ArrayList<Integer> preorder, postorder;
    
    public void pre(Node now){
        if(now==null)
            return;
        
        preorder.add(now.getNum());
        // System.out.print(now.getNum()+" ");
        // if(now.getLeft()!=null)
        //     System.out.print(now.getLeft().getNum()+" ");
        // else
        //     System.out.print("null ");
        // if(now.getRight()!=null)
        //     System.out.println(now.getRight().getNum()+" ");
        // else
        //     System.out.println("null ");
        pre(now.getLeft());
        pre(now.getRight());
    }
    
    public void post(Node now){
        if(now == null)
            return;
        
        post(now.getLeft());
        post(now.getRight());
        postorder.add(now.getNum());
    }
    
    
    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][nodeinfo.length];
        preorder = new ArrayList<>();
        postorder = new ArrayList<>();
        
        Node[] nodes = new Node[nodeinfo.length];
        
        for(int i=0;i<nodeinfo.length;i++){
            nodes[i] = new Node(i+1, nodeinfo[i][0], nodeinfo[i][1]);
        }
        
        Arrays.sort(nodes,new Comparator<Node>(){
            @Override
            public int compare(Node a, Node b){
                if(a.getY()==b.getY()){
                    return Integer.compare(a.getX(),b.getX());
                }
                return Integer.compare(b.getY(),a.getY());
            }
        });
        
        // for(int i=0;i<nodes.length;i++){
        //     System.out.println(nodes[i].getX()+" "+nodes[i].getY());
        // }
        
        Node head = nodes[0];
        
        for(int i=1;i<nodes.length;i++){
            head = nodes[0];
            while(true){
                if(head.getX()<nodes[i].getX()){
                    if(head.getRight() == null){
                        head.setRight(nodes[i]);
                        break;
                    }
                    head = head.getRight();
                }
                else{
                    if(head.getLeft() == null){
                        head.setLeft(nodes[i]);
                        break;
                    }
                    head = head.getLeft();
                }
            }
        }
        
        pre(nodes[0]);
        post(nodes[0]);
        
        for(int i=0;i<nodes.length;i++){
            answer[0][i] = preorder.get(i);
            answer[1][i] = postorder.get(i);
        }
        
        return answer;
    }
}