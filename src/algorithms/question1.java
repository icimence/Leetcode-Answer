package algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class question1 {
    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            int[] res = {0, 0};
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        res[0] = i;
                        res[1] = j;
                    }
                }
            }
            return res;
        }
    }
    static class Solution2 {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], i);
            }
            for (int i = 0; i < nums.length; i++) {
                int complement = target - nums[i];
                if (map.containsKey(complement) && map.get(complement) != i) {
                    return new int[] { i, map.get(complement) };
                }
            }
            throw new IllegalArgumentException("No two sum solution");
        }
    }
    static class BestSolution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int complement = target - nums[i];
                if (map.containsKey(complement)) {
                    return new int[] { map.get(complement), i };
                }
                map.put(nums[i], i);
            }
            throw new IllegalArgumentException("No two sum solution");
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        BestSolution bestSolution = new BestSolution();
        int[] nums = {2, 7, 11, 15};
        System.out.println("解法一：");
        System.out.println(Arrays.toString(solution.twoSum(nums, 9)));
        System.out.println("解法二：");
        System.out.println(Arrays.toString(solution2.twoSum(nums, 9)));
        System.out.println("最优解法：");
        System.out.println(Arrays.toString(bestSolution.twoSum(nums, 9)));
    }

}
