package Array.src;

public class test {
    public static void main(String[] args) {
        String str = "ab cd e";
        String[] s = str.split(" ");
        for (int i = 0; i < s.length; i++) {
            System.out.print(s[i] + ' ');
        }

    }
}
