import java.util.*;



class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0]; 
            }
        });
        int max = routes[0][1];
        for(int i=1;i<routes.length;i++){
            if(routes[i][0]<=max){
                if(routes[i][1]<max)
                    max = routes[i][1];
                continue;
            }
            else{
                answer++;
                max = routes[i][1];
            }
        }
        if(max<=routes[routes.length-1][1]&&max>=routes[routes.length-1][0])
            answer++;
        return answer;
    }
}