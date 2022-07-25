package com.algorithm.demo.structDemo;

public class MinPriorityQueue<T extends Comparable<T>>
{
    public int N;
    private T[] items;

    public MinPriorityQueue(int cp)
    {
        N = 0;
        this.items = (T[])new Comparable[cp];
    }

    public boolean more(int i,int j)
    {
        if(items[i] == null)
        {
            return true;
        }
        if(items[i].compareTo(items[j]) > 0)
        {
            return true;
        }
        return false;
    }

    public void exchange(int i,int j)
    {
        T temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    public T delMin()
    {
        T temp = items[N];
        exchange(1,N);
        items[N] = null;
        N--;
        sink(1);
        return temp;
    }

    public T get(int i)
    {
        return items[i++];
    }

    public void insert(T t)
    {
        N++;
        items[N] = t;
        swim(N);
    }

    public void swim(int k)
    {
        if( k <= 1)
        {
            return;
        }
        if(more(k/2,k)){
            exchange(k/2,k);
            swim(k/2);
        }

    }

    public void sink(int k)
    {
        if( 2*k > N )
        {
            return;
        }
        if (more(2*k,k)&&more(2*k+1,k))
        {
            return;
        }

        if (more(2*k+1,2*k))
        {
            exchange(k,2*k);
            sink(2*k);
        }else {
            exchange(k,2*k+1);
            sink(2*k+1);
        }
    }

    public int size()
    {
        return N;
    }

    public boolean isEmpty()
    {
        return N==0;
    }
}