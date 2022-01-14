package algorithms;

import java.util.*;

public class question32 {
    static class Solution {
        public int longestValidParentheses(String s) {
            int maxans = 0;
            Deque<Integer> stack = new LinkedList<Integer>();
            stack.push(-1);
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    stack.push(i);
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        stack.push(i);
                    } else {
                        maxans = Math.max(maxans, i - stack.peek());
                    }
                }
            }
            return maxans;
        }
    }


    public static void main(String[] args) {
        String s = "(()()))()()";
        Solution solution = new Solution();
        System.out.println(solution.longestValidParentheses(s));
    }
}
