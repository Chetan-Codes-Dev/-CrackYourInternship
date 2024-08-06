class Solution {
    public long minimumReplacement(int[] nums) {
        int last = nums[nums.length - 1];
        long res = 0;
        int i = nums.length - 2;
        for (; i >= 0 && last > 1; i--) {
            if (nums[i] > last) {
                int div = (nums[i] + last - 1) / last;
                res += div - 1;
                last = nums[i] / div;
            } else {
                last = nums[i];
            }
        }
        while (i >= 0) {
            res += nums[i] - 1;
            i--;
        }
        return res;
    }
}