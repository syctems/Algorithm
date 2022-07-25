package com.algorithm.demo.structDemo;

import com.algorithm.demo.classUtil.DoubleNode;

import java.util.Iterator;

public class MyDoubleLink<T> implements Iterable<T> {
    private int N;
    private DoubleNode firstDoubleNode;
    private DoubleNode lastDoubleNode;

    public MyDoubleLink()
    {
        this.N = 0;
        this.firstDoubleNode = new DoubleNode(null,null,null);
        DoubleNode doubleNode = firstDoubleNode;
        while (doubleNode.next != null)
        {
            doubleNode = doubleNode.next;
        }
        this.lastDoubleNode = doubleNode;
    }

    public void clear()
    {
        this.firstDoubleNode = null;
        this.lastDoubleNode = null;
        this.N = 0;
    }

    public boolean isEmpty()
    {
        return N == 0 ? true :false;
    }

    public int getLength()
    {
        return N;
    }

    public T get(int index)
    {
        DoubleNode doubleNode = firstDoubleNode;
        for(int i = 0; i < index;i++)
        {
            doubleNode = doubleNode.next;
        }
        return (T)doubleNode.data;
    }

    public void insert(int index,T data)
    {
        if(index > N)
        {
            new RuntimeException("索引值大于数组的长度");
        }
        DoubleNode doubleNode = firstDoubleNode;
        for(int i = 0; i < index -1;i++)
        {
            doubleNode = doubleNode.next;
        }
        DoubleNode<T> newDoubleNode = new DoubleNode<>(data, doubleNode, doubleNode.next);
        doubleNode.next = newDoubleNode;
        N++;
    }

    public void insertEnd(T data)
    {
        DoubleNode doubleNode = firstDoubleNode;
        while (doubleNode.next != null)
        {
            doubleNode = doubleNode.next;
        }
        DoubleNode<T> newDoubleNode = new DoubleNode<>(data, doubleNode, null);
        this.lastDoubleNode = newDoubleNode;
        doubleNode.next = newDoubleNode;
        N++;
    }

    public void remove(int index)
    {
        if(N <0 || index > N)
        {
            new RuntimeException("请在数组的长度中取值");
        }
        DoubleNode doubleNode = firstDoubleNode;
        for(int i = 0; i < index -1 ; i++)
        {
            doubleNode = doubleNode.next;
        }
        doubleNode.next = doubleNode.next.next;
        N--;
    }

    public int indexOf(T data)
    {
        DoubleNode doubleNode = firstDoubleNode;
        for(int i = 1; i <= N ; i++)
        {
            doubleNode = doubleNode.next;
            if(doubleNode.data.equals(data))
            {
                return i;
            }
        }
        return -1;
    }

    public T  getFirstDoubleNode()
    {
        return (T)firstDoubleNode.next.data;
    }

    public T getLastDoubleNode()
    {
            return (T)lastDoubleNode.data;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T>
    {
        private DoubleNode cur;

        public MyIterator()
        {
            cur = firstDoubleNode;
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
