package algorithms;

import algorithms.Util;

public class question34 {
    static class Solution {
        public int[] searchRange(int[] nums, int target) {
            var output = new int[]{0, 0};
            int len = nums.length;
            if (len == 0)
                return new int[]{-1, -1};
            if (len == 1)
                return target == nums[0] ? new int[]{0, 0} : new int[]{-1, -1};
            int low = 0;
            int high = len - 1;
            int mid = 0;
            while (low <= high) {
                mid = (low + high) / 2;
                if (nums[mid] >= target)
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            output[0] = mid;
            low = 0;
            high = len - 1;
            mid = (low + high) / 2;
            while (low <= high) {
                mid = (low + high) / 2;
                if (nums[mid] <= target)
                    low = mid + 1;
                else
                    high = mid - 1;
            }

            if (nums[len - 1] == target || mid == 0) {
                output[1] = mid;
            } else {
                output[1] = mid - 1;
            }
            return nums[output[0]] == target && nums[output[1]] == target ? output : new int[]{-1, -1};
        }
    }

    static class Answer {
        public int[] searchRange(int[] nums, int target) {
            int leftIdx = binarySearch(nums, target, true);
            int rightIdx = binarySearch(nums, target, false) - 1;
            if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
                return new int[]{leftIdx, rightIdx};
            }
            return new int[]{-1, -1};
        }

        public int binarySearch(int[] nums, int target, boolean lower) {
            int left = 0, right = nums.length - 1, ans = nums.length;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] > target || (lower && nums[mid] >= target)) {
                    right = mid - 1;
                    ans = mid;
                } else {
                    left = mid + 1;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        var util = new Util();
        var input = new int[]{1, 2, 3, 3, 3, 3, 3, 3};
        Solution solution = new Solution();
        Answer answer = new Answer();
        util.toString(answer.searchRange(input, 2));
    }
}
