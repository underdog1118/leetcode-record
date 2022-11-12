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

##### 2)Binary Search

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
return new String(chars)
```

```java
//2. StringBuilder
StringBuilder str = new StringBuilder( );
str.append("...");
String s = str.toString();

```

##### 3.4 常用api

```java
String str = "abc";
str.length(); //长度
str.charAt(int index)//获取索引处的字符
str.toCharArray() //将字符串转换为字符数组返回
str.substring(int beginIndex. int endIndex)//根据索引截取字符串，左闭右开
str.replace(oldtarget, newreplacement) //使用新值把字符串的旧值替换掉
str.split(String regex) //根据传入的规则切割字符串，得到字符串数组返回St
```



# 二. LinkedList

![image-20221108101136574](images/image-20221108101136574.png)

### 1. 单链表

<img src="images/image-20221106202017751.png" alt="image-20221106202017751" style="zoom: 50%;" />

所有节点按照顺序排列。 若要查询某个元素，只能从头节点（head node) 开始逐个遍历。 O(n) 。

使用head note代表整个list。一般定义头节点为 哨兵节点（==Sentinel==) ，可以简化插入和删除，不包含任何数据



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

#### 3) get

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



### 3. 循环链表

<img src="images/image-20221110011859652.png" alt="image-20221110011859652" style="zoom: 15%;" />

### 4. 性能分析

<img src="images/image-20221110012937649.png" alt="image-20221110012937649" style="zoom: 33%;" />

##### 5. 定义链表

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

