package com.algorithm.demo.classUtil;

public class SymbolNode<K,V> {
    public K key;
    public V value;
    public SymbolNode next;

    public SymbolNode(K k,V v,SymbolNode s)
    {
        key = k;
        value = v;
        next = s;
    }
}
