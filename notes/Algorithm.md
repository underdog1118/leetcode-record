## 1.Binary Search

O(logN) 

Sorted

<img src="images/image-20221107183416041.png" alt="image-20221107183416041" style="zoom: 67%;" />

<img src="images/image-20221011002052582.png" alt="image-20221011002052582" style="zoom: 50%;" />

<img src="images/image-20221011002102084.png" alt="image-20221011002102084" style="zoom:50%;" />

```java
int[] nums = new int[]{};
int target;
if(nums == null || nums.length == 0) //判断空集
  return -1;
//一. 单独找到某个数字
//1.左闭右闭
int left = 0;
int right = nums.length - 1;
while (left <= ight){  
  int mid = left + (right - left）/2;   //防止overflow
  if(nums[mid] < target){
    left = mid + 1;
  }else if(nums[mid] > target){
    right = mid - 1;       
  }else{
    return mid;
  }
}
//2.左闭右开
int left = 0;
int right = nums.length;
while (left < right){  
  int mid = left + (right - left/2;   //防止overflow
  if(nums[mid] < target){
    left = mid + 1;
  }else if(nums[mid] > target){
    right = mid;       
  }else{
    return mid;
  }
}
//3.左开右开
int left = -1;
int right = nums.length;
while(left + 1 < right){
  int mid = left + (right-left)/2;
  if(nums[mid] < target){
    left = mid;
  }else if(nums[mid] > target){
  	right = mid;  
  }else{
    return mid;
  }
}
                    
                    
```

```java
//二.寻找左边界（多个相同的target)
    int left_bound(int[] nums, int target) {
        int left = -1;
        int right = nums.length;
        while (left + 1 != right){
            int mid = left + (right - left) / 2;
            if (nums[mid] < target){
                left = mid;
            }else if (nums[mid] > target){
                right = mid;
            }else if (nums[mid] == target){
                right = mid; //找左极限， 得到target时候令right = mid, 把区间往左边压
            }
        }
      if (right == nums.length || nums[right] != target) { //判断target是否存在
        	return -1;
      }else{
      		return right; //left为最后一个<target元素，right为第一个>=target元素
      }
    }
```

```java
  //三.找最右侧的target
	int right_bound(int[] nums, int target) {
        int left = -1;
        int right = nums.length;
        while (left + 1 < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] > target){
                right = mid;
            }else if (nums[mid] < target){
                left = mid;
            }else if (nums[mid] == target){
                left = mid;  //找到target时候，把区间往右侧压缩， 找最右侧=target的元素
            }
        }
        if (left < 0 || nums[left] != target) { //判断索引是否越界和target是否存在
            return -1;
        }else{
            return left; //left为最后一个<=target元素，right为第一个>target元素
        }
    }
```

```java
//应用问题，珂珂吃香蕉
//1.先定义函数 f(x) 为 关于 x 的函数， f(x)随着x变大而单调递增/单调递减
//2.在主函数里调用f(x), left, right 二分查找 mid 与 target 比较
//在f(x) == target的限制下， 得到x的边界值
int fx(int[] nums, int t){
}
//通关判断计算t的范围用来定义left和right的值 [l,r]
int left = l;
int right = r;
while (left < right) {
  int mid = left + (right - left) / 2;
  while (left < right) {
    if (fx(nums, t) < target) { }
    else if (fx(nums, t) > target) { }
    else { } // 相等，推动边界
  }
  return left // 或者right
}
```

在旋转数组中找target, leetcode 153 154

## 2. Sliding Window

Java 中的 Integer 和 String 这种包装类不能直接用 `==` 进行相等判断，而应该使用类的 `equals` 方法

```java
// 大致逻辑 时间复杂度O(N)
int left = 0, right = 0;
while (right < s.size()) {
    // 增大窗口
    window.add(s[right]);
    right++;
    
    while (window needs shrink) {
        // 缩小窗口
        window.remove(s[left]);
        left++;
    }
}
```

```java
/* 滑动窗口算法框架 */
void slidingWindow(string s, string t) {
    Map<Character, Integer> need = new HashMap<>();
    Map<Character, Integer> window = new HashMap<>();
    for (char c : t.toCharArray()) 
        need.put(c, need.getOrDefault(c,0) + 1); //先设置need
    int left = 0, right = 0, count = 0;              
    while (right < s.length()) {
        // c 是将移入窗口的字符
        char c = s[right];
        // 增大窗口
        right++;
        // 进行窗口内数据的一系列更新
        ...
       if (need.constainsKey(c)) {
           window.put(c, window.getOrDefault(c, 0) + 1);
           if (need.get(c).equals(window.get(c))) {
               count ++;
           }
       }

        /*** debug 输出的位置 ***/
        printf("window: ["+left+","+ right+")");
        /********************/
        
        // 判断左侧窗口是否要收缩
        while (window needs shrink) {
            // d 是将移出窗口的字符
            char d = s[left];
            // 缩小窗口
            left++;
            // 进行窗口内数据的一系列更新
            ...
            if (need.containsKey(d)) {
                if (need.get(d).equals(window.get(d))) {
                    count--;
                }
                window.put(d, window.getOrDefault(d, 0) - 1);
            }
        }
    }
}
```

## 3. Reverse Linked List

```java
// 1. 反转整个链表 ListNode head
// 1）递归
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {return head;} //含有0个和1个的情况
        
        ListNode last = reverseList(head.next); //  null <- 2 <- 3 <- 4 <- 5
        //不要跳进递归， 而是弄懂上面的函数会产生什么结果，即翻转了head之后的链表
        
        head.next.next = head; // 1 <- 2 ...
        head.next = null;  // null <- 1 <- 2 <- 3 <- 4 <- 5
        return last;
    }

// 2）常规
    public ListNode reverseList(ListNode head) {
        ListNode pred = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode nextCur = cur.next;
            cur.next = pred;
            pred = cur;
            cur = nextCur;
        }
        return pred;
    }
```

```java
// 2. 翻转链表head的前n个元素
ListNode succ = null; //  添加后驱节点,只在 n == 1时记录一次， 注意是在方法之外
public ListNode reverseN(ListNode head, int n) {
    if (n == 1) {
        succ = head.next; //记录第n+1个节点,即最后反转完n个元素后需要链接的后续链表
        return head;
    }
    ListNode last = reverseN(head.next, n - 1); //递归，翻转head.next开始的n-1个节点
    head.next.next = head; //翻转后的链表最后一个是head.next, 再让其指向head
    
    head.next = succ;   //让反转之后的 head 节点和后面的节点连起来
    return last; //last为翻转后的头节点
}
```

```java
// 3. 翻转链表head的第m到第n个元素
public ListNode reverseBetween(ListNode head, int m, int n) {
	if (m == 1) { //base case
        return reverseN(head, n);
    }
    head.next = reverseBetween(head.next, m - 1, n - 1); //head连接后一位翻转后的内容
    return head;
}
    
```

```java
// 4.每两两翻转链表中的元素
public ListNode swapPairs(ListNode head) {
	if (head == null || head.next == null) {return head;} //base
    ListNode first = head;
    ListNode second = head.next;
    ListNode other = head.next.next;
    
    second.next = first;  //先反转前两个
    first.next = swapPairs(other); //接上剩余后翻转过的链表
    return second;
}
```

## 4. PreSum and Diff

```java
// preSum 前缀和数组，长度需要比原数组大1方便计算. 
// 主要适用的场景是原始数组不会被修改的情况下，频繁查询某个区间的累加和
// 前缀和数组
private int[] prefix;
/* 输入一个数组，构造前缀和 */
public PrefixSum(int[] nums) {
    prefix = new int[nums.length + 1]; // +1
    // 计算 nums 的累加和
    for (int i = 1; i < prefix.length; i++) {  //从1开始，0默认为0便于计算
        prefix[i] = prefix[i - 1] + nums[i - 1];
    }
}
/* 查询闭区间 [i, j] 的累加和 */
public int query(int i, int j) {
    return prefix[j + 1] - prefix[i];
}
```

```java
// diff 差分数组， 长度和原数组一致即可
// 差分数组的主要适用场景是频繁对原始数组的某个区间的元素进行增减

int[] diff = new int[nums.length];
// 1. 构造差分数组 ,原数组已经有差
diff[0] = nums[0];
for (int i = 1; i < nums.length; i++) {
    diff[i] = nums[i] - nums[i - 1];
}
// 2.原数组初始全为0时， diff只要定义即可，默认全为0

// 3. 给闭区间 [i, j] 增加 val（可以是负数）, 可以先对diff进行全部改变， 最终结果用来算res
public void increment(int i, int j, int val) {
    diff[i] += val;
    if (j + 1 < diff.length) {  //最后一个元素也更改，不需要更新
        diff[j + 1] -= val;
    }
}
// 4. 返回结果数组res
public int[] result() {
    int[] res = new int[diff.length];
    // 根据差分数组构造结果数组
    res[0] = diff[0];
    for (int i = 1; i < diff.length; i++) {
        res[i] = res[i - 1] + diff[i];
    }
    return res;
}
```

