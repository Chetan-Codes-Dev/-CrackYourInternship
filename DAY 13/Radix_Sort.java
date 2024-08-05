class Solution {
    public final int[] sortArray(final int[] nums) {
        
        int negCount = 0, posCount = 0, negMax = Integer.MIN_VALUE, posMax = Integer.MIN_VALUE; 
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                negMax = Math.max(negMax, nums[i] * -1);
                negCount++; 
            }
            else {
                posMax = Math.max(posMax, nums[i]);
                posCount++;
            }
        }
        
        final int[] negNums = new int[negCount];
        final int[] posNums = new int[posCount];
        
        for (int i = 0, j = 0, k = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                negNums[j++] = nums[i] * -1;
            }
            else {
                posNums[k++] = nums[i];
            }
        }
        
        for (int exp = 1; negMax/exp > 0; exp *= 10) {
            countingSort(negNums, exp);
        }

        for (int exp = 1; posMax/exp > 0; exp *= 10) {
            countingSort(posNums, exp);
        }
        
        int i = 0; 
        
        for (int j = negNums.length - 1; j >= 0; j--) {
            nums[i++] = negNums[j] * -1;
        }
        
        for (int j = 0; j < posNums.length; j++) {
            nums[i++] = posNums[j];
        }
        
        return nums;
        
    }
    
    private void countingSort(final int[] nums, final int exp) {
        final int[] count = new int[10];
        final int[] res = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            count[(nums[i]/exp) % 10]++;
        }
        
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        
        for (int i = nums.length - 1; i >= 0; i--) {
            res[--count[(nums[i]/exp) % 10]] = nums[i];
        }
        
        for (int i = 0; i < nums.length; i++) {
            nums[i] = res[i];
        }
    }
}