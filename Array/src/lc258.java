package Array.src;

public class lc258 {

  public static void main(String[] args) {
    lc258 lc = new lc258();
    int[] arr = new int[]{1,2,2,3,5,5,5};
    int l = lc.left_bound(arr, 2);  // idx1 找2的左侧边界
    int l2= lc.left_bound(arr, 5); // idx4 5的左
    int l3= lc.left_bound(arr, 2+1) - 1; // idx3-1=2可以找到2的右侧边界（找比2大1的数的最左侧边界3，减1即可得到2的右边界）
    int l4= lc.left_bound(arr, 5+1) - 1; // idx7-1=6(找5+1=6的左边界，即使6不存在与数组中，仍能返回6应该插入在数组中的索引位置7, -1既是5的右边界


    int r = lc.right_bound(arr, 2); // idx 2
    int r2= lc.right_bound(arr, 5); // idx 6
    int rNull = lc.right_bound(arr, 0); //-1

    System.out.println(l);
    System.out.println(l2);
    System.out.println("-------------------");
    System.out.println(l3);
    System.out.println(l4);
    System.out.println("-------------------");
    System.out.println(r);
    System.out.println(r2);
    System.out.println(rNull);
  }

  public int left_bound (int[] nums, int target) { //找存在数字的左边界
    int left = 0;
    int right = nums.length;  //左闭右开
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] > target) {
        right = mid;
      } else if (nums[mid] < target) {
        left = mid + 1;
      } else if (nums[mid] == target) {  //找左侧边界，即使找到该数，依然应该往左压缩
        right = mid;
      }
    }
//
//    if (right == nums.length || nums[right] != target) { //判断target是否存在
//      return -1;
//    }
    return left;  //right也可
  }

  public int right_bound (int[] nums, int target) { //找存在数字的右边界
    int left = 0;
    int right = nums.length;  //左闭右开
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] > target) {
        right = mid;
      } else if (nums[mid] < target) {
        left = mid + 1;
      } else if (nums[mid] == target) {  //找左侧边界，即使找到该数，依然应该往左压缩
        left = mid + 1;
      }
    }
    if (left - 1 < 0 || nums[left - 1] != target) { //判断索引是否越界和target是否存在
      return -1;
    }else{
      return left - 1; //left为第一个>target元素，left-1为最后一个<=target元素,即右边界
    }
  }

}
