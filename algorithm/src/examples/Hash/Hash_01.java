package examples.Hash;

import java.util.HashMap;
import java.util.Map;

public class Hash_01 {

    public static void main(String[] args) {

        String[] p = {"kane", "son", "bale"};
        String[] c = {"kane", "son"};

        solution(p, c);

    }

    public static String solution(String[] participant, String[] completion) {

        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i < participant.length; i++){
            int index = 1;

            if(map.containsKey(participant[i])){
                index = map.get(participant[i]);
                index++;
            }
            map.put(participant[i], index);
        }

        for(int i = 0; i < completion.length; i++){
            int com = map.get(completion[i]);

            if(map.containsKey(completion[i])){
                com--;
                map.put(completion[i], com);
            }
        }

        for(Map.Entry<String, Integer> e : map.entrySet()){
            if(e.getValue() == 1){
                answer = e.getKey();
            }
        }

        return answer;

}



}
