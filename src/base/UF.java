package base;

public class UF {
    private int[] id;
    private int[] sz;
    private int count;

    public UF(int N) {
        count = N;
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    private int find(int p) {
        return id[p];
    }

    public void union(int p, int q) {
        int pId = id[p];
        int qId = id[q];

        if (pId == qId)
            return;

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pId) {
                id[i] = qId;
            }
        }
        count--;
    }

    private int treeFind(int p) {
        while (p != id[p])
            p = id[p];
        return p;
    }

    public void treeUnion(int p, int q) {
        int pRoot = treeFind(p);
        int qRoot = treeFind(q);
        if (pRoot == qRoot) {
            return;
        }

        id[pRoot] = qRoot;

        count--;
    }

    public void quickTreeUnion(int p, int q) {
        int i = treeFind(p);
        int j = treeFind(q);
        if (i == j)
            return;

        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
        count--;
    }
}
