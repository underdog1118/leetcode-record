import java.util.ArrayList;
import java.util.List;

public class lc412 {
    public static void main(String[] args) {
            List<String> answer = new ArrayList<String>();
            for(int i = 0; i < 5; i++){
                String n = Integer.toString(i);
                answer.add(n);
            }
        System.out.println(answer);
    }
}
