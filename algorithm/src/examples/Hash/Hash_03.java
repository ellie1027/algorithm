package examples.Hash;


import java.util.HashMap;
import java.util.Map;

public class Hash_03 {

    public static void main(String[] args) {

        String[][] clothes = {{"yellow_hat", "face"}, {"blue_sunglasses", "face"}, {"green_turban", "test"}};
        int red = solution(clothes);

    }

    public static int solution(String[][] clothes) {
        HashMap<String,Integer>map = new HashMap<String, Integer>();

        //옷 종류별로 가짓수를 센다.
        for(String[] piece : clothes){
            map.put(piece[1], map.containsKey(piece[1]) ? map.get(piece[1])+1 : 1);
        }

        //종류 별로 중복없이 최대한 입을 수 있는 경우
        //cas *= (한 옷의 가짓수 + 안 입는 경우의 수)
        int cas = 1;
        for(Map.Entry<String, Integer> e : map.entrySet()) {
            cas *= (e.getValue().intValue()+1);
        }

        //아무것도 안 입는 경우의 수를 빼준다.
        return cas - 1;
    }

}
