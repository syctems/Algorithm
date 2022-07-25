package com.algorithm.demo.structDemo;

import com.algorithm.demo.classUtil.RedBlackNode;

public class RedBlackTree<K extends Comparable<K>,V> {

    private static final boolean Red = true;

    private static final boolean Black = false;

    private RedBlackNode root;

    private int N;

    public RedBlackTree()
    {
        N = 0 ;
    }

    private boolean isRed(RedBlackNode x)
    {
        if( x == null)
        {
            return false;
        }
        return x.isParentColor == Red;
    }

    private RedBlackNode rotateLeft(RedBlackNode h)
    {
            RedBlackNode x = h.rightNode;
            h.rightNode = x.leftNode;
            x.leftNode = h;

            x.isParentColor = Black;
            h.isParentColor = Red;
            return x;
    }

    private RedBlackNode rotateRight(RedBlackNode h)
    {
        RedBlackNode x = h.leftNode;
        h.leftNode = x.rightNode;
        x.rightNode = h;
        x.leftNode.isParentColor = Black;
        return x;
    }

    private void flipColors(RedBlackNode h)
    {
        h.isParentColor = Red;
        h.leftNode.isParentColor = Black;
        h.rightNode.isParentColor = Black;
    }

    public void put(K key,V value)
    {
        if(root == null)
        {
          root = new RedBlackNode(key,value,Black,null,null);
          N++;
          return;
        }
        root = put(root,key,value);
        root.isParentColor = Black;
    }

    public Boolean more(K n,K o)
    {
        if (n.compareTo(o) > 0)
        {
            return true;
        }
        return false;
    }

    public RedBlackNode put(RedBlackNode h,K key,V value)
    {
            if (h == null)
            {
                N++;
                return new RedBlackNode(key,value,Red,null,null);
            }
            if(more(key,(K)h.key))
            {
               h.rightNode =  put(h.rightNode,key,value);
            }else {
               h.leftNode = put(h.leftNode,key,value);
            }

            if(!isRed(h.leftNode) && isRed(h.rightNode))
            {
                h=rotateLeft(h);
            }

            if(isRed(h.leftNode)&&isRed(h.leftNode.leftNode))
            {
                h=rotateRight(h);
            }

            if(isRed(h.leftNode) && isRed(h.rightNode))
            {
                flipColors(h);
            }
            return h;
    }

    public V get(K key)
    {
        if (root == null)
        {
            return null;
        }
        return get(root,key);
    }

    public V get(RedBlackNode h,K key)
    {
        if(h == null)
        {
            return null;
        }
        if(more(key,(K)h.key))
        {
            return  get(h.rightNode,key);
        }else if (key.compareTo((K)h.key) == 0)
        {
            return (V)h.value;
        }else {
            return get(h.leftNode,key);
        }
    }

    public RedBlackNode getRoot()
    {
        return root;
    }

    public void showEle(RedBlackNode t) {

        if (t == null) {
            return;
        } else {
            System.out.print("当前结点是:" + t.key+",颜色是:"+t.isParentColor);
            if (t.leftNode != null) {
                System.out.print(",左节点:" + t.leftNode.key);
            } else {
                System.out.print(",左节点:null");
            }
            if (t.rightNode != null) {
                System.out.print(",右节点:" + t.rightNode.key);
            } else {
                System.out.print(",右节点:null");
            }
            System.out.println();
            showEle(t.leftNode);
            showEle(t.rightNode);
        }
    }

    public int size()
    {
        return N;
    }


}
