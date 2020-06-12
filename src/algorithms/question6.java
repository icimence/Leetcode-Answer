package algorithms;

import java.util.ArrayList;

public class question6 {
    static class Solution {
        public String convert(String s, int numRows) {
            if (numRows == 1)
                return s;
            ArrayList<StringBuilder> rows = new ArrayList<>();
            for (int i = 0; i < Math.min(numRows, s.length()); i++) {
                rows.add(new StringBuilder());
            }
            boolean goDown = false;
            int curRow = 0;
            for (char c : s.toCharArray()) {
                rows.get(curRow).append(c);
                if (curRow == numRows - 1 || curRow == 0)
                    goDown = !goDown;
                if (goDown)
                    curRow += 1;
                else
                    curRow -= 1;
            }
            StringBuilder res = new StringBuilder();
            for (StringBuilder temp : rows)
                res.append(temp);
            return res.toString();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.convert("LEETCODEISHIRING", 3));
    }
}
