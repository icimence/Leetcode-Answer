package algorithms;

public class question11 {
    static class Solution {
        public int maxArea(int[] height) {
            int l = 0, r = height.length - 1;
            int ans = 0;
            while (l < r) {
                int area = Math.min(height[l], height[r]) * (r - l);
                ans = Math.max(ans, area);
                if (height[l] <= height[r]) {
                    ++l;
                } else {
                    --r;
                }
            }
            return ans;
        }
    }
    public static void main(String[] args){
        Solution solution = new Solution();
        int[] nums= {1,8,6,2,5,4,8,3,7};
        System.out.println(solution.maxArea(nums));
    }
}
