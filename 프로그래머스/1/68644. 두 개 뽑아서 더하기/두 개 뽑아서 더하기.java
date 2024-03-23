import java.util.*;

/*22012123 이승현*/
class Solution {
    public int[] solution(int[] numbers) {
        ArrayList<Integer>temp = new ArrayList<Integer>();
        for(int i=0;i<numbers.length-1;i++){
            for(int j=i+1;j<numbers.length;j++){
                if(!temp.contains(numbers[i]+numbers[j])){
                    temp.add(numbers[i]+numbers[j]);
                }
            }
        }
        sort(temp);
        int[]answer = new int[temp.size()];
        for(int i=0;i<temp.size();i++)
            answer[i]=temp.get(i);
        return answer;
    }

    public void sort(ArrayList<Integer> numbers){
        int n = numbers.size();
        for(int i=1;i<n;i++){
            for(int j=i;j>0&&numbers.get(j)<numbers.get(j-1);j--){
                int temp = numbers.get(j);
                numbers.set(j,numbers.get(j-1));
                numbers.set(j-1,temp);
            }
        }
    }
}
