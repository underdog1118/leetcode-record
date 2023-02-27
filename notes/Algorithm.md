## **leetcode常见

#### 1) Design class类型

```java
class Function {
    //先在外部定义变量类型
    HashMap<Integer, Integer> map;
    int[] nums;
    Random random;
    public Function() { //构造器 Instructor
        //在构造器内初始化
        map = new HashMap<>();
        nums = new int[100];
        random = new Random();
    }
    public boolean add(int k) { //类里的method
        ...
    }
    ...
}

//调用类时
Function fuc = new Function(); //用构造器定义一个类的instance实例
fuc.add(5); //调用类内部的方法
```

#### 2) Random生成

```java
Random rand = new Random();
int max = ...;
// nextInt(n) 方法在 [0, max) 中生成一个随机整数
int num = rand.nextInt(max);
```



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
while (left <= right){  
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
  int mid = left + (right - left)/2;   //防止overflow
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
//二.寻找左边界（多个相同的target存在于数组nums中时）

/**
当目标元素 target 不存在数组 nums 中时，搜索左侧边界的二分搜索的返回值可以做以下几种解读：

1、返回的这个值是 nums 中大于等于 target 的最小元素索引。
2、返回的这个值是 target 应该插入在 nums 中的索引位置。
3、返回的这个值是 nums 中小于 target 的元素个数。

比如在有序数组 nums = [2,3,5,7] 中搜索 target = 4，搜索左边界的二分算法会返回 2，你带入上面的说法，都是对的。

综上，此招左边界的方法也可以用来找target的右边界 （lc34)：int r = left_bound(nums,target+1)        找target+1的最左侧值，再-1即为target最右边界; 即使target+1不存在，r仍会返回该值应该插入在nums中的index（删去底端的是否存在的判断条件，直接return)
*/
    int left_bound(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] < target){
                left = mid + 1;
            }else if (nums[mid] > target){
                right = mid;
            }else if (nums[mid] == target){
                right = mid; //找左极限， 得到target时候把区间往左边压
            }
        }
        
     //判断target是否存在 nums 中；第1个判断：此时 target 比所有数都大，返回 -1
	 //第2个判断： nums[right] 是否是target
     //** 也可以不写，下面直接return可以得到target应该插入在nums中的索引位置(见顶端)
      if (right == nums.length || nums[right] != target) {
        	return -1;
      }else{
      		return right; //或者left
      }
    }
```

```java
  //三.找最右侧的target
	int right_bound(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] > target){
                right = mid;
            }else if (nums[mid] < target){
                left = mid + 1;
            }else if (nums[mid] == target){
                left = mid + 1;  //找到target时候，把区间往右侧压缩， 找最右侧=target的元素
            }
        }
        //判断索引是否越界和target是否存在, left的取值范围是 [0, nums.length]，但由于我们最后返回的是 left - 1，所以 left 取值为 0 的时候会造成索引越界
        if (left - 1 < 0 || nums[left] != target) { 
            return -1;
        }else{
            return left - 1; //*** left为第一个>target元素，left-1为最后一个<=target元素,即右边界
        }
    }
```

<img src="images/image-20230226175307830.png" alt="image-20230226175307830" style="zoom: 33%;" />

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

#### * Rabin-Karp （extend)

```java
int L;  //数字位数 8333  L=4
int R;  //进制  10进制 R=10
int RL = Math.pow(R, L-1); // R*(L-1) 用于删除首位
// 1.数字末位添加
num = num * R + addVal;  // 8333 * 10 + 5 = 83335
// 2.首位数字删除
num = num - removeVal * RL;  // 8333 - 8 * 10^3 = 333
```

```java
// Rabin-Karp 指纹字符串查找算法
int rabinKarp(String txt, String pat) {
    // 位数
    int L = pat.length();
    // 进制（只考虑 ASCII 编码）
    int R = 256;
    // 取一个比较大的素数作为求模的除数
    long Q = 1658598167;
    // R^(L - 1) 的结果
    long RL = 1;
    for (int i = 1; i <= L - 1; i++) {
        // 计算过程中不断求模，避免溢出  R ^ (L - 1)
        RL = (RL * R) % Q; 
    }
    // 计算模式串的哈希值，时间 O(L)
    long patHash = 0;
    for (int i = 0; i < pat.length(); i++) {
        patHash = (R * patHash + pat.charAt(i)) % Q;
    }
    
    // 滑动窗口中子字符串的哈希值
    long windowHash = 0;
    
    // 滑动窗口代码框架，时间 O(N)
    int left = 0, right = 0;
    while (right < txt.length()) {
        // 扩大窗口，移入字符
        windowHash = ((R * windowHash) % Q + txt.charAt(right)) % Q;
        right++;

        // 当子串的长度达到要求
        if (right - left == L) {
            // 根据哈希值判断是否匹配模式串
            if (windowHash == patHash) {
                // 当前窗口中的子串哈希值等于模式串的哈希值
                // 还需进一步确认窗口子串是否真的和模式串相同，避免哈希冲突
                if (pat.equals(txt.substring(left, right))) {
                    return left;
                }
            }
            // 缩小窗口，移出字符
            windowHash = (windowHash - (txt.charAt(left) * RL) % Q + Q) % Q;
            // X % Q == (X + Q) % Q 是一个模运算法则
            // 因为 windowHash - (txt[left] * RL) % Q 可能是负数
            // 所以额外再加一个 Q，保证 windowHash 不会是负数
            left++;
        }
    }
    // 没有找到模式串
    return -1;
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
// preSum 前缀和数组，长度需要比原数组大1方便计算. （放入一个默认的0初始数据）
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

## 5. nSum

```java
// 2Sum 用hashmap 找 target - nums[i], 不在就把nums[i]存进map
// 3Sum 先排序。 固定一个k， 相向移动双指针 i = k + 1, j = nums.length - 1 直到i < j不成立
// 4Sum 先排序。 固定一个m， 往右移动n = m + 1, 相向移动双指针 i = n + 1, j = nums.length - 1
// 该类问题需要注意去重: if (k > 0 && nums[k] == nums[k-1]) {continue;}
```

## 6. Bucket Sort 桶排序

## 7. Monotonic Stack & Queue

<img src="images/image-20221229023833460.png" alt="image-20221229023833460" style="zoom:20%;" />

```java
//M stack : 从左往右看，找第一个能看到的比自己高的人
//两个循环,但其实是O(n).总共有 n 个元素，每个元素都被 push 入栈了一次，而最多会被 pop 一次，没有任何冗余操作。
int[] nextGreaterElement(int[] nums) {
    int n = nums.length;
    // 存放答案的数组
    int[] res = new int[n];
    Stack<Integer> s = new Stack<>(); 
    // 倒着往栈里放
    for (int i = n - 1; i >= 0; i--) {
        // 判定个子高矮
        while (!s.isEmpty() && s.peek() <= nums[i]) {
            // 矮个起开，反正也被挡着了。。。
            s.pop();
        }
        // nums[i] 身后的更大元素
        res[i] = s.isEmpty() ? -1 : s.peek();
        s.push(nums[i]);
    }
    return res;
}
```

```java
// M Queue
class MonotonicQueue {
// 双链表，支持头部和尾部增删元素 , 也可以用双端队列Deque<Integer> dq = new LinkedList<>();
// 维护其中的元素自尾部到头部单调递增
private LinkedList<Integer> maxq = new LinkedList<>();

// 在尾部添加一个元素 n，维护 maxq 的单调性质
public void push(int n) {
    // 将前面小于自己的元素都删除
    while (!maxq.isEmpty() && maxq.getLast() < n) {
        maxq.pollLast();
    }
    maxq.addLast(n);
}
```

## 

## 8. Traverse binary tree

#### 1) 前序

```java
// 1.前序 Pre-Order
class Solution {
    /* 1 动态规划思路 */
    // 定义：输入一个节点，返回以该节点为根的二叉树的前序遍历结果
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        // 前序遍历结果特点：第一个是根节点的值，接着是左子树，最后是右子树
        res.add(root.val);
        res.addAll(preorderTraversal(root.left));
        res.addAll(preorderTraversal(root.right));
        return res;
    }

    /* 2 回溯算法思路 */
    LinkedList<Integer> res = new LinkedList<>();
    // 返回前序遍历结果
    public List<Integer> preorderTraversal2(TreeNode root) {
        traverse(root);
        return res;
    }
    // 二叉树遍历函数
    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        // 前序遍历位置
        res.add(root.val);
        traverse(root.left);
        traverse(root.right);
    }
}

// 3 迭代，用栈。 遍历顺序：中-左-右， 入栈顺序：中-右-左
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop(); //弹出中节点
            if (node != null) {  
                res.add(node.val);
                stack.push(node.right);  //先放右
                stack.push(node.left);  //再放左，左先弹出
            }   
        }
        return res;
    }
}
```

#### 2）中序

```java
// 2.中序 In-Order
class Solution {
    /* 1 动态规划思路 */
    // 定义：输入一个节点，返回以该节点为根的二叉树的中序遍历结果
    public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        res.addAll(inorderTraversal(root.left));
        res.add(root.val);
        res.addAll(inorderTraversal(root.right));
        return res;
    }

    /* 2 回溯算法思路 */
    LinkedList<Integer> res = new LinkedList<>();

    // 返回前序遍历结果
    public List<Integer> inorderTraversal2(TreeNode root) {
        traverse(root);
        return res;
    }

    // 二叉树遍历函数
    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        // 中序遍历位置
        res.add(root.val);
        traverse(root.right);
    }
}

// 3 迭代。 遍历顺序: 左-中-右 入栈顺序： 左-右
public List<Integer> inorderTraversal(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    List<Integer> res = new LinkedList<>();
    TreeNode curr = root;  //指针
    while (!stack.isEmpty() || curr != null) {
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;  //一直添加直到最左最小的node， 此时curr = null
        }
        curr = stack.pop();
        res.add(curr.val);
        curr = curr.right;
    }
    return res;
}
```

#### 3） 后序

```java
// 3. 后序 Post-Order
class Solution {
    /* 1 动态规划思路 */
    // 定义：输入一个节点，返回以该节点为根的二叉树的后序遍历结果
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        // 后序遍历结果特点：先是左子树，接着是右子树，最后是根节点的值
        res.addAll(postorderTraversal(root.left));
        res.addAll(postorderTraversal(root.right));
        res.add(root.val);
        return res;
    }

    /* 2 回溯算法思路 */
    LinkedList<Integer> res = new LinkedList<>();
    // 返回后序遍历结果
    public List<Integer> postorderTraversal2(TreeNode root) {
        traverse(root);
        return res;
    }
    // 二叉树遍历函数
    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        traverse(root.right);
        // 后序遍历位置
        res.add(root.val);
    }
}

// 3. 迭代。 前序类似，翻转输出。 遍历顺序 左-右-中 入栈顺序：中-左-右 出栈顺序：中-右-左， 最后翻转结果
public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> res = new LinkedList<>();
    Stack<Integer> reverseRes = new Stack<>();  //顺序是左右中，先用中右左接住
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    while (!stack.isEmpty()) {
        TreeNode node = stack.pop(); //弹出中节点
        if (node != null) {  
            reverseRes.push(node.val);
            stack.push(node.left);  //先放左
            stack.push(node.right);  //后方右，先弹出
        }   
    }
    while (!reverseRes.isEmpty()){  //翻转成左右中输出
        res.add(reverseRes.pop());
    }
    return res;

}
```

#### 4） 层次遍历 

```java
// 4. 层次遍历 Level-Order BFS
// 输入一棵二叉树的根节点，层序遍历这棵二叉树
public void levelTraverse(TreeNode root) {
    if (root == null) return;
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);

    // 从上到下遍历二叉树的每一层
    while (!q.isEmpty()) {
        int sz = q.size();
        // 从左到右遍历每一层的每个节点
        for (int i = 0; i < sz; i++) {
            TreeNode cur = q.poll();
            // 将下一层节点放入队列
            if (cur.left != null) {
                q.offer(cur.left);
            }
            if (cur.right != null) {
                q.offer(cur.right);
            }
        }
    }
}
```

```java
// dfs模拟bfs
List<Integer> res = new ArrayList<>();
public List<Integer> levelOrder(TreeNode root) {
    if (root == null) {return res;}
    dfsAsBfs(root, 0); //从depth = 0开始
    return res;
}
public void dfsAsBfs(TreeNode root, int depth) {
    if (root == null) {return;}
    if (depth == res.size()) {  //关键：判断是否为分割点， 此处开始对res的操作
        res.add(root.val);
    }
    
    dfsAsBfs(root.left, depth + 1); //先左再右，能找到从左侧看的所有层的第一个元素
    dfsAsBfs(root.right, depth + 1); //depth++进行下一次递归
    
    // 最后两行可以替换为： 原版的回溯，depth++用完后再-- (其实不用depth--. 这里的depth不会再被用到了)
        depth++;
        recurBfs(root.left, depth);
        recurBfs(root.right, depth);
        //depth--;
    // 如果depth不是该方法的内部参数，而是global变量在外部， 则需要--
    }
}
```

## 9. Compare Tree

```java
//比较两棵树是否相等
public boolean isSameTree(TreeNode n1, TreeNode n2) {
    if (n1 == null || n2 == null) {
        return n1 == n2;   //两个null, true; 一个null, false
    }
   	return n1.val == n2.val && isSameTree(n1.left, n2.left) && isSameTree(n1.right, n2.right);
}

//若比较是否对称, 最后改成
	return n1.val == n2.val && isSymmetric(n1.left, n2.right) && isSymmetric(n1.right,n2.left);
```

## 10) Sort

假定在待排序的记录序列中，存在多个具有相同的关键字的记录，若经过排序，这些记录的相对次序保持不变，即在原序列中，A1=A2，且A1在A2之前，而在排序后的序列中，A1仍在A2之前，则称这种排序算法是稳定的；否则称为不稳定的。

稳定也可以理解为一切皆在掌握中,元素的位置处在你在控制中.而不稳定算法有时就有点碰运气,随机的成分.当两元素相等时它们的位置在排序后可能仍然相同.但也可能不同.是未可知的.

**各排序算法的稳定性：**

1、堆排序、快速排序、希尔排序、直接选择排序**不是稳定**的排序算法；

2、基数排序、冒泡排序、直接插入排序、折半插入排序、归并排序**是稳定**的排序算法。

<img src="images/640" alt="640?wx_fmt=png&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1" style="zoom:60%;" />

#### 1) MergeSort

<img src="images/912_fig4.gif" alt="fig4" style="zoom:50%;" />

```java
// tc : O(N*logN) logN层二叉树，每层N个元素 ; sc : O(N) temp长度和nums一致
class Solution {
    int[] temp;
    public int[] sortArray(int[] nums) {
        temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void mergeSort(int[] nums, int l, int r) {
        if (l == r) {
            return;
        }
        
        int mid = l + (r - l) / 2;
        mergeSort(nums, l, mid);  //左侧排序
        mergeSort(nums, mid + 1, r);  //右侧排序

        int i = l, j = mid + 1;  //双指针归并排序两个有序数组
        int cnt = 0;
        while (i <= mid || j <= r) {
            if (i == mid + 1) {  //左侧已排完，右侧全放进去
                temp[cnt++] = nums[j++];
            } else if (j == r + 1) {
                temp[cnt++] = nums[i++];
            } else if (nums[i] < nums[j]) {  //小的先放
                temp[cnt++] = nums[i++];
            } else {
                temp[cnt++] = nums[j++];
            }
        }

        for (int k = 0; k < r - l + 1; k++) {  //排序完的temp放到nums相对应的位置里
            nums[l + k] = temp[k];
        }
    }
}
```

#### 2) Quick Sort

<img src="images/image-20230225184156312.png" alt="image-20230225184156312" style="zoom:40%;" />

<img src="images/912_fig1.gif" alt="fig1" style="zoom:50%;" />

```java
// 最佳情况： tc - O(NlogN), sc - O(logN)  ；
// 最差情况 ： tc - O(N^2), sc - O(N) , 退化成选择排序
class Solution {
    public int[] sortArray(int[] nums) {
        //shuffle(nums);
        quickSort(nums, 0, nums.length - 1); //左闭右闭
        return nums;    
    }

    public void quickSort(int[] nums, int l, int r) {
        if (l >= r) {  //不需要再排序了
            return;
        }
        int pos = randomPartition(nums, l, r);
        quickSort(nums, l, pos - 1);
        quickSort(nums, pos + 1, r);
    }

    public int randomPartition(int[] nums, int l, int r) {  //代替洗牌算法
         int i = new Random().nextInt(r-l+1) + l;  //随机选取一个[l,r]的数与r交换洗牌， 
         swap(nums, r, i); //交换r和i，这样在partition中 pivot = nums[r] 不再必定是最右侧元素，
        			//而是一个随机的pivot，减少了O(n^2)的可能性，把期望带向O(nlogN)
         return partition(nums, l ,r);  //可以直接和下面一个方法合并成同一个
    }

    public int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int i = l - 1; //左指针
        for (int j = l; j <= r - 1; j++)  {  //右指针
            if (nums[j] < pivot) {  //找到了比pivot小的值，应该往左边放
                i++;              //从index 0开始
                swap(nums, i, j); //交换i处>pivot的值 和 j处<= pivot的值
            }
        }
        swap(nums, i + 1, r);  //此时[l, i]的元素都小于pivot, [i+1, r]的 元素都大于pivot
    // i+1是第一个>=pivot的值，把它和pivot交换，即能让pivot左侧元素都小于它，右侧都大于等于它
        return i + 1;
    }

    public void swap(int[] nums, int i, int j) { //交换2元素
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    
    //洗牌算法, 可以替换randomPartition。 在最早就把整个数组打乱，避免O(n^2)，操作中不用再变
    public void shuffle(int[] nums) {  
        Random rand = new Random();
        int n = nums.length;
        for (int i = 0 ; i < n; i++) {
            // 生成 [i, n - 1] 的随机数
            int r = i + rand.nextInt(n - i);
            swap(nums, i, r);
        }
    }

}
```



#### 3) Selection Sort

```java
// sc : O(N^2)  n+(n-1)+(n-2)+..+1 = 1/2(n^2 + n) ==> n^2;     tc : O(1)  
// 优点：交换次数最少。
// 缺点： 即使输入数据是有序的，「选择排序」依然需要「傻乎乎」地走完所有的流程
public void selectionSort(int[] nums) {
    for (int i = 0; i < nums.length - 1; i++) { //到倒数第二个元素停止。因为已经把最后两个元素进行了比较
        int minIndex = i;
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] < nums[minIndex]) {
                minIndex = j;  //找到i后未排序的元素中最小的元素
            }
        }
        swap(nums, i, minIndex); //选择区间 [i, len - 1] 里最小的元素的索引，交换到下标 i
    }
}
public void swap(int[] nums, int l, int r) {
    int temp = nums[l];
    nums[l] = nums[r];
    nums[r] = temp;
}
```

#### 4) Insert Sort

![img](images/710dd138492c0da4324657033971f3bee0355514f2ab2834756c988a90398cbb-file_1585624920301.gif)

```java
// sc : 最差O(N^2)， 几乎排列完成时/在小区间内执行排序任务的时候，可以转向使用「插入排序， sc接近 O(N)  
// tc : O(1).  

public int[] insertSort(int[] nums) {
    for (int i = 1; i < nums.length; i++) {
        int temp = nums[i];  //暂存的需要插入的元素
        int j = i;
        while (j > 0 && nums[j-1] > temp) {  //左侧有元素比temp大，往右移动元素覆盖
            nums[j] = nums[j-1];
            j--;
        }
        nums[j] = temp;  //插入到合适的地方
    }
    return nums;
}
```

#### 5) Bubble Sort

```java
// sc : 最差O(n^2)  最好O(N),一轮循环后发现顺序正确直接退出 ;  tc : O（1） 原地操作常量
// 1.普通版
public int[] bubbleSort(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
        for (int j = 0; j < nums.length - i - 1; j++){
            if (nums[j] > nums[j+1]) {
                int temp = nums[j];
                nums[j] = nums[j+1];
                nums[j+1] = temp;
            }
        }
    }
    return nums;
}
//2.中途退出最佳情况sc O(N)版本
public int[] bubbleSort2(int[] nums) {
    boolean didSwap;
    for (int i = 0; i < nums.length; i++) {
        didSwap = false;
        for (int j = 0; j < nums.length - i - 1; j++){
            if (nums[j] > nums[j+1]) {
                int temp = nums[j];
                nums[j] = nums[j+1];
                nums[j+1] = temp;
                didSwap = true;  //此轮进行了交换
            }
        }
        if (!didSwap) {  //此轮循环未进行交换，说明顺序正确，直接退出循环
            return nums;
        }
    }
    return nums;
}
```

#### 6) Heap Sort

```java
// tc : O(NlogN) :完全二叉树先构建最大堆，需要大概n/2次下沉，此过程为O(n); 然后再逐个交换堆顶和最后一个元素，需要循环执行N次，每次都需要进行下沉heapift()调整堆需要O(logN)
class Solution {
    public int[] sortArray(int[] nums) {
        //Heap Sort
        int len = nums.length;
        //从len/2-1开始,往前走把所有非叶子节点下沉构造最大堆
        for (int i = len/2 - 1; i>= 0; i--) {
            heapfiy(nums, len, i);  //长度是len, 要下沉的元素index是i
        }
        //交换堆顶最大值和当前最后一个元素，固定最后一个元素（原最大值）并对堆顶元素进行下沉
        for (int i = len - 1; i > 0; i--) { //堆顶元素只剩一个不需要再操作(i=0)
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            heapfiy(nums, i, 0); //长度为i,每次下沉都-1； index为0
        }
        return nums;
    }

    public void heapfiy(int[] arr, int len, int i) {
        int max = i;
        int left = i * 2 + 1; //左子树idx （index从0开始的计算方式）
        int right = i * 2 + 2; //右子树idx
        if (left < len && arr[left] > arr[max]) { //在范围内且大于其parent
            max = left;
        }
        if (right < len && arr[right] > arr[max]) {
            max = right;
        }
        //当索引i处的子树值大于它的值时，不满足最大堆要求, 交换i和max； 再递归调整....
        if (max != i) {
            int temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;
            heapfiy(arr, len, max); //需要递归调整以最大值为根节点的子树，因为发生了交换
        }
    }
}
```



#### 7) Counting Sort

```java
//计数排序 tc : O(n) = O(n+k), n是数组长度，k是数组中最大值和最小值之差 ; sc: O(n) res
class Solution {
    private int[] res;
    public int[] sortArray(int[] nums) {
        //计数排序
        res = new int[nums.length];
        countingSort(nums);
        return res;
    }

    public void countingSort(int[] arr) {
        HashMap<Integer,Integer> counts = new HashMap<>();
        int min = arr[0], max = arr[0];
        //找到最大值和最小值
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
            // 按照key : 元素 ， val : 出现频率放入map中
            counts.put(arr[i], counts.getOrDefault(arr[i], 0) + 1);
        }

        int index = 0;
        for (int i = min; i <= max; i++) { //从min到max把元素从小到大按各自频率放入res中
            while (counts.getOrDefault(i, 0) != 0) {  //每放入一次，index++, 频率--
                res[index++] = i;
                counts.put(i, counts.get(i) - 1);
            }
        }
    }
}
```



## 11) LCA (lowest common ancestor)

**如果一个节点能够在它的左右子树中分别找到 `p` 和 `q`，则该节点为 `LCA` 节点**。

```java
// 1. 找binary tree的lca
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {return null;}
        if (root.val == p.val || root.val == q.val) { //前序遍历
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (right != null && left != null) {   //1. root的左右子树分别能找到p和q/q和p
            return root;
        }
        // 2.left没找到去right找，如果left和right有一侧是null，
        // lca必定是另一侧返回的root （前提条件是p和q必定存在于树中）
        // 3.都为null则为null
        return left != null ? left : right; 
    }
```

```java
// 2.找bst的Lca
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int val1 = Math.min(p.val, q.val);
        int val2 = Math.max(p.val, q.val);
        return find(root, val1, val2);
    }

    public TreeNode find(TreeNode root,int v1, int v2) {
        if (root == null) {return null;}
        // if (root.val == v1 || root.val == v2) {
        //     return root; //找到直接返回
        // }
        // if (root.val > v1 && root.val < v2) { //左右子树分别找到，符合定义直接返回root
        //     return root;}
        if (root.val < v1) { //只需要去右边找到v1/v2即为lca
            return find(root.right, v1, v2);
        } else if (root.val > v2) { //只需要去左边找到v1/v2即为lca
            return find(root.left, v1, v2);
        }
        return root; //合并了上面的两步 v1 <= root.val <= v2
    }
```

## 12）top K

对于 topk 问题：==最大堆求topk小，最小堆求 topk 大==。

topk小：构建一个 k 个数的最大堆，当读取的数小于根节点时，替换根节点，重新塑造最大堆
topk大：构建一个 k 个数的最小堆，当读取的数大于根节点时，替换根节点，重新塑造最小堆

```java
public int topKth(int[] nums, int k) {
    PriorityQueue<Integer> heap = new PriorityQueue<>(); //默认最小堆
    for (int n : nums) {
        heap.add(n);
        if (heap.size() > k) {
            heap.poll();  //始终维护堆中有k个较大的元素
        }
    }
    return heap.peek();  //最后top元素即为Kth largest
}
```

