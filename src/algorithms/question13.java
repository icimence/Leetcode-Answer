package algorithms;

public class question13 {
    static class Solution {
        public int romanToInt(String s) {
            int[] values = {1000, 500, 100, 50, 10, 5, 1};
            String symbols = "MDCLXVI";
            int prev = 0;
            int res = 0;
            boolean plus = false;
            for (char c : s.toCharArray()) {
                int tempVal = values[symbols.indexOf(c)];
                res += tempVal;
                if (tempVal > prev) {
                    res -= 2 * prev;
                }
                prev = tempVal;
            }
            return res;
        }
    }

    static class Solution2 {
        public int romanToInt(String s) {
            int sum = 0;
            int preNum = getValue(s.charAt(0));
            for (int i = 1; i < s.length(); i++) {
                int num = getValue(s.charAt(i));
                if (preNum < num) {
                    sum -= preNum;
                } else {
                    sum += preNum;
                }
                preNum = num;
            }
            sum += preNum;
            return sum;
        }

        private int getValue(char ch) {
            switch (ch) {
                case 'I':
                    return 1;
                case 'V':
                    return 5;
                case 'X':
                    return 10;
                case 'L':
                    return 50;
                case 'C':
                    return 100;
                case 'D':
                    return 500;
                case 'M':
                    return 1000;
                default:
                    return 0;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.romanToInt("MCMXCIV"));
    }
}
