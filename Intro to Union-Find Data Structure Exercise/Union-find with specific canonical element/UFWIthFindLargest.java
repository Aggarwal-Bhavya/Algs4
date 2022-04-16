public class UFWithFindLargest {
    private int id[]; //id[i] = parent of node i
    private int sz[]; //sz[i] = size of node i
    private int large[]; //large[i] = largest element in connected component for i
    
    public UFWithFindLargest(int N) {
        id = new int[N];
        sz = new int[N];
        large = new int[N];
        for(int i=0; i<N; i++) {
            id[i] = i;
            sz[i] = 1;
            large[i] = i;
        }
    }

    private int root(int p) {
        while(id[p] != p) {
            id[p] = id[id[p]]; //path compression
            p = id[p];
        }
        return p;
    }

    //we are returning the largest element in the connected component containing p
    public int find(int p) {
        return large[root(p)];
    }

    public void union(int p, int q) {
        int rootp = root(p);
        int rootq = root(q);
        if(rootp == rootq)	return;
        int largestP = large[rootp];
        int largestQ = large[rootq];
        if(sz[rootp] < sz[rootq]) {
            id[rootp] = id[rootq];
            sz[rootq] += sz[rootp];
            if(largestP > largestQ) 
                large[rootq] = largestP;
        } else {
            id[rootq] = id[rootp];
            sz[rootp] += sz[rootq];
            if(largestQ > largestP)
                large[rootp] = largestQ;
        }
    }

    public boolean connected(int p, int q) {
        return root(p)==root(q);
    }
}