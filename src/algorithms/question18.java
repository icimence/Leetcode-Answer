package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class question18 {
    static class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> res = new ArrayList<>();
            if (nums == null || nums.length < 4) {
                return res;
            }
            Arrays.sort(nums);
            int len = nums.length;
            for (int i = 0; i < len - 3; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int max = nums[i] + nums[len - 1] + nums[len - 2] + nums[len - 3];
                int min = nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3];
                if (min > target)
                    break;
                if (max < target)
                    continue;
                for (int j = i + 1; j < len - 2; j++) {
                    if (j > i + 1 && nums[j] == nums[j - 1])
                        continue;
                    int max1 = nums[i] + nums[j] + nums[len - 1] + nums[len - 2];
                    int min1 = nums[i] + nums[j] + nums[j + 1] + nums[j + 2];
                    if (min1 > target)
                        break;
                    if (max1 < target)
                        continue;
                    int k = j + 1;
                    int m = len - 1;
                    while (k < m) {
                        if (nums[i] + nums[j] + nums[k] + nums[m] == target) {
                            res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[m]));
                            k++;
                            m--;
                        } else {
                            if (nums[i] + nums[j] + nums[k] + nums[m] > target)
                                m--;
                            else
                                k++;
                        }
                    }
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }
}
