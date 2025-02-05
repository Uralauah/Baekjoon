import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer;
        ArrayList<Integer>[] tuple;
        StringTokenizer st = new StringTokenizer(s,"}");
        int idx = 0, len = 0;
        while(st.hasMoreTokens()){
            len++;
            st.nextToken();
        }
        System.out.println(len);
        tuple = new ArrayList[len];
        
        st = new StringTokenizer(s,"}");
        while(st.hasMoreTokens()){
            String temp = st.nextToken();
            int f = temp.lastIndexOf("{");
            
            StringTokenizer st2 = new StringTokenizer(temp.substring(f+1),",");
            tuple[idx] = new ArrayList<>();
            
            while(st2.hasMoreTokens()){
                tuple[idx].add(Integer.parseInt(st2.nextToken()));
            }
            idx++;
        }
        
        Arrays.sort(tuple,new Comparator<ArrayList<Integer>>(){
            @Override
            public int compare(ArrayList<Integer> a, ArrayList<Integer> b){
                return Integer.compare(a.size(), b.size());
            }
        });
        
        ArrayList<Integer> t = new ArrayList<>();
        
        for(int i=0;i<len;i++){
            for(int j=0;j<tuple[j].size();j++){
                if(!t.contains(tuple[i].get(j))){
                    t.add(tuple[i].get(j));
                    break;
                }
            }
        }
        
        
        // for(int i=0;i<idx;i++){
        //     for(int j=0;j<tuple[i].size();j++){
        //         System.out.print(tuple[i].get(j)+" ");
        //     }
        //     System.out.println();
        // }
        
        answer = t.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}