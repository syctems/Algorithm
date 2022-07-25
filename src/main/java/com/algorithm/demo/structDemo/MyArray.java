package com.algorithm.demo.structDemo;

import java.util.Iterator;

public class MyArray<T> implements Iterable<T> {

    //数组存储数据
    private T[] ele;
    // 数组的长度
    private int length;
    // 数组的容量
    private int capacity;

    public MyArray(int n)
    {
        this.length = 0;
        this.ele = (T[]) new Object[n];
        this.capacity = n;
    }

    //清空数组
    public void clear()
    {
        length = 0;
    }
    //获取数组长度
    public int getLength()
    {
        return length;
    }
    //根据索引插入数值
    public void insert(int index,T data)
    {
        if(length > capacity)
        {
            resize(2);
        }

        for (int i = length;i>index;i--)
        {
            ele[i]=ele[i-1];
        }
        ele[index] = data;
        length++;
    }
    //移除数值
    public void remove(int index)
    {
        for (int i = index;i<length;i++)
        {
            ele[i]=ele[i+1];
        }
        length--;
        if (length < (capacity / 2))
        {
            resize(capacity /2);
        }
    }
    //是否为空
    public boolean isEmpty()
    {
        return getLength() == 0;
    }
    //获取数值
    public T get(int index)
    {
        return ele[index--];
    }
    //在数组尾部插入值
    public void insertEnd(T data)
    {
        if(length >= capacity)
        {
            resize(2 * capacity);
        }
        ele[length]=data;
        length++;
    }
    //返回数值的索引
    public int indexOf(T data)
    {
        for (int i =0;i<length;i++)
        {
            if(ele[i] == data)
            {
                return i;
            }
        }
        return -1;
    }


    @Override
    public Iterator iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator
    {
        private int cur;
        public MyIterator()
        {
            this.cur = 0;
        }

        @Override
        public boolean hasNext() {
            return cur < length;
        }

        @Override
        public Object next() {
            return ele[cur++];
        }
    }

    public void showEle()
    {
        for (int i = 0; i<length;i++)
        {
            System.out.print(this.ele[i]+" ");
        }
        System.out.println("数组的长度:"+length+", 数组的容量："+capacity);
        System.out.println();
    }

    public void resize(int n)
    {
        this.capacity = n;
        T[] temp = (T[]) new Object[n];
        for (int i = 0 ; i < length; i++)
        {
            temp[i] = ele[i];
        }
        this.ele = temp;
    }

}
