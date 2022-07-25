package com.algorithm.demo.structDemo;

public class UF {
    public int count;

    public int[] eleAndGroup;

    public UF(int n)
    {
        count = n;
        eleAndGroup = new int[n];
        for (int i = 0 ; i < n ; i++)
        {
            eleAndGroup[i] = i;
        }
    }

    public int find(int p)
    {
        return eleAndGroup[p];
    }

    public void union(int p,int q)
    {
        if(connected(p,q))
            return ;
        int pIndex = find(p);
        int qIndex = find(q);
        for (int i = 0 ; i < eleAndGroup.length ; i++)
        {
            if(find(i) == pIndex){
                eleAndGroup[i] = qIndex;
            }
        }
        count--;
    }

    public void showEle()
    {
        for (int i = 0 ; i < eleAndGroup.length ; i++)
        {
            System.out.println("index:"+i+",value:"+find(i));
        }
    }

    public boolean connected(int p,int q)
    {
        return find(p) == find(q);
    }
}
