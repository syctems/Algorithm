package com.algorithm.demo.structDemo;

import com.algorithm.demo.classUtil.Digraph;

public class DirectedCycle {

    private boolean[] onStack;
    private boolean[] marked;
    private boolean hasCycle;

    public DirectedCycle(Digraph d)
    {
        int v = d.getV();
        onStack = new boolean[v];
        marked = new boolean[v];
        hasCycle = false;
    }

    private void dfs(Digraph d , int v)
    {
        marked[v] = true;
        onStack[v] = true;
        for (Object o : d.adj(v))
        {
            if(!marked[(int)o])
            {
                dfs(d,(int)o);
            }
            if (onStack[(int)o])
            {
                hasCycle = true;
                return;
            }
        }
        onStack[v] = false;
    }

    public boolean hasCycle()
    {
        return hasCycle;
    }
}
