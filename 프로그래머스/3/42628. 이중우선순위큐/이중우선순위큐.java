import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0,0};
        
        PriorityQueue<Integer> pqd = new PriorityQueue<>();
        PriorityQueue<Integer> pqa = new PriorityQueue<>(Comparator.reverseOrder());
        // HashSet<Integer> hs = new HashSet<>();
        
        for(int i=0;i<operations.length;i++){
            StringTokenizer st = new StringTokenizer(operations[i]);
            
            // while(!pqd.isEmpty()){
            //     if(hs.contains(pqd.peek()))
            //         break;
            //     pqd.poll();
            // }
            // while(!pqa.isEmpty()){
            //     if(hs.contains(pqa.peek()))
            //         break;
            //     pqa.poll();
            // }
            
            // System.out.println(pqa.peek()+" "+pqd.peek());
            // System.out.println(hs.contains(pqa.peek()) + " "+hs.contains(pqd.peek()));
            
            if(st.nextToken().equals("I")){
                int num = Integer.parseInt(st.nextToken());
                pqd.offer(num);
                pqa.offer(num);
                // hs.add(num);
            }
            else{
                if(st.nextToken().equals("1")){
                    if(pqa.isEmpty())
                        continue;
                    int a = pqa.poll();
                    pqd.remove(a);
                    // if(hs.contains(a)){
                        // hs.remove(a);
                    // }
                }
                else{
                    if(pqd.isEmpty())
                        continue;
                    int a = pqd.poll();
                    pqa.remove(a);
                    // if(hs.contains(a)){
                    //     // hs.remove(a);
                    // }
                }
            }
        }
        
        // if(hs.isEmpty()){
        //     answer = new int[]{0,0};
        // }
        // else{
        //     int a = pqa.poll();
        //     int d = pqd.poll();
        //     if(!hs.contains(a)){
        //         a = 0;
        //     }
        //     if(!hs.contains(d))
        //         d = 0;
        //     answer = new int[]{a,d};
        // }
        
        
        if(!pqa.isEmpty() && !pqd.isEmpty()){
            int a = pqa.poll();
            int b = pqd.poll();
            
            answer = new int[]{a,b};
        }
        
        
        return answer;
    }
}