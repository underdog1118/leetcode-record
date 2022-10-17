package Array.src;

import java.util.ArrayList;
import java.util.List;

public class lc412 {

        public List<String> fizzBuzz(int n) {
            List<String> answer = new ArrayList<String>();
            answer.add("1");
            for(int i = 2; i < n+1; i++){
                String k = Integer.toString(i);
                if(i%3 == 0 && i%5 == 0){
                    answer.add("FizzBuzz");
                }else if(i%5 == 0){
                    answer.add("Buzz");
                }else if(i%3 == 0){
                    answer.add("Fizz");
                }else{
                    answer.add(k);
                }
            }
            return answer;
        }
    }

