class Solution {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        int answer = 0;
        int[][] down = new int[m+1][n+1];
        int[][] right = new int[m+1][n+1];
        
        for(int i=0;i<m;i++){
            if(cityMap[i][0]==1)
                break;
            down[i][0] = 1;
        }
        for(int j=0;j<n;j++){
            if(cityMap[0][j]==1)
                break;
            right[0][j] = 1;
        }
         
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(cityMap[i][j]==1)
                    continue;
                
                int left = right[i][j-1];
                if(cityMap[i][j-1]==0){
                    left = (left+ down[i][j-1])%MOD;
                }
                
                int up = down[i-1][j];
                if(cityMap[i-1][j]==0){
                    up = (up +right[i-1][j])%MOD;
                }
                
                right[i][j] = left%MOD;
                down[i][j] = up%MOD;
            }
        }
        
//         for(int i=0;i<m;i++){
//             for(int j=0;j<n;j++){
//                 System.out.print(down[i][j]+" ");
//             }
//             System.out.println();
//         }
        
//         System.out.println();
//         for(int i=0;i<m;i++){
//             for(int j=0;j<n;j++){
//                 System.out.print(right[i][j]+" ");
//             }
//             System.out.println();
//         }
        
        return (right[m-1][n-1]+ down[m-1][n-1])%MOD;
    }
}

