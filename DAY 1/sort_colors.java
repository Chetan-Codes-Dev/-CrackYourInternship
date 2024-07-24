class Solution {
    public void sortColors(int[] nums) {
        int z = 0, o = 0, n = nums.length;
        for(int i=0; i<n; i++){
            if(nums[i] == 0) z++;
            else if(nums[i] == 1) o++;
        }
        for(int i=0; i<z; i++){
            nums[i] = 0;
        }
        for(int i=z; i<z+o; i++){
            nums[i] = 1;
        }
        for(int i=z+o; i<n; i++){
            nums[i] = 2;
        }
    }
}