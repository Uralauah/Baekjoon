import java.util.*;

class Solution {
    public int[] INFO;
    public ArrayList<Integer>[] node;
    public int max = Integer.MIN_VALUE;
    
    public void dfs(int now, ArrayList<Integer> notVisited, int w, int l){
        if(INFO[now]==0)
            l++;
        else
            w++;
        
        if(w>=l)
            return;
        
        max = Math.max(max, l);
        
        notVisited.addAll(node[now]);
        notVisited.remove(Integer.valueOf(now));
        
        for(int i=0;i<notVisited.size();i++){
            int next = notVisited.get(i);
            ArrayList<Integer> nV = new ArrayList(notVisited);
            dfs(next, nV, w, l);
        }
    }
    
    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        
        INFO = info;
        node = new ArrayList[info.length];
        for(int i=0;i<info.length;i++){
            node[i] = new ArrayList<>();
        }
        for(int i=0;i<edges.length;i++){
            int p = edges[i][0];
            int c = edges[i][1];
            
            node[p].add(c);
        }
        
        ArrayList<Integer> fV = new ArrayList(0);
        
        dfs(0,fV,0,0);
        
        return max;
    }
}