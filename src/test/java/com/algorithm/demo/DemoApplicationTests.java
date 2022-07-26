package com.algorithm.demo;

import com.algorithm.demo.classUtil.Digraph;
import com.algorithm.demo.classUtil.Node;
import com.algorithm.demo.classUtil.RedBlackNode;
import com.algorithm.demo.classUtil.SymbolNode;
import com.algorithm.demo.structDemo.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Queue;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }
    @Test
    void myArrayTest()
    {
        MyArray<Integer> myArray = new MyArray<>(5);
        myArray.insertEnd(11);
        myArray.insertEnd(22);
        myArray.insertEnd(33);
        myArray.insertEnd(44);
        myArray.showEle();

        myArray.insertEnd(88);
        myArray.insertEnd(99);
        myArray.showEle();

        myArray.remove(6);
        myArray.remove(1);
        myArray.showEle();
        System.out.println("数组是否为空："+myArray.isEmpty());
        myArray.insert(2,34);
        myArray.showEle();
        System.out.println("数组索引2的值："+myArray.get(2));
        System.out.println("数值88在索引的位置："+myArray.indexOf(88));
        myArray.clear();
        myArray.showEle();
        System.out.println("数组是否为空："+myArray.isEmpty());
    }

    @Test
    void mySingleLinkTest()
    {
        Node five = new Node(5,null);
        Node four = new Node(4,five);
        Node three = new Node(3,four);
        Node two = new Node(2,three);
        Node one = new Node(1,two);

        MySingleLink<Integer> mySingleLink = new  MySingleLink<Integer>();
        mySingleLink.getHead().next = one;
        mySingleLink.showLink();

        System.out.println("isEmpty方法:"+mySingleLink.isEmpty());
        System.out.println("length方法:"+mySingleLink.getLength());
        System.out.println("get方法 索引4:"+mySingleLink.get(4));
        mySingleLink.insert(2,44);
        mySingleLink.showLink();
        mySingleLink.insertEnd(99);
        mySingleLink.showLink();
        System.out.println("remove方法 第3个数值:");
        mySingleLink.remove(3);
        mySingleLink.showLink();
        System.out.println("indexOf方法:"+mySingleLink.indexOf(99));
        mySingleLink.showLink();
        mySingleLink.reserve(one);
        mySingleLink.showLink();
    }

    @Test
    void MyDoubleLinkTest()
    {
        MyDoubleLink<String> myDoubleLink = new MyDoubleLink<String>();
        myDoubleLink.insertEnd("zhangsan");
        myDoubleLink.insertEnd("lisi");
        myDoubleLink.insertEnd("wangwu");
        showElement(myDoubleLink);
        System.out.println("getFirstDoubleNode:"+myDoubleLink.getFirstDoubleNode());
        System.out.println("getLastDoubleNode:"+myDoubleLink.getLastDoubleNode());
        System.out.println("remove index 2:");
        myDoubleLink.remove(2);
        showElement(myDoubleLink);
        System.out.println("insertEnd  nanliu:");
        myDoubleLink.insertEnd("nanlie");
        showElement(myDoubleLink);
        System.out.println("insert keqi:" );
        myDoubleLink.insert(2,"keqi");
        showElement(myDoubleLink);
        System.out.println("get index_1:" + myDoubleLink.get(1));
        System.out.println("getLength:"+ myDoubleLink.getLength());
        showElement(myDoubleLink);
        System.out.println("indexOf:"+ myDoubleLink.indexOf("nanlie"));
        System.out.println("clear:");
        myDoubleLink.clear();
        System.out.println("isEmpty:"+myDoubleLink.isEmpty());

    }

    @Test
    void myStackTest()
    {
        MyStack<Integer> myStack = new MyStack<>();
        myStack.push(11);
        myStack.push(33);
        showElement(myStack);
        System.out.println("size:"+myStack.size());
        System.out.println("isEmpty:"+myStack.isEmpty());
        myStack.pop();
        myStack.pop();
        System.out.println("size:"+myStack.size());
        System.out.println("isEmpty:"+myStack.isEmpty());
    }

    @Test
    void myQueueTest()
    {
        MyQueue<Integer> myQueue = new MyQueue<Integer>();
        myQueue.enqueue(21);
        myQueue.enqueue(41);
        myQueue.enqueue(31);
        showElement(myQueue);
        myQueue.dequeue();
        myQueue.enqueue(55);
        showElement(myQueue);
        System.out.println("size:"+myQueue.size());
        System.out.println("isEmpty:"+myQueue.isEmpty());

        for (Integer i : myQueue)
        {
            System.out.print(i+" ");
        }
    }

    @Test
    void graphTest()
    {
        Graph graph = new Graph(7);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(0,5);
        graph.addEdge(0,6);
        graph.addEdge(3,5);
        graph.addEdge(3,4);
        graph.addEdge(5,4);
        graph.addEdge(4,6);
        System.out.println("E:"+graph.E);
        for (int i = 0 ; i < graph.V ; i++)
        {
            System.out.print("queue["+i+"]:");
            showElement(graph.adj(i));
        }
    }

    @Test
    void depthFirstSearchTest()
    {
        Graph graph = new Graph(13);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(0,5);
        graph.addEdge(0,6);
        graph.addEdge(3,5);
        graph.addEdge(3,4);
        graph.addEdge(5,4);
        graph.addEdge(4,6);

        graph.addEdge(7,8);

        graph.addEdge(9,10);
        graph.addEdge(9,11);
        graph.addEdge(9,12);
        graph.addEdge(11,12);

        DepthFirstSearch depthFirstSearch = new DepthFirstSearch(graph);
      depthFirstSearch.dfs(graph,1);

//        depthFirstSearch.lfs(graph,6);

        depthFirstSearch.showEle(graph);
    }


    @Test
     void mySymbolTableTest()
    {
       SymbolTable symbolTable = new SymbolTable();
       symbolTable.put(1,"zhangsan");
       symbolTable.put(2,"lisi");
       symbolTable.put(3,"wangwu");
       symbolTable.showEle();

       System.out.println("get:"+symbolTable.get(3));
       System.out.println("put:");
       symbolTable.put(55,"keqi");
       symbolTable.showEle();
       System.out.println("delete:");
       symbolTable.delete(2);
       symbolTable.showEle();
       System.out.println("size:"+symbolTable.size());

    }

    @Test
     void myBinaryTree()
    {
        BinaryTree<Integer,String> binaryTree = new BinaryTree<>();
        makeData(binaryTree);
        binaryTree.showEle(binaryTree.getRoot());

        String value = binaryTree.get(10);
        System.out.println("结点10的value:"+value);
        System.out.println("结点size:"+binaryTree.size());
        System.out.println("最小结点:"+ binaryTree.findMinNode(binaryTree.getRoot()).key);
        binaryTree.delete(binaryTree.getRoot(),10);
        binaryTree.showEle(binaryTree.getRoot());
    }

    @Test
    void myForeachTreeTest()
    {
        BinaryTree<Integer,String> binaryTree = new BinaryTree<>();
        makeData(binaryTree);
        binaryTree.showEle(binaryTree.getRoot());
        ForeachTree<Integer> foreachTree = new ForeachTree<Integer>();
        foreachTree.tree = binaryTree.getRoot();

 //      Queue<Integer> queue = foreachTree.preRrgodic();

      Queue<Integer> queue = foreachTree.midRrgodic();

 //       Queue<Integer> queue = foreachTree.lastRrgodic();
        for(Integer i : queue)
        {
            System.out.print(i+",");
        }
        System.out.println();
       System.out.println("长度:"+foreachTree.depth(binaryTree.getRoot()));
    }

    @Test
     void HeapTest()
    {
       Heap<Integer> heap = new Heap<>(15);
        heap.insert(70);
        heap.insert(30);
        heap.insert(44);
        heap.insert(35);
        heap.insert(88);
        heap.insert(25);
        heap.insert(10);
        heap.insert(45);
        heap.insert(50);
        heap.insert(60);
        heap.delMax();
        heap.insert(55);
        heap.insert(66);

        for (int i=0;i<heap.N;i++)
        {
            System.out.println("index:"+i+",value:"+ heap.get(i));
        }
        System.out.println("=====================");
        List<Integer> list = heap.heapSort();
        System.out.println(list.toString());
    }

    @Test
    void MixPriorityQueueTest()
    {
        MinPriorityQueue<Integer> minPriorityQueue = new MinPriorityQueue<>(20);
        minPriorityQueue.insert(30);
        minPriorityQueue.insert(20);
        minPriorityQueue.insert(50);
        minPriorityQueue.insert(60);
        minPriorityQueue.insert(10);
        minPriorityQueue.insert(6);
        minPriorityQueue.insert(15);
        minPriorityQueue.delMin();
        minPriorityQueue.insert(1);
        minPriorityQueue.insert(25);
        for (int i=1;i<=minPriorityQueue.N;i++)
        {
            System.out.println("index:"+i+",value:"+ minPriorityQueue.get(i));
        }
    }

    @Test
    void RedBlackTreeTest()
    {
        RedBlackTree<Integer,String> redBlackTree = new RedBlackTree<>();
        redBlackTree.put(50,"");
        redBlackTree.put(40,"");
        redBlackTree.put(60,"");
        redBlackTree.put(55,"");
        redBlackTree.put(77,"");
        redBlackTree.put(30,"");
        redBlackTree.put(45,"");
        redBlackTree.put(47,"111");
        redBlackTree.showEle(redBlackTree.getRoot());
        System.out.println(redBlackTree.get(48));

    }

    <T> void  showElement(Iterable<T> t)
    {
        for (T s :t)
        {
            System.out.print(s+" ");
        }
        System.out.println();
    }

    void makeData(BinaryTree binaryTree)
    {
        binaryTree.put(20,"a");
        binaryTree.put(10,"b");
        binaryTree.put(25,"c");
        binaryTree.put(8,"c");
        binaryTree.put(16,"c");
        binaryTree.put(23,"c");
        binaryTree.put(26,"c");
        binaryTree.put(6,"c");
        binaryTree.put(9,"c");
        binaryTree.put(14,"c");
        binaryTree.put(17,"c");
        binaryTree.put(19,"c");
        binaryTree.put(21,"c");
        binaryTree.put(27,"c");
    }

    @Test
    void UFTest()
    {
        UF uf = new UF(10);
        uf.union(0,1);
        uf.union(0,4);
        uf.union(2,8);
        uf.union(3,9);
        uf.union(9,6);
        uf.showEle();
        System.out.println("group:"+uf.count);
        System.out.println("connect:"+uf.connected(1,4));
        System.out.println("connect:"+uf.connected(3,9));
        System.out.println("connect:"+uf.connected(8,4));
    }

    @Test
    void UFTreeTest()
    {
        UF_Tree uf_tree = new UF_Tree(10,false);
        uf_tree.union(0,1);
        uf_tree.union(1,3);
        uf_tree.union(3,5);
        uf_tree.showEle();

        System.out.println(uf_tree.find(0));
    }

    @Test
    void UFTreeWeiTest()
    {
        UF_Tree uf_tree = new UF_Tree(7,true);
        uf_tree.union(0,1);
        uf_tree.union(1,2);
        uf_tree.union(2,3);
        uf_tree.union(4,3);

        uf_tree.union(5,6);

        uf_tree.union(6,3);
        System.out.println("count:"+uf_tree.count);
        uf_tree.showEle();
        System.out.println("==========================");
        uf_tree.showNumEle();

    }

    @Test
    void directedCycleTest()
    {
        Digraph d = new Digraph(5);

        d.addEdge(1,2);
        d.addEdge(2,3);
        d.addEdge(3,4);
        d.addEdge(3,5);
        d.addEdge(4,2);
        DirectedCycle directedCycle = new DirectedCycle(d);

        System.out.println("cycle is " + directedCycle.hasCycle());
    }

    @Test
    void diguiTest()
    {
       System.out.println(takeFun(10));
    }

    int takeFun(int i)
    {
        if(i == 1)
        {
            return 1;
        }
        System.out.println("i:"+i);
        int temp = takeFun(i-1) + i;
        System.out.println("takeFun("+i+")");
        return temp;
    }


}
