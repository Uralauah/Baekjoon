class Solution {
    public int solution(int[][] triangle) {
        int[][] temp = new int[triangle.length][triangle.length];
        temp[0][0]=triangle[0][0];
        for(int i = 0;i<triangle.length-1;i++){
            for(int j=0;j<triangle[i].length;j++){
                temp[i+1][j] = Math.max(temp[i+1][j],triangle[i+1][j]+temp[i][j]);
        
                temp[i+1][j+1]=Math.max(temp[i+1][j+1],triangle[i+1][j+1]+temp[i][j]);
            }
        }
        int answer = 0;
        for(int i=0;i<temp[temp.length-1].length;i++){
            answer = Math.max(answer,temp[temp.length-1][i]);
        }
        return answer;
    }
}