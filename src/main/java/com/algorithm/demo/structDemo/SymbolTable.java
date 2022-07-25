package com.algorithm.demo.structDemo;

import com.algorithm.demo.classUtil.SymbolNode;

import java.util.Iterator;

public class SymbolTable<K,V> {
    private int N;
    private SymbolNode symbolNode;

    public SymbolTable()
    {
        N = 0;
        symbolNode = new SymbolNode(null,null,null);
    }

    public V get(K key)
    {
        SymbolNode sn = symbolNode.next;
        while(sn != null)
        {
            if(sn.key.equals(key))
            {
                return (V)sn.value;
            }
            sn = sn.next;
        }
        return null;
    }

    public void put(K key,V value)
    {
        SymbolNode sn = symbolNode;
        while(sn.next != null)
        {
            sn = sn.next;
        }
        sn.next = new SymbolNode(key,value,null);
        N++;
    }

    public void delete(K key)
    {
        if( N <= 0 )
        {
            throw new RuntimeException("当前容器为0");
        }
        SymbolNode sn = symbolNode;
        while(sn.next != null)
        {
            if(sn.next.key.equals(key))
            {
                sn.next = sn.next.next;
                N--;
                return;
            }
            sn = sn.next;
        }
    }

    public void showEle()
    {
        SymbolNode s = symbolNode;
        for (s = s.next; s != null ; s = s.next)
        {
            System.out.println("key:"+ s.key + " value:"+s.value);
        }
    }

    public int size()
    {
        return N;
    }

}
