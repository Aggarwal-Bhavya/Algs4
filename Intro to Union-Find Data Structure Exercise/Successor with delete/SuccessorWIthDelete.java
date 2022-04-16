public class SuccessorWithDelete {
    private int id[];
    private int sz[];
    private int actualList[];
    private int N;

    public SuccessorWithDelete(int N) {
        this.N = N;
        id = new int[N];
        sz = new sz[N];
        actualList = new int[N];
        for(int i=0; i<N; i++) {
            id[i] = i;
            sz[i] = 1;
            actualList[i] = i;
        }
    }

    //return the root of the component the integer is in
    private int root(int p) {
        while(id[p] != p) {
            p = id[p];
        }
        return p;
    }

    //weighted quick union
    public void union(int p, int q) {
        int rootp = root(p);
        int rootq = root(q);
        if(sz[rootp] < sz[rootq]) {
            id[rootp] = rootq;
            sz[rootq] += sz[rootp];
        } else {
            id[rootq] = rootp;
            sz[rootp] += sz[rootq];
            actualList[rootp] = actualList[rootq];
        }
    }

    public void remove(int x) {
        union(x, x+1);
    }

    public int successor(int x) {
        return actualList[root(x+1)];
    }
}