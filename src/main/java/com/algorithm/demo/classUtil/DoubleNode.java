package com.algorithm.demo.classUtil;

public class DoubleNode <T>
{
    public T data;
    public DoubleNode pre;
    public DoubleNode next;

    public DoubleNode(T data,DoubleNode p , DoubleNode n)
    {
        this.data = data;
        this.pre = p;
        this.next = n;
    }
}
