package com.algorithm.demo.classUtil;

public class Node<T> {
    //结点存储的值
    public T data;
    //存储下个结点
    public Node next;

    public Node(T data,Node next)
    {
        this.data = data;
        this.next = next;
    }
}
