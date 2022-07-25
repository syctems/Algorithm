package com.algorithm.demo.structDemo;

import com.algorithm.demo.classUtil.Tree;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class ForeachTree<K>
{
    public Queue<K> queue = new ArrayDeque<>();

    public Tree tree;



    public Queue<K> preRrgodic()
    {
        preRrgodic(tree);
        return queue;
    }

    private void preRrgodic(Tree x)
    {
        if ( x == null)
        {
            return;
        }else {
            queue.offer((K)x.key);
            if(x.leftTree != null)
            {
                preRrgodic(x.leftTree);
            }
            if (x.rightTree != null)
            {
                preRrgodic(x.rightTree);
            }
        }
    }

    public Queue<K> midRrgodic()
    {
        midRrgodic(tree);
        return queue;
    }

    private void midRrgodic(Tree x)
    {
        if ( x == null)
        {
            return;
        }else {
            if(x.leftTree != null)
            {
                midRrgodic(x.leftTree);
            }
            queue.offer((K)x.key);
            if (x.rightTree != null)
            {
                midRrgodic(x.rightTree);
            }
        }
    }

    public Queue<K> lastRrgodic()
    {
        lastRrgodic(tree);
        return queue;
    }

    private void lastRrgodic(Tree x)
    {
        if(x == null)
        {
            return;
        }
        if(x.leftTree != null)
        {
            lastRrgodic(x.leftTree);
        }

        if (x.rightTree != null)
        {
            lastRrgodic(x.rightTree);
        }
        queue.offer((K)x.key);
    }

    public int depth(Tree x)
    {
        if (x == null) {
            return 0;
        }
        int max=0;
        int maxL=0;
        int maxR=0;
        if(x.leftTree != null)
        {
            maxL = depth(x.leftTree);
            maxL++;
        }
        if(x.rightTree != null)
        {
            maxR = depth(x.rightTree);
            maxR++;
        }
        max = (maxL > maxR)?maxL:maxR;
        return max;
    }
}
