class Solution {
    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for (int n : nums) sum += n;
        int target = sum - x, cur = 0, left = 0, max = -1;
        if (target < 0) return -1;
        if (target == 0) return nums.length;
        for (int right = 0; right < nums.length; right++) {
            cur += nums[right];
            while (cur > target)
                cur -= nums[left++];
            if (cur == target)
                max = Math.max(max, right - left + 1);
        }
        return max == -1 ? -1 : nums.length - max;
    }
}