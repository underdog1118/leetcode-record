package test000;

public class Test {

  public static void main(String[] args) {
    System.out.println(addFun(6));

  }

  public static int addFun(int n) {
    if (n <= 0) {
      return  0;
    } else if ( n == 1) {
      return 2;
    }
    return addFun(n-1) + addFun(n-2);
  }
}
