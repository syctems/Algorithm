package com.algorithm.demo.structDemo;

import com.algorithm.demo.classUtil.Node;

import java.util.Iterator;

public class MyStack<T> implements Iterable<T> {
    private Node head;
    private int N;

    public MyStack()
    {
        head = new Node(null,null);
        N = 0;
    }

    public boolean isEmpty()
    {
        return N == 0;
    }

    public int size()
    {
        return N;
    }

    public T pop()
    {
        if(N <= 0)
        {
            throw new ArrayIndexOutOfBoundsException("数组为空");
        }
        Node node = head;
        head = head.next;
        N--;
        return (T)node.data;
    }

    public void  push(T t)
    {

        head.next = new Node(t,head.next);
        N++;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterable();
    }

    private class MyIterable implements Iterator{

        private Node cur;

        public MyIterable()
        {
            cur = head;
        }
        @Override
        public boolean hasNext() {
            return cur.next != null;
        }

        @Override
        public T next() {
            cur =cur.next;
            return (T)cur.data;
        }
    }
}
