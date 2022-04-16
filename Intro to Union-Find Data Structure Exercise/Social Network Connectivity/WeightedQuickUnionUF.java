public class WeightedQuickUnionUF {
    private int id[]; //id[i] = parents of node i
    private int sz[]; //sz[i] = size of node i (used as count)

    public WeightedQuickUnionUF(int N) {
        count = N;
        id = new int[N];
        sz = new int[N];
        for(int i=0; i<N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    private int root(int p) {
        while(p != id[p]) {
            id[p] = id[id[p]]; //path compression
            p = id[p];
        }
        return p;
    }

    public void union(int p, int q, String timestamp) {
        int i = root(p);
        int j = root(q);
        if(i == j)    return;
        if(sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
            if(sz[j] == N) {
                StdOut.println("All members are connected at timestamp: " + timestamp);
            }
        } else {
            id[j] = i;
            sz[i] += sz[j];
            if(sz[i]==N) {
                StdOut.println("All members are connected at timestamp: " + timestamp);
            }
        }
    }
}
    
