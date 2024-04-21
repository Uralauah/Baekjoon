import java.util.HashSet;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashSet<String> hs = new HashSet<>();
        for(int i=0;i<phone_book.length;i++){
            hs.add(phone_book[i]);
        }
        
        for(int i=0;i<phone_book.length;i++){
            for(int j=1;j<phone_book[i].length();j++){
                if(hs.contains(phone_book[i].substring(0,j))){
                    return false;
                }
            }
        }
        return answer;
    }
}