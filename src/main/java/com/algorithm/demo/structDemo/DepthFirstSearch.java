package com.algorithm.demo.structDemo;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class DepthFirstSearch {

    public boolean[] marked;
    public int count;
    public Queue markLink;

    public DepthFirstSearch(Graph g)
    {
        count = 0;
        marked = new boolean[g.V];
        markLink = new ArrayDeque();
    }

    public void dfs(Graph g,int s)
    {
        init(g);
        takeBabel(g,s);
    }

    public void lfs(Graph g,int s)
    {
        init(g);
        takeBabel2(g,s);
    }

    public boolean marked(int w)
    {
       return marked[w];
    }

    private void init(Graph g)
    {
        for (int i = 0 ; i < g.V;i++)
        {
            marked[i] = false;
        }
    }

    private void takeBabel(Graph g,int v)
    {
        System.out.println(v);
        marked[v] = true;
       for (Object o :g.adj(v)){
           if(!marked((int)o))
           {
               takeBabel(g,(int)o);
           }
       }
        count++;
    }

    private void takeBabel2(Graph g,int v)
    {

        marked[v] = true;
        markLink.offer(v);
        while (!markLink.isEmpty())
        {
            Object o1 = markLink.poll();
            System.out.println(o1);
            for (Object o :g.adj((int)o1))
            {
                if(!marked((int)o))
                {
                    marked[(int)o] = true;
                    markLink.offer(o);
                }
            }
        }
        count++;
    }


    public void showEle(Graph g)
    {
        for (int i = 0 ; i < g.V ; i++)
        {
            System.out.println("index:"+ i + ",value:"+marked[i]);
        }
    }
}
