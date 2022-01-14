package algorithms;

public class question33 {
    static class Solution {
        public int search(int[] nums, int target) {
            int len = nums.length;
            if (len == 0)
                return -1;
            if (len == 1)
                return target == nums[0] ? 0 : -1;
            int low = 0;
            int high = len - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (nums[mid] == target)
                    return mid;
                if (nums[low] <= nums[mid]) {
                    if (target < nums[mid] && target >= nums[low])
                        high = mid - 1;
                    else
                        low = mid + 1;
                } else {
                    if (target > nums[mid] && target <= nums[high])
                        low = mid + 1;
                    else
                        high = mid - 1;
                }
            }
            return -1;

        }
    }

    public static void main(String[] args) {
        int[] nums = {5, 1, 3};
        Solution solution = new Solution();
        System.out.println(solution.search(nums, 3));
    }
}
