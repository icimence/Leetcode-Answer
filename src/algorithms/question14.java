package algorithms;

public class question14 {
    static class Solution {
        public String longestCommonPrefix(String[] strs) {
            int len = Integer.MAX_VALUE;
            String res = "";
            for (String str : strs) {
                if (str.length() < len)
                    len = str.length();
            }
            for (int i = 1; i <= len; i++) {
                String temp = strs[0].substring(0, i);
                for (String str : strs) {
                    if (!str.substring(0, i).equals(temp))
                        return res;
                }
                res = temp;
            }
            return res;
        }
    }

    static class LCP {
        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 0) return "";
            String prefix = strs[0];
            for (int i = 1; i < strs.length; i++)
                while (strs[i].indexOf(prefix) != 0) {
                    prefix = prefix.substring(0, prefix.length() - 1);
                    if (prefix.isEmpty()) return "";
                }
            return prefix;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = {"dog", "dog", "dog"};
        System.out.println(solution.longestCommonPrefix(strs));
    }
}
