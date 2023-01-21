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

#### 2) List<List<...>>

```java
//需要返回List<List<String>>时， 意为以字符串数组组成的数组
// 1. 用map.vaules()放在ArrayList里返回 。  lc : 49/249
HashMap<String, List<String>> map = new HashMap<>(); //可以这样定义map
for (String s : strings) {
    String newS = convert(s);  //转变
    map.putIfAbsent(newS, new ArrayList()); //空则放入一个ArrayList初始化
    map.get(newS).add(s);  //把s归类放到对应的newS-key的数组ArrayList-value中去
}
return new ArrayList(map.values()); //把map值全输出并放在AL中，即是要求的返回模式
//定义一个方法convert把String转换成某一种统一格式， 一般可以用字符做差的方法

// 2.定义一个相同格式的res, 然后返回  lc : 3sum/4sum
List<List<String>> res = new ArrayList<>();
//直接添加3次
res.add("ab"); 
res.add("cd"); 
res.add("ef"); 
//或者一次性添加
res.add(new ArrayList<String>(Arrays.asList("ab", "cd", "ef")));
//只添加一个
res.add(new ArrayList("ab"));
res.add(new ArrayList<Integer>());
//添加res指定index处元素
res.get(index).add(100);
return res;
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

