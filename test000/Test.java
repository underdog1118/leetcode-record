package test000;

public class Test {

  public static void main(String[] args) {
    char c = '5';
    int num = c - '0';  //类型强转 ASCII

    char c2 = 'b';
    int num2 = c2 - 'a';

//5.把int转换成对应的字符
    char c3 = (char) (num + '0');
    char c4 = (char) (num2 + 'a');

    System.out.println(num);
    System.out.println(num2);
    System.out.println(c3);
    System.out.println(c4);
  }
}
