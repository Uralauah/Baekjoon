import java.util.*;

class Solution {
    public boolean check(String p){
        Stack<Character> s = new Stack<>();
        for(int i=0;i<p.length();i++){
            if(p.charAt(i)=='(')
                s.push('(');
            else{
                if(s.isEmpty())
                    return false;
                s.pop();
            }
        }
        return true;
    }
    
    public int divide(String p){
        int l =0, r = 0, i;
        for(i=0;i<p.length();i++){
            if(p.charAt(i)=='(')
                l++;
            else
                r++;
            if(l==r)
                break;
        }
        return i+1;
    }
    
    public String remake(String p){
        if(p.equals(""))
            return "";
        int d = divide(p);
        String u = p.substring(0,d);
        String v = p.substring(d);
        if(check(u)){
            String result = remake(v);
            return u+result;
        }
        else{
            String temp = "(" + remake(v) + ")";
            temp+=reverse(u);
            return temp;
        }
    }
    
    public String reverse(String p){
        String result = "";
        for(int i=1;i<p.length()-1;i++){
            if(p.charAt(i)=='('){
                result += ")";
            }
            else{
                result+="(";
            }
        }
        return result;
    }
    
    public String solution(String p) {
        String answer = "";
        if(check(p)){
            return p;
        }
        else{
            answer = remake(p);
        }
        return answer;
    }
}