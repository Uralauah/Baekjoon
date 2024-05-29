import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        ArrayList<String> idList = new ArrayList<>();
        ArrayList<ArrayList<String>> reported = new ArrayList<>();
        for(int i=0;i<id_list.length;i++){
            idList.add(id_list[i]);
            reported.add(new ArrayList<String>());
        }
        
        for(int i=0;i<report.length;i++){
            StringTokenizer st = new StringTokenizer(report[i]);
            String r1 = st.nextToken();
            String r2 = st.nextToken();
            int id = idList.indexOf(r2);
            if(reported.get(id).contains(r1)){
                continue;
            }
            reported.get(id).add(r1);
        }
        
        for(int i=0;i<reported.size();i++){
            if(reported.get(i).size()>=k){
                // answer[i]++;
                for(int j=0;j<reported.get(i).size();j++){
                    int id = idList.indexOf(reported.get(i).get(j));
                    answer[id]++;
                }
            }
        }
        
        return answer;
    }
}