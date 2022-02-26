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
            int leftIdx = findFirst(nums, target);
            int rightIdx = newBinarySearch(nums, target, false);
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

        public int newBinarySearch(int[] nums, int target, boolean lower) {
            int left = 0, right = nums.length;
            while (left < right) {
                int mid = ((right - left) >> 1) + left;
                if (lower) {
                    if (nums[mid] < target)
                        left = mid + 1;
                    else
                        right = mid;
                } else {
                    if (nums[mid] > target)
                        right = mid - 1;
                    else
                        left = mid;
                }
            }
            return right;
        }

        public int findFirst(int[] nums, int target) {
            int left = 0, right = nums.length;
            while (left < right) {
                int mid = ((right - left) >> 1) + left;
                if (nums[mid] < target)
                    left = mid + 1;
                else
                    right = mid;
            }
            return right;
        }

        public int findLast(int[] nums, int target){
            int left = 0,right = nums.length - 1;
            while(left<right){
                int mid = ((right - left + 1) >> 1) +left;
                if (nums[mid] > target) //在这种情况下能确定需要求的下标在mid的左侧
                    right = mid - 1;
                else //要求的下标在mid及mid的右侧
                    left = mid;
            }
            return right;
        }

        public int findFirstLarger(int[] nums, int target) {
            int left = 0, right = nums.length;
            while (left < right) {
                int mid = ((right - left) >> 1) + left;
                if (nums[mid] > target)
                    right = mid;
                else
                    left = mid + 1;
            }
            return left;
        }

        public int findFirstSmaller(int[] nums, int target) {
            int left = 0, right = nums.length;
            while (left < right) {
                int mid = ((right - left + 1) >> 1) + left;
                if (nums[mid] >= target)
                    right = mid - 1;
                else
                    left = mid;
            }
            return left;
        }
    }

    public static void main(String[] args) {
        var util = new Util();
        var input = new int[]{5, 7, 7, 8, 8, 10};
        Solution solution = new Solution();
        Answer answer = new Answer();
        System.out.println(answer.findLast(input, 7));
    }
}
