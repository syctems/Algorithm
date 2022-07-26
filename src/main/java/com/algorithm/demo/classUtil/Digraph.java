package com.algorithm.demo.classUtil;

import java.util.ArrayDeque;
import java.util.Queue;

public class Digraph {

    private int V;
    private int E;
    private Queue[] adj;

    public Digraph(int v){
        v = v+1;
        V = 0;
        E = 0;
        adj = new ArrayDeque[v];
        for (int i = 0 ; i < v ; i++)
        {
            adj[i] = new ArrayDeque();
            V++;
        }
    }

    public int getV()
    {
        return V;
    }

    public int getE()
    {
        return E;
    }

    public void addEdge(int v,int w)
    {
        adj[v].offer(w);
        E++;
    }

    public Queue adj(int v)
    {
        return adj[v];
    }

    public Digraph reverse()
    {
        Digraph digraph = new Digraph(V);
        for (int i = 0 ; i < V ; i++){
            for (Object w : adj(i)){
                digraph.addEdge((int)w,i);
            }
        }
        return digraph;
    }
}
