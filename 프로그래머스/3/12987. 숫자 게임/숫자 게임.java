import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0;i<B.length;i++){
            dq.addLast(B[i]);
        }
        
        for(int i=A.length-1;i>=0;i--){
            int a = A[i];
            if(dq.peekLast()>a){
                dq.pollLast();
                answer++;
            }
            else{
                dq.pollFirst();
            }
        }
        
        
        return answer;
    }
}