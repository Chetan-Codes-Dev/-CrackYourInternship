class Solution {
    public int maxDistance(int[] position, int m) {
        
        //Sort the position array first
        int n=position.length;
        Arrays.sort(position);
        
        int low=1, high= position[n-1]- position[0], ans=0;
        
        while(low<=high){
            int mid= (low+high)/2;
            if(isPossible(mid,m,position)){
                ans=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }
    
    private boolean isPossible(int gap,int magnets, int[] position){
        
        int count=1;
        int i=0,j=0, n=position.length;
        while(j<n){
            int nextPos= position[i]+gap;
            while(j<n && position[j]<nextPos)
                j++;
            
            if(j<n){
                count++;
                i=j;
            }
                
        }
        
        return count>=magnets;
    }
}