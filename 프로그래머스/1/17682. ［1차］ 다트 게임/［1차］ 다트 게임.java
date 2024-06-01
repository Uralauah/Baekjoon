import java.util.*;
class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int temp = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<dartResult.length();i++){
            if(dartResult.charAt(i)>='0'&&dartResult.charAt(i)<='9'){
                ans.add(temp);
                if(i+1 < dartResult.length() && dartResult.charAt(i+1) == '0'){
                    temp = 10;
                    i++;
                    continue;
                } else {
                    temp = dartResult.charAt(i) - '0';
                }
                temp=dartResult.charAt(i) - '0';
                continue;
            }
            switch(dartResult.charAt(i)){
                case 'S':
                    break;
                case 'D':
                    temp = temp*temp;
                    break;
                case 'T':
                    temp = temp*temp*temp;
                    break;
                case '*':
                    temp *=2;
                    ans.set(ans.size()-1,ans.get(ans.size()-1)*2);
                    break;
                case '#':
                    temp *=-1;
                    break;
            }
        }
        ans.add(temp);
        for(int t : ans){
            answer += t;
        }
        return answer;
    }
}