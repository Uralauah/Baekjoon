import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int answer = 0;
        int[] wonho = new int[2];
        wonho[0] = scores[0][0];
        wonho[1] = scores[0][1];
        
        Arrays.sort(scores, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return (b[0]+b[1]) - (a[0]+a[1]);
            }
        });
        
        int score = 0;
        for(int i=0;i<scores.length;i++){
            
            score++;
            if(scores[i][0]==wonho[0]&&scores[i][1]==wonho[1]){
                break;
            }
            if(scores[i][0]>wonho[0]&&scores[i][1]>wonho[1]){
                score = -1;
                break;
            }
            for(int j=0;j<i;j++){
                if(scores[j][0]>scores[i][0]&&scores[j][1]>scores[i][1]){
                    score-=1;
                    break;
                }
            }
        }
        
        
        // for(int i=0;i<scores.length;i++){
        //     System.out.println(scores[i][0]+" "+scores[i][1]+" "+(scores[i][0]+scores[i][1]));
        // }
        return score;
    }
}