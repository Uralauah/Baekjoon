import java.util.*;

class Solution {
    public int[] solution(String msg) {
        int[] answer = {};
        HashMap<String,Integer> hm = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<26;i++){
            hm.put(String.valueOf((char)('A'+i)),i+1);
        }
        int len = 27;
        
        int i=0;
        while(i<msg.length()){
            int idx = i+1;
            while(idx<=msg.length()&&hm.containsKey(msg.substring(i,idx))){
                idx++;
            }
            ans.add(hm.get(msg.substring(i,idx-1)));
            
            if(idx<=msg.length())
                hm.put(msg.substring(i,idx),len++);
            
            i = idx-1;
        }
        
        answer = new int[ans.size()];
        for(i=0;i<ans.size();i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }
}