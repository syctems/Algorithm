package com.algorithm.demo.classUtil;

public class Tree<K,V> {
    public K key;
    public V value;
    public Tree leftTree;
    public Tree rightTree;

    public Tree(K k,V v,Tree lt,Tree rt)
    {
        key = k;
        value = v;
        leftTree = lt;
        rightTree = rt;
    }
}
