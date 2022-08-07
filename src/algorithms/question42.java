package algorithms;

public class question42 {

    static class Solution {
        public int trap(int[] height) {
            int[] leftArray = new int[height.length];
            int[] rightArray = new int[height.length];

            leftArray[0] = 0;
            for (int i = 1; i < height.length; i++) {
                leftArray[i] = Math.max(leftArray[i - 1], height[i - 1]);
            }

            rightArray[height.length - 1] = 0;
            for (int i = height.length - 2; i >= 0; i--) {
                rightArray[i] = Math.max(rightArray[i + 1], height[i + 1]);
            }

            int sum = 0;
            for (int i = 0; i < height.length; i++) {
                int temp = Math.min(leftArray[i], rightArray[i]) - height[i];
                if (temp > 0) {
                    sum += temp;
                }
            }
            return sum;
        }
    }
}
