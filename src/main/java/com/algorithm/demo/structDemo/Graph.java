package com.algorithm.demo.structDemo;


public class Graph {
    public MyQueue[] adj;

    public int E;

    public int V;

    public Graph(int v)
    {
        this.V = v;
        adj = new MyQueue[v];
        for (int i = 0 ; i <  v ; i++)
        {
            adj[i] = new MyQueue<Integer>();
        }
    }

    public void addEdge(int v,int w)
    {
        adj[v].enqueue(w);
        adj[w].enqueue(v);
        E++;
    }

    public MyQueue adj(int v)
    {
        return adj[v];
    }
}
