package algorithms;

public class question7 {
    static class Solution {
        public int reverse(int x) {
            boolean negative = false;
            if (x<0){
                negative = true;
                x = -x;
            }
            StringBuilder temp = new StringBuilder(String.valueOf(x));
            int res = 0;
            try{
                res = negative ? -Integer.parseInt(temp.reverse().toString()) : Integer.parseInt(temp.reverse().toString());
            }
            catch (NumberFormatException ignored){
            }
            return res;
        }
    }
    static class SecondSolution {
        public int reverse(int x) {
            int rev = 0;
            while (x != 0) {
                int pop = x % 10;
                x /= 10;
                if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
                if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
                rev = rev * 10 + pop;
            }
            return rev;
        }
    }
    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.reverse(123));
    }
}
