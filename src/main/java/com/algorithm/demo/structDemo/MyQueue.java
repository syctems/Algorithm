package com.algorithm.demo.structDemo;

import com.algorithm.demo.classUtil.Node;

import java.util.Iterator;

public class MyQueue<T> implements Iterable<T> {
    private int N;
    private Node first;
    private Node last;

    public MyQueue()
    {
        N=0;
        first = new Node(null,null);
        last = null;
    }

    public boolean isEmpty()
    {
        return N==0;
    }

    public int size()
    {
        return N;
    }

    public T dequeue()
    {
        Node node = first;
        first = node.next;
        N--;
        return (T)node.data;
    }

    public void enqueue(T data)
    {
        if (last == null)
        {
            last = first;
        }
        Node node = last;
        Node newNode = new Node(data,null);
        node.next = newNode;
        last = newNode;
        N++;
    }


    @Override
    public Iterator iterator() {
        return new MyIterable();
    }

    private class MyIterable implements Iterator{

        private Node cur;

        public MyIterable()
        {
            cur = first;
        }
        @Override
        public boolean hasNext() {
            return cur.next != null;
        }

        @Override
        public T next() {
            cur = cur.next;
            return (T)cur.data;
        }
    }
}
