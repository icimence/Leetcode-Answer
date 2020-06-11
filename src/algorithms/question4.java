package algorithms;

import java.net.Socket;

public class question4 {
    static class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            if (nums1.length > nums2.length) {
                int[] temp = nums1;
                nums1 = nums2;
                nums2 = temp;
            }
            int m = nums1.length;
            int n = nums2.length;

            int totalLeft = m + (n - m + 1) / 2;

            int left = 0;
            int right = m;
            while (left < right) {
                int i = left + (right - left + 1) / 2;
                int j = totalLeft - i;
                if (nums1[i - 1] > nums2[j]) {
                    right = i - 1;
                } else {
                    left = i;
                }
            }

            int i = left;
            int j = totalLeft - i;
            int nums1Left = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
            int nums1Right = i == m ? Integer.MAX_VALUE : nums1[i];
            int nums2Left = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
            int nums2Right = j == n ? Integer.MAX_VALUE : nums2[j];

            if ((m + n) % 2 == 1) {
                return Math.max(nums1Left, nums2Left);
            } else {
                return (double) ((Math.max(nums1Left, nums2Left) + Math.min(nums1Right, nums2Right))) / 2;
            }
        }
    }
    public static void main(String[] args){
        Solution solution = new Solution();
        int [] nums1 = {1,2};
        int [] nums2 = {3,4};
        System.out.println(solution.findMedianSortedArrays(nums1,nums2));
    }
}
