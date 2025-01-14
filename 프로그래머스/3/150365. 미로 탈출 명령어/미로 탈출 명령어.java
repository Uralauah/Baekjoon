import java.util.*;
import java.io.*;

class Solution {
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        StringBuilder answer = new StringBuilder();
        int down = 0, left = 0, up = 0, right = 0;
        
        int diff = Math.abs(x-r) + Math.abs(y-c);
        k -= diff;
        
        if(k<0 || k%2!=0){
            return "impossible";
        }
        
        if(x>r){
            up+=x-r;
        }
        else{
            down+=r-x;
        }
        
        if(y>c){
            left += y-c;
        }
        else{
            right += c-y;
        }
        
        answer.append("d".repeat(down));
        int extra_down = Math.min(k/2,n-(x+down));
        answer.append("d".repeat(extra_down));
        up += extra_down;
        k-=2*extra_down;
        
        answer.append("l".repeat(left));
        int extra_left = Math.min(k/2,y-left-1);
        answer.append("l".repeat(extra_left));
        right += extra_left;
        k-=2*extra_left;
        
        answer.append("rl".repeat(k/2));
        
        answer.append("r".repeat(right));
        answer.append("u".repeat(up));
        
        
        return answer.toString();
    }
}