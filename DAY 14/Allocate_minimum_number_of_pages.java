class Solution {
    public int n = 0;

    public int[] quantities;

    public int minimizedMaximum(int n, int[] quantities) {
        this.n = n;
        this.quantities = quantities;

        // search maximum number of products that are given to any store.
        int left = 1, right = Arrays.stream(quantities).max().getAsInt();
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (!isValid(mid))
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
    
    /** Validate if given maximum number of product a retail store can display is possible under given constrain. */
    private boolean isValid(int maxNumberProduct) {
        int count = 0;
        for (int quantity : quantities) {
            count += (maxNumberProduct + quantity - 1) / maxNumberProduct;
            if (count > n)
                return false;
        }
        return true;
    }
}