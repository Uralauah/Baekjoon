import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        // for(int i=0;i<k;i++){
        //     for(int j=0;j<number.length();j++){
        //         if (j==number.length()-1){
        //             number = number.substring(0,j);
        //         }
        //         else if (number.charAt(j)<number.charAt(j+1)){
        //             number = number.substring(0,j)+number.substring(j+1);
        //             break;
        //         }
        //     }
        // }
        // answer = number;
        Stack<Character> s = new Stack<>();
        s.push(number.charAt(0));
        int i;
        for(i=1;i<number.length();i++){
            
            while(k>0&&!s.isEmpty()&&s.peek()<number.charAt(i)){
                s.pop();
                k--;
            }
            if(k==0)
                break;
            s.push(number.charAt(i));
        }
        for(;i<number.length();i++){
            s.push(number.charAt(i));
        }
        while(k>0){
            s.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        for(char temp : s){
            sb.append(temp);
        }
        return sb.toString();
    }
}