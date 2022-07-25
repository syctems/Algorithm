package com.algorithm.demo.structDemo;

import com.algorithm.demo.classUtil.Node;

import java.util.Iterator;

public class MySingleLink<T> implements Iterable<T> {

    private int N;

    private Node head;

    public MySingleLink()
    {
        this.head = new Node(null,null);
        this.N = 0;
    }
    //清空数组
    public void clear()
    {
        this.head = null;
    }
    //获取数组长度
    public int getLength()
    {
        Node node = head;
        while (node.next != null)
        {
            N++;
            node = node.next;
        }
        return N;
    }
    //根据链表插入数值
    public void insert(int index,T data)
    {
        Node pre = head;
        for(int i = 0 ; i <index-1;i++)
        {
                pre = pre.next;
        };
        Node n =  new Node(data,pre.next);
        pre.next = n;
        N++;
    }
    //移除数值
    public void remove(int index)
    {
        Node pre = head;
        for(int i = 0 ; i <index-1;i++)
        {
            pre = pre.next;
        };
        Node cur = pre.next.next;
        pre.next = cur;
        N--;
    }
    //是否为空
    public boolean isEmpty()
    {
        return head.next==null?true:false;
    }
    //获取数值
    public T get(int index)
    {
        Node node = head;
        for(int i = 0 ; i < index;i++)
        {
            node = node.next;
        }
        return (T)node.data;
    }
    //在数组尾部插入值
    public void insertEnd(T data)
    {
        Node node = head;
        while (node.next != null)
        {
            node = node.next;
        }
        node.next = new Node(data,null);
        N++;
    }
    //返回数值的索引
    public int indexOf(T data)
    {
        Node node = head;
        for (int i = 0 ; node.next != null;i++)
        {
            node = node.next;
            if(node.data.equals(data))
            {
                return i;
            }
        }
        return -1;
    }

    public Node getHead()
    {
        return this.head;
    }

    public void showLink()
    {
        Node node = head;
        while ( node.next != null)
        {
            node = node.next;
            System.out.print(node.data+" ");
        }
        System.out.println();
    }

    public Node reserve(Node node)
    {
       if(node.next == null)
       {
           head.next = node;
           return node;
       }else {
           Node pre = reserve(node.next);
           pre.next =node;
           node.next = null;
           return node;
       }
    }



    @Override
    public Iterator iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T>
    {
        private Node cur;

        public MyIterator()
        {
            cur = head;
        }

        @Override
        public boolean hasNext() {
            return cur.next != null;
        }

        @Override
        public T next() {
            cur=cur.next;
            return (T) cur.data;
        }
    }
}
