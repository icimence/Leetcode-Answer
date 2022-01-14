package algorithms;

import java.util.Arrays;

public class question31 {
    public static void nextPermutation(int[] nums) {
        int len = nums.length - 1;
        int start = -1;
        for (int i  = len; i > 0;i--){
            if (nums[i] > nums[i - 1]){
                start = i-1;
                break;
            }
        }
        if (start == -1){
            System.out.println(Arrays.toString(reverse(nums, 0)));
        }
        else{
            for (int i = len; i > start; i--){
                if (nums[i] > nums[start]){
                    int temp = nums[i];
                    nums[i] = nums[start];
                    nums[start] = temp;
                    System.out.println((Arrays.toString(reverse(nums, start + 1))));
                    break;
                }
            }
        }
    }

    public static int[] reverse(int[] nums, int start){
        int temp;
        int low = start;
        int high = nums.length -1;
        while(low <= high){
            temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;
            low++;
            high--;
        }
        return nums;
    }

    public static void printNums(int[] nums){
        for (int num : nums) {
            System.out.print(num);
        }
    }

    public static void main(String[] args){
        int[] nums = {2,2,0,4,3,1};
        nextPermutation(nums);
    }

}
