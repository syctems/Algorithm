package com.algorithm.demo.classUtil;

/**
 * 红黑树定义：
 * 1.红连接必须是左连接；
 * 2.没有任何一个结点同时和两条红链接相连
 * 3.该树是完美黑色平衡树，任意空连接到根结点路径上的黑连接数量相同
 * */

public class RedBlackNode<K,V> {
    public K key;
    public V value;
    public Boolean isParentColor;
    public RedBlackNode leftNode;
    public RedBlackNode rightNode;
    public RedBlackNode(K k,V v,Boolean c , RedBlackNode l,RedBlackNode r)
    {
        this.key = k;
        this.value = v;
        this.isParentColor = c;
        this.leftNode = l;
        this.rightNode = r;
    }
}
