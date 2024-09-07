class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        int [][]res = new int[k][2];
        quickSelect(points, k - 1, 0, n - 1);
        for(int i = 0; i < k; i++) {
            res[i] = points[i];
        }
        return res;
    }

    private void quickSelect(int [][]points, int k, int low, int high) {
        while(low < high) {
            int pivotIdx = partition(points, low, high);
            if(pivotIdx == k) {
                break;
            }
            else if(pivotIdx < k) {
                low = pivotIdx + 1;
            }
            else {
                high = pivotIdx - 1;
            }
        }
    }

    private int partition(int [][]points, int low, int high) {
        int random = new Random().nextInt(high - low + 1) + low;
        int []pivot = points[random];
        swap(points, random, high);

        int pivotIdx = low;
        // swap elements smaller than pivot to left
        while(low < high) {
            if(points[low][0] * points[low][0] + points[low][1] * points[low][1] <= pivot[0] * pivot[0] + pivot[1] * pivot[1]) {
                swap(points, pivotIdx, low);
                pivotIdx++;
            }
           low++;
        }
        swap(points, pivotIdx, high);
        return pivotIdx;
    }

    private void swap(int [][]points, int a, int b) {
        int []temp = points[a];
        points[a] = points[b];
        points[b] = temp;
    }
}