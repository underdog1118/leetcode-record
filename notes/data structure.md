# 一. Array

## 1. 集合，列表，数组

| 集合：由一个或多个确定的元素所构成的整体                     | 元素类型不一定相同， 元素没有顺序 |
| :----------------------------------------------------------- | --------------------------------- |
| 列表：一种数据项构成的有限序列，即按照一定的线性顺序，排列而成的数据项的集合   (==数组和链表==) | 具有顺序，且长度是可变            |
| 数组： 列表的实现方式之一                                    | 与列表区别： 有索引 Index         |

![image-20221010164152859](images/image-20221010164152859.png)





## 2. 数组的操作

### 2.1 读取元素

通过访问索引的方式来读取，时间复杂度为O(1)

### 2.2 查找元素

##### 1）Linear Search

遍历数组，时间复杂度为O(N)

##### 2）Binary Search

### 2.3 插入元素

用链表 or

```java
for(int i = k; i > ...; i--){
  a[i+1] = a[i];
}
```

### 2.4 删除元素

需要1 + （n - 1) 步， 1为删除，n-1为移动其余元素。 O(N) N为array.length

考虑快慢双指针方法

##### 1)删除末尾元素

length --

##### 2)删除首位元素

```java
int[] nums = new int[]{};
for(int i = 1; i < nums.length; i++) {
		nums[i-1] = nums[i];
}
length --;
```

##### 3)删除任意位置

```java
int[] nums = new int[]{};
for (int i = m; i < nums.length; i++) {
  	nums[i-1] = nums[i];
}
length--;
```

### 2.5 In-Place Operations

It is this technique of working directly in the input Array, and *not* creating a new Array, that we call **in-place**. 将space complexity从O(N)变成了O(1).

双指针（快慢指针，左右指针）, 滑动窗口（left指针在后，right指针在前）

### 2.6 比较是否相等

Arrays.equals  (int[ ] a, int[ ] b)

### 3. 字符串

![image-20221011124842814](images/image-20221011124842814.png)

##### 3.1 比较Compare

1. ==   在java中最好不用，因为会被用来比较两个对象是否为同一个对象，而不是是否相等

2. string.equals( )

##### 3.2 可变性

C++ 可变。 Java中不可变Immutable

##### 3.3 添加

直接用 string += "..."/  Java中很慢，O（n^2)

Solution: 

```java
//1.把string转变成char array
s = "xxxxx";
char[ ] chars = s.toCharArray( );
...
return new String(chars)  //把char数组变成String返回
return new String(chars, left, right)  // 把chars里index（left,right)作为string返回
```

```java
//2. StringBuilder
StringBuilder str = new StringBuilder( );  //一个动态变化的String
str.append("...");
String s = str.toString(); //转换成String输出
```

##### 3.4 常用api

```java
String str = "abc";
String s = "5";
str.length(); //长度
str.charAt(int index)//获取索引处的字符
str.toCharArray() //将字符串转换为字符数组返回
str.substring(int beginIndex. int endIndex)//根据索引截取字符串，左闭右开
str.replace(oldtarget, newreplacement) //使用新值把字符串的旧值替换掉
str.split(String regex) //根据传入的规则切割字符串，得到字符串数组返回St
str.contains("a") //判断是否含有某个字符串， 不能输入'a'字符形式
int num = Integer.valueOf(s);  // num = 5, 把数字字符串转变为对应的数字
```

### 4. ArrayList

```java
//需要返回一个长度不确定的数组时, 动态数组
ArrayList<Integer> res = new ArrayList<>();

//需要一个数组，其对象是ArrayList<Integer>，即index对应的value可能有多个int组成的集合
ArrayList<Integer>[] lst = new ArrayList[length];
//此时不是用int[] lst = new int[length]， 因为它的index只能对应1个int

res.add(Element e)； //增加指定元素到列表尾部
res.addAll(ArrayList aList);  //将指定集合中的所有元素添加到本集合中
res.clear();	//从列表中删除所有元素.
res.remove(int index);	//删除列表中指定位置的元素.
res.get(int index);		//获取列表中指定位置处的元素.
res.contains(Object o); //如果列表包含指定元素，返回true
res.isEmpty() //返回true表示链表中没有任何元素
res.size()  //返回列表长度（列表包含元素的个数）
```



# 二. LinkedList

![image-20221108101136574](images/image-20221108101136574.png)

### 1. 单链表

<img src="images/image-20221106202017751.png" alt="image-20221106202017751" style="zoom: 50%;" />

所有节点按照顺序排列。 若要查询某个元素，只能从头节点（head node) 开始逐个遍历。 O(n) 。

使用head note代表整个list。一般定义头节点为 哨兵节点（==Sentinel==) ，可以简化插入和删除，不包含任何数据,

很多时候偶操作链表时头节点的操作和剩余节点的操作方式不同，添加Sentinel可以使所有操作同步，返回Sentinel.next



#### 1）add

O(1) time . 不需要移动其他元素

```java
// 如要在 index 处插入 val
ListNode pred = head;
for (int i = 0; i < index； i++) {
    pred = pred.next;   //找到index-1即为 predecessor
}
size ++; //添加一个节点
ListNode toAdd = new ListNode(val); //定义添加节点
toAdd.next = pred.next;
pred.next = toAdd;
```

<img src="images/image-20221106203252464.png" alt="image-20221106203252464" style="zoom:50%;" />

#### 2）delete

用cur找next方便，找prev需要从头遍历， time O(N),  space O(1)

```java
// 删除 index 处的节点
ListNode cur = head;
for(int i = 0; i < index; i++) {
    cur = cur.next;
}
size--;
cur.next = cur.next.nextt
```

<img src="images/image-20221106210538619.png" alt="image-20221106210538619" style="zoom:50%;" />

若要删除head node, 只需要将第二个node赋予成head. 因为head node可以代表整个list

#### 3)    get

查找的效率比数组低，因为需要从头便利，  O（N)

```java
// 查询 index 处的value
ListNode cur = head;
for (int i = 0; i <= index; i++) {
    cur = cur.next;
}
return cur.val;
```



### 2. 双链表

<img src="images/image-20221106202035099.png" alt="image-20221106202035099" style="zoom:50%;" />

```java
//初始化双链表
class DLL {
    int size;
    ListNode head, tail;
    public DLL() {
        size = 0;
        head = new ListNode(0);
        tail = new ListNode(0);
        head.next = tail;
        tail.prev = head;       
    }
}
```



#### 1）add

```java
//找到需要添加val位置前面的pred和后面的succ, 二者相邻
ListNode pred, succ;  //predecessor 和 successor
if (index < size - index) { 	// index离左边近， 从左往右遍历
    pred = head;
    for (int i = 0; i < index; i++) { pred = pred.next; }
    succ = pred.next;
}else {
    succ = tail;
    for (int i = size - 1; i >= index; i--) { succ = succ.prev; }
    pred = succ.prev;
}
size++; //添加新位置
ListNode toAdd = new ListNode(val); //新节点
toAdd.prev = pred;
toAdd.next = succ;
pred.next = toAdd;
succ.prev = toAdd;  //四个重要操作， 链接新节点
```

#### 2）delete

```java
//找到要删除节点index前后pred和succ。 pred, index, succ
ListNode prev, succ;
if (index < size - index) {
    pred = head;
    for (int i = 0; i < index; i++) { pred = pred.next; }
    succ = pred.next.next; //succ在pred后两格
}else {
    succ = tail;
    for (int i = size - 1; i > index; i--) { succ = succ.prev;} //注意此刻i > index 无等号
    pred = succ.prev.prev;
}
size--; //节点减1
pred.next = succ;
succ.prev = pred;  //重要的两步
```

#### 3）get

```java
//还是判断index离哪侧近
ListNode cur;
if (index < size - index) { //从左边开始遍历
    cur = head;
    for (int i = 0; i <= index; i++) { cur = cur.next;}
}else {
    cur = tail;
    for (int i = size - 1; i >= index; i--) { cur = cur.prev;}
}
return cur.val;
```



#### 4） reverse

```java
//翻转整个链表head
ListNode pred = null; 
ListNode cur = head; //操作CUR，不影响HEAD
while (cur != null) {
    ListNode nextCur = cur.next;
    cur.next = pred;
    pred = cur;
    cur = nextCur;
}
```



### 3. 循环链表

<img src="images/image-20221110011859652.png" alt="image-20221110011859652" style="zoom: 15%;" />

### 4. 性能分析

<img src="images/image-20221110012937649.png" alt="image-20221110012937649" style="zoom: 33%;" />

### 5. 定义链表

```java
// Java
public class ListNote {
    int val;  //结点的值
    ListNote next; //下一个结点
    ListNote prev; //双链表 1 value + 2 links 分别指向前后nodes
        
    public ListNote() { } // 1. 无参构造器
    
    public ListNote(int val) {
        this.val = val;   // 2.一个参数的有参构造器
    }
    
    public ListNote(int val, ListNote next) {
        this.val = val;
        this.next = next;   // 3. 两个参数
    }
}
```

# 三. Hash Table

### 1.  HashSet

a `set` data structure to store `no repeated values`.  没有重复

通常用于检查一个value是否存在

```java
public class Main {
    public static void main(String[] args) {
        // 1. initialize the hash set
        Set<Integer> hashSet = new HashSet<>();     
        // 2. add a new key
        hashSet.add(3);
        hashSet.add(2);
        hashSet.add(1);
        // 3. remove the key
        hashSet.remove(2);        
        // 4. check if the key is in the hash set
        if (!hashSet.contains(2)) {
            System.out.println("Key 2 is not in the hash set.");
        }
        // 5. get the size of the hash set
        System.out.println("The size of has set is: " + hashSet.size());     
        // 6. iterate the hash set
        for (Integer i : hashSet) {
            System.out.print(i + " ");
        }
        System.out.println("are in the hash set.");
        // 7. clear the hash set
        hashSet.clear();
        // 8. check if the hash set is empty
        if (hashSet.isEmpty()) {
            System.out.println("hash set is empty now!");
        }
    }
}
```



### 2. HashMap

a `map` data structure to store `(key, value)` pairs.

**当我们遇到了要快速判断一个元素是否出现集合里的时候，就要考虑哈希法**。

但是哈希法也是**牺牲了空间换取了时间**，因为我们要使用额外的数组，set或者是map来存放数据，才能实现快速的查找。

如果在做面试题目的时候遇到需要判断一个元素是否出现过的场景也应该第一时间想到哈希法！

```java
public class Main {
    public static void main(String[] args) {
        // 1. initialize a hash map
        Map<Integer, Integer> hashmap = new HashMap<>();
        // 2. insert a new (key, value) pair
        hashmap.putIfAbsent(0, 0);
        hashmap.putIfAbsent(2, 3);
        // 3. insert a new (key, value) pair or update the value of existed key
        hashmap.put(1, 1);
        hashmap.put(1, 2);
        // 4. get the value of specific key
        System.out.println("The value of key 1 is: " + hashmap.get(1));
        // 5. delete a key
        hashmap.remove(2);
        // 6. check if a key is in the hash map
        if (!hashmap.containsKey(2)) {
            System.out.println("Key 2 is not in the hash map.");
        }
        // 7. get the size of the hash map
        System.out.println("The size of hash map is: " + hashmap.size()); 
        // 8. iterate the hash map
        for (Map.Entry<Integer, Integer> entry : hashmap.entrySet()) {
            System.out.print("(" + entry.getKey() + "," + entry.getValue() + ") ");
        }
        System.out.println("are in the hash map.");
        // 9. clear the hash map
        hashmap.clear();
        // 10. check if the hash map is empty
        if (hashmap.isEmpty()) {
            System.out.println("hash map is empty now!");
        }
    }
}
```

#### 1) Design the key

<img src="images/image-20221218004338997.png" alt="image-20221218004338997" style="zoom: 52%;" />

<img src="images/image-20221218004406956.png" alt="image-20221218004406956" style="zoom: 50%;" />

数独游戏9 x 9大方块中有9个3 x 3个小方块

# 四. Queue & Stack

### 1. Queue

==First-in-First-out==

<img src="images/image-20221222221002524.png" alt="image-20221222221002524" style="zoom:50%;" />

```java
public class Main {
    public static void main(String[] args) {
        // 1. Initialize a queue.
        Queue<Integer> q = new LinkedList();
        // 2. Get the first element - return null if queue is empty.
        System.out.println("The first element is: " + q.peek());
        // 3. Push new element.
        q.offer(5);
        q.offer(13);
        q.offer(8);
        q.offer(6);
        // 4. Pop an element.
        q.poll();
        // 5. Get the first element.
        System.out.println("The first element is: " + q.peek());
        // 7. Get the size of the queue.
        System.out.println("The size is: " + q.size());
    }
}
```



#### 1.1） Deque 双端队列 Java

|                    | Queue                  | Deque                           |
| :----------------- | :--------------------- | ------------------------------- |
| 添加元素到队尾     | add(E e) / offer(E e)  | addLast(E e) / offerLast(E e)   |
| 取队首元素并删除   | E remove() / E poll()  | E removeFirst() / E pollFirst() |
| 取队首元素但不删除 | E element() / E peek() | E getFirst() / E peekFirst()    |
| 添加元素到队首     | 无                     | addFirst(E e) / offerFirst(E e) |
| 取队尾元素并删除   | 无                     | E removeLast() / E pollLast()   |
| 取队尾元素但不删除 | 无                     | E getLast() / E peekLast()      |



### 2. Stack

==Last-in-First-out==

<img src="images/image-20221225163036799.png" alt="image-20221225163036799" style="zoom:50%;" />

```java
public class Main {
    public static void main(String[] args) {
        // 1. Initialize a stack.
        Stack<Integer> s = new Stack<>();
        // 2. Push new element.
        s.push(5);
        s.push(13);
        s.push(8);
        s.push(6);
        // 3. Check if stack is empty.
        if (s.empty() == true) {
            System.out.println("Stack is empty!");
            return;
        }
        // 4. Pop an element.
        s.pop();
        // 5. Get the top element.
        System.out.println("The top element is: " + s.peek());
        // 6. Get the size of the stack.
        System.out.println("The size is: " + s.size());
    }
}
```



# 五. Binary Tree

### 1) DFS : depth-first-search 深度优先遍历

**这里前中后，其实指的就是中间节点的遍历顺序**，只要大家记住 前中后序指的就是中间节点的位置就可以了。

看如下中间节点的顺序，就可以发现，中间节点的顺序就是所谓的遍历方式。 递归/迭代

- 前序遍历：中左右
- 中序遍历：左中右
- 后序遍历：左右中

<img src="images/image-20230104155808279.png" alt="image-20230104155808279" style="zoom:40%;" />

### 2）BFS: breadth-first-search 广度优先遍历

层次遍历（迭代）一般用队列来实现

