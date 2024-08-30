//https://leetcode.com/problems/number-of-operations-to-make-network-connected/solutions/717403/c-dfs-number-of-islands-detailed-explanation
//https://leetcode.com/problems/number-of-operations-to-make-network-connected/solutions/3331562/from-75-to-100-union-find-with-images-java-c
class Solution {
    int[] parent;
    int[] rank;
    int find(int x){
        while(parent[x]!=x){
            x = parent[parent[x]];
        }
        return x;
    }
    int makeUnion(int x, int y){
        int parX = find(x);
        int parY = find(y);
        if(parX == parY){
            return 0;
        }
        else if(rank[parX]<rank[parY]){
            parent[parX] = parY;
        }
        else if(rank[parX]>rank[parY]){
            parent[parY] = parX;
        }
        else{
            parent[parY] = parX;
            rank[parX]++;
        }
        return 1;
    }
    public int makeConnected(int n, int[][] connections) {
        int edges = connections.length;
        if(edges<n-1){
            return -1;
        }
        parent = new int[n];
        rank = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
        }
        int components = n;
        for(int[] con : connections){
            components -= makeUnion(con[0], con[1]);
        }
        return components-1;
    }
}