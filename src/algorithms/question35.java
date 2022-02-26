package algorithms;

public class question35 {
    static class Solution {
        public int searchInsert(int[] nums, int target) {
            int len = nums.length;
            if (len == 0)
                return 0;
            int left = 0;
            int right = len - 1;
            int mid = 0;
            int ans = len;
            while (left <= right) {
                mid = (left + right) / 2;
                if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                    ans = mid;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        var input = new int[]{1,2,3};
        var target = 2;
        System.out.print(solution.searchInsert(input, target));
    }
}
