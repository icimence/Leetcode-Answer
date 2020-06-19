package algorithms;

import java.util.ArrayList;

public class question20 {
    static class Solution {
        public boolean isValid(String s) {
            ArrayList<Integer> deque = new ArrayList<>();
            for (char c : s.toCharArray()) {
                switch (c) {
                    case '(':
                        deque.add(1);
                        break;
                    case ')':
                        if (deque.size() == 0 || deque.get(deque.size() - 1) != 1)
                            return false;
                        else
                            deque.remove(deque.size() - 1);
                        break;
                    case '[':
                        deque.add(2);
                        break;
                    case ']':
                        if (deque.size() == 0 || deque.get(deque.size() - 1) != 2)
                            return false;
                        else
                            deque.remove(deque.size() - 1);
                        break;
                    case '{':
                        deque.add(3);
                        break;
                    case '}':
                        if (deque.size() == 0 || deque.get(deque.size() - 1) != 3)
                            return false;
                        else
                            deque.remove(deque.size() - 1);
                        break;
                    default:
                        break;
                }
            }
            return deque.size() <= 0;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("(]()"));
    }
}
