class Solution {
    int [] par;
    int rank[];
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        par = new int [n+1];
        rank = new int[n+1];

        for(int i = 1; i <=n; i++) {
            par[i] = i;
            rank[i] = 1;
        }

        for(int[] edge : edges) {
            if(! (union(edge[0], edge[1]))) {
                return edge;
            }
        }
        return null;
    }

    public int find(int n) {
        int res = n;

        while(res != par[res]) {
            par[res] = par[par[res]];
            res = par[res];
        }

        return res;
    }

    public boolean union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if(pa == pb) {
            return false;
        }

        if(rank[pa] > rank[pb]) {
            par[pb] = pa;
            rank[pa] += rank[pb];
        } else {
            par[pa] = pb;
            rank[pb] += rank[pa];
        }

        return true; 
    }
}