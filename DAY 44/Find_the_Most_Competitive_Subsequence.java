// Idea based on Monotonic Stack 
// O(n)
// Use Array instead of Stack
class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        int n = nums.length;

        int[] st = new int[n];
        int size = 0;
        for (int i = 0; i < n; ++i) {
            while (size > 0 && (n - i + (size - 1) >= k) && nums[i] < nums[st[size - 1]]) {
                size -= 1;
            }

            st[size] = i;
            size += 1;
        }

        int[] res = new int[k];
        for (int i = 0; i < k; ++i) {
            res[i] = nums[st[i]];
        }

        return res;
    }
}