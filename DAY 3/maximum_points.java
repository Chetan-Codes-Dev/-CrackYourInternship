class Solution {
    public int maxScore(int[] cardPoints, int k) {

        int lsum =0, rsum =0, max =0,sum =0;
        int n = cardPoints.length;
        for(int i=0;i<k;i++){
            lsum = lsum + cardPoints[i];
        }
        max = lsum;
        int val= cardPoints.length -1;
        for (int i = k-1; i >=0; i--) {
            lsum -= cardPoints[i];
            rsum += cardPoints[val];
            sum = lsum+rsum;
            val--;
            if(sum>max){
                max = sum;
            }
        }
        return max;
    }
    
    }