class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int pivotIndex = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                pivotIndex = i;
                break;
            }
        }
        if (pivotIndex != -1) {
            int swapIndex = -1;
            for (int j = n - 1; j > pivotIndex; j--) {
                if (nums[j] > nums[pivotIndex]) {
                    swapIndex = j;
                    break;
                }
            }
            int temp = nums[pivotIndex];
            nums[pivotIndex] = nums[swapIndex];
            nums[swapIndex] = temp;
        }
        int left = pivotIndex + 1;
        int right = n - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}