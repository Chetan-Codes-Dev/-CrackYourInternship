class Solution {
    
    int findParent(int x){
        if(x == parent[x]){
            return x;
        }
        
        return parent[x] = findParent(parent[x]);
    }
    
    void union(int u, int v){
        int pu = findParent(u);
        int pv = findParent(v);        
        if(pu == pv){
            return;
        }
        
        int ru = size[pu];
        int rv = size[pv];
        
        if(ru > rv){
            parent[pv] = pu;
            size[pu] += size[pv];
        }
        else{
            parent[pu] = pv;
            size[pv] += size[pu];
        }          
    }
    
    int[] parent;
    int[] size;
    
    public int largestIsland(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        
        int res = Integer.MIN_VALUE;
        
        parent = new int[r*c];
        size = new int[r*c];
        
        for(int i = 0; i < r*c; i++){
            parent[i] = i;
            size[i] = 1;
        }
        
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(grid[i][j] == 1){
                    
                    int currVal = i * c + j;
                    
                    if(i > 0){
                        if(grid[i-1][j] == 1){
                            int val = (i-1) * c + j;
                            if(findParent(val) != findParent(currVal)){
                                union(val, currVal);
                            }
                        }
                    }
                    if(j > 0){
                        if(grid[i][j-1] == 1){
                            int val = i * c + (j-1);
                            if(findParent(val) != findParent(currVal)){
                                union(val, currVal);
                            }
                        }
                    }                    
                }
            }
        }   
        
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(grid[i][j] == 1){
                    int root = findParent(i * c + j);
                    res = Math.max(res, size[root]);
                }
            }
        }
        
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(grid[i][j] == 0){
                    
                    Set<Integer> roots = new HashSet<>();
                    
                    int currVal = i * c + j;
                    int cnt = 0;
                    if(i > 0){
                        if(grid[i-1][j] == 1){
                            int val = (i-1) * c + j;
                            int parent = findParent(val);
                            roots.add(parent);
                        }
                    }
                    if(j > 0){
                        if(grid[i][j-1] == 1){
                            int val = i * c + (j-1);
                            int parent = findParent(val);
                            roots.add(parent);
                        }
                    }
                    if(i < (r - 1)){
                        if(grid[i + 1][j] == 1){
                            int val = (i + 1) * c + j;
                            int parent = findParent(val);
                            roots.add(parent);
                        }
                    }
                    if(j < (c - 1)){
                        if(grid[i][j+1] == 1){
                            int val = i * c + (j+1);
                            int parent = findParent(val);
                            roots.add(parent);
                        }
                    }                    
                    for(int root : roots){
                        cnt += size[root];
                    }                    
                    cnt++;
                    res = Math.max(res, cnt);                   
                }
            }
        }
        
        return res;
    }
}