package algorithms;

import java.util.Set;
import java.util.HashSet;

public class question3 {
    static class Solution {
        public boolean contains(String s, char ch) {
            for (int i = 0; i < s.length(); i++) {
                if (ch == s.charAt(i))
                    return false;
            }
            return true;
        }

        public int lengthOfLongestSubstring(String s) {
            if(s.equals(""))
                return 0;
            int maxCount = 1;
            for (int i = 0; i < s.length(); i++) {
                int plus = 1;
                if ((i + plus) == s.length())
                    break;
                while (contains(s.substring(i, i + plus), s.charAt(i + plus))) {
                    plus += 1;
                    if (plus > maxCount)
                        maxCount = plus;
                    if (i + plus == s.length())
                        return maxCount;
                }
            }
            return maxCount;
        }
    }

    static class Answer {
        public int lengthOfLongestSubstring(String s) {
            Set<Character> temp = new HashSet<>();
            int pt = 0, res = 0;
            for (int i = 0; i < s.length(); i++) {
                if (i != 0)
                    temp.remove(s.charAt(i - 1));
                while (pt < s.length() && !temp.contains(s.charAt(pt))) {
                    temp.add(s.charAt(pt));
                    pt++;
                }
                res = Math.max(pt - i, res);
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Answer answer = new Answer();
        System.out.println("我的解法：");
        System.out.println(solution.lengthOfLongestSubstring(""));
        System.out.println("答案解法（貌似最优）：");
        System.out.println(answer.lengthOfLongestSubstring("pwwkew"));
    }
}
