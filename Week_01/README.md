# Week_01 学习笔记
## 如何高效学习
1.  重复观看培训课程，强化对知识点，加深记忆
2.  重复刷题，每个题目保证最少刷5遍，不死磕，敢于硬性记忆代码并理解
3.  Leetcode日常刷题，看高票&高质量题解

##  数据结构和数据结构的总揽
### 精通一个领域三步骤
1.  Chunk it up 切碎知识点
2.  Deliberate practicing 刻意练习
3.  Feedback 反馈

### 数据结构
1.  一纬数据结构   

   a. Array 数组,LinkedList 链表

   b. stack 栈(FILO)，queue 队列(FIFO)，Dequeue 双端队列，Set 集合，Map 映射

2.  二维数据结构   
   a. Tree 树,Graph 图
3.  特殊数据结构
   a. BloomFilter,Bitwise,LRU Cache,



## 课后作业

### Queue
在java定义中Queue是一个接口，主要定义了以下核心函数  
1. boolean add(E e); 向队列添加元素，如果添加失败抛异常
1. boolean offer(E e);向队列添加元素，如果添加失败返回false
1. E remove(); 移除队列头元素，如果为空抛异常
1. E poll(); 移除队列头元素，如果为空返回Null
1. E element(); 返回队列头元素，如果为空抛异常
1. E peek(); 返回队列头元素，如果为空返回Null
AbstractQueue是其实现的抽象类

### PriorityQueue
PriorityQueue集成子AbstractQueue，主要实现实现了平衡二叉堆
