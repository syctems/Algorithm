package com.algorithm.demo.structDemo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Heap<T extends Comparable<T>>  {
    public int N;
    public T[] items;

    public Heap(int capacity)
    {
        N=1;
        this.items = (T[])new Comparable[capacity];
    }

    public boolean less(int i,int j)
    {
        if(items[j] == null)
        {
            return false;
        }
        if(items[i].compareTo(items[j]) < 0)
            return true;
        return false;
    }

    public void exchange(int i,int j)
    {
        T temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    public T delMax()
    {
        exchange(1,--N);
        T temp = items[N];
        items[N]=null;
        sink(1);
        return temp;
    }

    public T get(int i)
    {
        return items[i++];
    }

    public void insert(T t)
    {
        items[N++] = t;
        swim(N-1);
    }

    public void swim(int k)
    {
        if (k <= 1 )
        {
            return;
        }
        if(less(k/2,k))
        {
            exchange(k/2,k);
            swim(k/2);
        }

    }

    public void sink(int k)
    {
        if(2*k > N-1)
        {
            return;
        }
        if(!less(k,2*k)&&!less(k,2*k+1))
        {
            return;
        }
        if(less(2*k,2*k+1))
        {
            exchange(k,2*k+1);
            sink(2*k+1);
        }else {
            exchange(k,2*k);
            sink(2*k);
        }
    }

    public List<T> heapSort()
    {
        List<T> list = new ArrayList<>();
        int length = N-1;
        for (int i =0; i < length ; i++)
        {
            list.add(delMax());
        }
        return list;
    }

}
