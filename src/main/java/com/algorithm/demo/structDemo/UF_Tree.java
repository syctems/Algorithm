package com.algorithm.demo.structDemo;

public class UF_Tree {
    public int count;

    public int[] eleAndGroup;

    public int[] eleNum;

    public UF_Tree(int n,boolean w)
    {
        count = n;
        eleAndGroup = new int[n];
        eleNum = new int[n];
        for (int i = 0 ; i < n ; i++)
        {
            eleAndGroup[i] = i;
        }
        if (w)
        {
            for (int i = 0 ; i < n ; i++)
            {
                eleNum[i] = 1;
            }
        }
    }

    public int getValue(int p)
    {
        return eleAndGroup[p];
    }

    public int getNumValue(int p)
    {
        return eleNum[p];
    }

    public int find(int p)
    {
        if (p == getValue(p))
        {
            return p;
        }
        return find(getValue(p));
    }

    public void union(int p,int q)
    {
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot != qRoot)
        {
            eleAndGroup[pRoot] = eleAndGroup[qRoot];
            eleNum[qRoot] = getNumValue(pRoot) + getNumValue(qRoot);
            eleNum[pRoot] = 0;
            count--;
        }
    }

    public void showEle()
    {
        for (int i = 0 ; i < eleAndGroup.length ; i++)
        {
            System.out.println("index:"+i+",value:"+eleAndGroup[i]);
        }
    }

    public void showNumEle()
    {
        for (int i = 0 ; i < eleNum.length ; i++)
        {
            System.out.println("index:"+i+",value:"+eleNum[i]);
        }
    }

    public boolean connected(int p,int q)
    {
        return find(p) == find(q);
    }
}
