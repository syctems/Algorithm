package com.algorithm.demo.structDemo;

import com.algorithm.demo.classUtil.Tree;

public class BinaryTree<K extends Comparable<K>,V> {

        private int N;

        private Tree root;

        public Tree getRoot()
        {
            return root;
        }

        public void put(K key ,V value)
        {
           root = put(root,key,value);
        }


        public Tree put(Tree x,K key, V value)
        {
            Tree tree = x;
            if(tree == null)
            {
                N++;
                return  tree = new Tree(key,value,null,null);
            }else {
                int rs = key.compareTo((K)tree.key);
                if(rs < 0)
                {
                    tree.leftTree = put(tree.leftTree,key,value);
                }else if(rs > 0) {
                    tree.rightTree = put(tree.rightTree,key,value);
                }else {
                    tree.value = value;
                }
            }
            return tree;
        }


        public V get(K key)
        {
            return  (V)get(root,key).value;
        }

        public Tree get(Tree x,K key)
        {
            Tree tree = x;
            if(tree == null)
            {
                return null;
            }else {
                int rs = key.compareTo((K)tree.key);
                if (rs < 0)
                {
                    return tree.leftTree = get(tree.leftTree,key);
                }else if( rs > 0 ){
                    return tree.rightTree = get(tree.rightTree,key);
                }else {
                    return tree;
                }
            }

        }

        public void delete(K key)
        {
            delete(root,key);
        }

        public void delete(Tree x, K key)
        {
            Tree oldTree = get(x,key);
            Tree newTree = findMinNode(oldTree.rightTree);

            Tree oldParentTree = findParentNode(root,key);
            Tree newParentTree = findParentNode(root,(K)newTree.key);

            newParentTree.leftTree = null;
            newTree.leftTree = oldTree.leftTree;
            newTree.rightTree = oldTree.rightTree;
            if(key.compareTo((K)oldParentTree.key) > 0)
            {
                oldParentTree.rightTree = newTree;
            }else {
                oldParentTree.leftTree = newTree;
            }
            N--;
        }

        public Tree findMinNode(Tree t)
        {
            if(t.leftTree == null){
                return t;
            }else {
                return findMinNode(t.leftTree);
            }
        }

        public Tree findParentNode(Tree t,K key)
        {
            if (t.key.equals(key))
            {
                return root;
            }
            if (t.leftTree.key.equals(key)|| t.rightTree.key.equals(key))
            {
                return t;
            }
            int rs = key.compareTo((K)t.key);
            if (rs > 0)
            {
               return findParentNode(t.rightTree,key);
            }else {
               return findParentNode(t.leftTree,key);
            }

        }

        public void showEle(Tree t)
        {

            if(t == null)
            {
                return;
            }else {
                System.out.print("当前结点是:"+t.key);
                if(t.leftTree != null)
                {
                    System.out.print(",左节点:"+t.leftTree.key);
                }else {
                    System.out.print(",左节点:null");
                }
                if(t.rightTree != null)
                {
                    System.out.print(",右节点:"+t.rightTree.key);
                }else {
                    System.out.print(",右节点:null");
                }
                System.out.println();
                showEle(t.leftTree);
                showEle(t.rightTree);
            }

        }

        public int size()
        {
            return N;
        }

}
