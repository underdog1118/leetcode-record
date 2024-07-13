package problems;


/*
Questions
Calculate US Federal Income Tax.

The US federal income tax rate can be descried as:

  0-$9950, 10%;
  $9950-$40,525, 12%;
  $40,525-$86,375, 15%;
  $86,375 - more, %30.

Question 1
Come up with a data structure and function that can be used to calculate US Federal Income Tax. For example

calculateTax(300):
  300 * 10% == 30
calculateTax(100000):
  9950 * 10%
  + (40525 - 9950) * 12%
  + (86375 - 40525) * 15%
  + (100000 - 86375) * 30% = 15629
 */


import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class SnowflakeVO {
  public static void main(String[] args) {

    System.out.println(calculate(300));
    // System.out.println(calculate(100000));
    // System.out.println(calculate(50000));
  }

  public static double calculate(double salary) {
    if (salary <= 0) {
      return 0;
    }

    double[] taxInEachLevel = new double[4];
    taxInEachLevel[0] = 0.1;
    taxInEachLevel[1] = 0.12;
    taxInEachLevel[2] = 0.15;
    taxInEachLevel[3] = 0.3;


    double[] brackets = new double[3];
    brackets[0] = 9950;
    brackets[1] = 40525;
    brackets[2] = 86375;


    double[] prefixSum = new double[3];
    prefixSum[0] = brackets[0] * taxInEachLevel[0];
    System.out.println("------------");
    System.out.println(prefixSum[0]);

    for (int i = 1; i < 3; i++) {
      prefixSum[i] = prefixSum[i-1] + (brackets[i] - brackets[i-1]) * taxInEachLevel[i];
      System.out.println(prefixSum[i]);
    }
    System.out.println("------------");



    // if (salary > 0 && salary <= 9950) {
    //   totalTax += salary * 0.1;
    // } else if (salary > 9950 && salary <= 40525) {
    //   totalTax +=  (salary-9950) * 0.12;
    //   totalTax += taxInEachLevel[0];
    // } else if (salary > 40525 && salary <= 86375) {
    //   totalTax +=  (salary-40525) * 0.15;
    //   totalTax += taxInEachLevel[0] + taxInEachLevel[1];
    // } else {
    //   totalTax +=  (salary-86375) * 0.3;
    //   totalTax += taxInEachLevel[0] + taxInEachLevel[1] + taxInEachLevel[2];
    // }

    int left = 0, right = brackets.length;
    while (left < right) {
      int mid = left + (right - left)/2;
      if (brackets[mid] < salary) {
        left = mid + 1;
      } else if (brackets[mid] >= salary) {
        right = mid;
      }
    }

    System.out.println(left);

    if (left == 0) {
      return salary * 0.1;
    }
    return (salary - brackets[left-1]) * taxInEachLevel[left] + prefixSum[left-1];


    // return totalTax;
  }

}


// Your previous Plain Text content is preserved below:

// This is just a simple shared plaintext pad, with no execution capabilities.

// When you know what language you'd like to use for your interview,
// simply choose it from the dots menu on the tab, or add a new language
// tab using the Languages button on the left.

// You can also change the default language your pads are created with
// in your account settings: https://app.coderpad.io/settings

// Enjoy your interview!
