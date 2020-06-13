package algorithms;

public class question9 {
    static class Solution {
        public boolean isPalindrome(int x) {
            String temp = String.valueOf(x);
            return temp.equals(new StringBuilder(temp).reverse().toString());
        }
    }
    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(-12));
    }
}
