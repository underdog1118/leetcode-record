package RentCalculator;

import java.util.Scanner;

public class Calculator {
  private static final double SERVICE_FEE_PER_PAYMENT = 7.95;
  private static final double INTERNET_FEE_PER_MONTH = 30.0;
  private static final double RENT_PER_MONTH = 2774.0;
  private static final double RENTER1_PER_MONTH = 1437.0;
  private static final double RENTER2_PER_MONTH = 1337.0;

  public static void main(String[] args) {
    //租户2总计月账单, 计算月房租和付款服务费
    double renter2TotalBill = 0.0;
    renter2TotalBill += RENTER2_PER_MONTH;
    renter2TotalBill += SERVICE_FEE_PER_PAYMENT/2.0;

    //1.得到总月账单
    Scanner sc = new Scanner(System.in);
    System.out.println("月账单总额:  (不包括服务费）");
    double monthAmount = sc.nextDouble();

    // 2.上月杂费
    double lastMonthExtraFee = monthAmount - RENT_PER_MONTH;
    double lastMonthExtraFeePerPerson = lastMonthExtraFee/2.0;
    renter2TotalBill += lastMonthExtraFeePerPerson;

    // 3.网费
    renter2TotalBill += INTERNET_FEE_PER_MONTH;

    // 4.电费（可能有）
    System.out.println("是否有电费账单？(Y/N)");
    String isElectricBill = sc.next().toUpperCase();
    //有电费情况
    if (isElectricBill.equals("Y")) {
      System.out.println("电费账单总额: ");
      double electricBill = sc.nextDouble();
      renter2TotalBill += electricBill / 2.0;

      System.out.println("租户1总计需要支付: $ "+ String.format("%.2f",100+renter2TotalBill));
      System.out.println("租户2总计需要支付: $ "+ String.format("%.2f",renter2TotalBill) +
          "\n 1.房租: " + RENTER2_PER_MONTH +
          "\n 2.上月杂费: " + String.format("%.2f",lastMonthExtraFeePerPerson) +
          "\n 3.网费: " + INTERNET_FEE_PER_MONTH +
          "\n 4.电费: " + electricBill/2.0 +
          "\n 5.服务费: " + SERVICE_FEE_PER_PAYMENT/2.0);
    } else {
      //无电费情况
//      System.out.println("租户1总计需要支付: $ "+ String.format("%.2f",100+renter2TotalBill));
      System.out.println("租户2总计需要支付: $ "+  String.format("%.2f",renter2TotalBill) +
          "\n 1.房租 " + RENTER2_PER_MONTH +
          "\n 2.上月杂费: " + String.format("%.2f",lastMonthExtraFeePerPerson) +
          "\n 3.网费" + INTERNET_FEE_PER_MONTH +
          "\n 4.服务费: " + SERVICE_FEE_PER_PAYMENT/2.0);
    }
  }
}
