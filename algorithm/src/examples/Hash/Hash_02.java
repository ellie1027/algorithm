package examples.Hash;

import java.util.Arrays;

//해시 문제로 되어있는데, 일단 이렇게 풀었음...
public class Hash_02 {

    public static void main(String[] args) {
        String[] phone_book = {"97674223", "976124", "118"};
        solution(phone_book);
    }

    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        //정렬
        Arrays.sort(phone_book);

        for(int i = 0; i < phone_book.length; i++){
            String str = phone_book[i];

            for(int j = (i+1); j < phone_book.length; j++) {
                answer = phone_book[j].startsWith(str);
                if (answer) break;
            }
            if(answer) break;
        }
        return !answer;
    }

}