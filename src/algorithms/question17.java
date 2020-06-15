package algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class question17 {
    static class Solution {
        Map<String, String> phone = new HashMap<String, String>() {{
            put("2", "abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "tuv");
            put("9", "wxyz");
        }};
        List<String> output = new ArrayList<>();

        public List<String> letterCombinations(String digits) {
            if (digits.length() != 0)
                resultOfTwo("",digits);
            return output;
        }

        public void resultOfTwo(String one, String two) {
            if (two.length() == 0)
                output.add(one);
            else {
                String firstCh = two.substring(0, 1);
                String letters = phone.get(firstCh);
                for (char c:letters.toCharArray()){
                    resultOfTwo(one+c,two.substring(1));
                }
            }
        }
    }
    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.letterCombinations("233"));
    }
}
