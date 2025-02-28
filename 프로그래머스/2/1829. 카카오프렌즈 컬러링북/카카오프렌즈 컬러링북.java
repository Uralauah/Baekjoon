import java.util.*;

class Solution {
    public class Pixel{
        private int x;
        private int y;
        
        public Pixel(int x, int y){
            this.x = x;
            this.y = y;
        }
        
        public int getX(){
            return x;
        }
        
        public int getY(){
            return y;
        }
    }
    
    public int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        
        boolean[][] visited = new boolean[m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(picture[i][j]==0)
                    visited[i][j] = true;
            }
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(visited[i][j])
                    continue;
                
                Queue<Pixel> q = new LinkedList<>();
                q.offer(new Pixel(i,j));
                int temp = 0;
                
                while(!q.isEmpty()){
                    Pixel now = q.poll();
                    
                    for(int k=0;k<4;k++){
                        int tx = now.getX() + dir[k][0];
                        int ty = now.getY() + dir[k][1];
                        
                        if(tx<0||tx>=m||ty<0||ty>=n||visited[tx][ty]){
                            continue;
                        }
                        
                        if(picture[tx][ty]==picture[now.getX()][now.getY()]){
                            q.offer(new Pixel(tx,ty));
                            visited[tx][ty] = true;
                            temp++;
                        }
                    }
                }
                numberOfArea++;
                maxSizeOfOneArea = Math.max(maxSizeOfOneArea, temp);
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}