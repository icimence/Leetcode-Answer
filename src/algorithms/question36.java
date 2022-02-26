package algorithms;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class question36 {
    static class Solution {
        public boolean isValidSudoku(char[][] board) {
            Map<Character, Integer> rowChecker = new HashMap<>();
            Map<Character, Integer> columnChecker = new HashMap<>();
            Map<Character, Integer> gridChecker = new HashMap<>();
            //check row first
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] != '.')
                        rowChecker.put(board[i][j], rowChecker.getOrDefault(board[i][j], 0) + 1);
                    if (board[j][i] != '.')
                        columnChecker.put(board[j][i], columnChecker.getOrDefault(board[j][i], 0) + 1);
                }
                if (getMax(rowChecker.values()) > 1 || getMax(columnChecker.values()) > 1)
                    return false;
                rowChecker.clear();
                columnChecker.clear();
            }
            for (int i = 0; i < 9; i += 3) {
                for (int j = 0; j < 9; j += 3) {
                    for (int k = 0; k <= 2; k++) {
                        for (int l = 0; l <= 2; l++) {
                            if (board[i + k][j + l] != '.')
                                gridChecker.put(board[i + k][j + l], gridChecker.getOrDefault(board[i + k][j + l], 0) + 1);
                        }
                    }
                    if (getMax(gridChecker.values())> 1)
                        return false;
                    gridChecker.clear();
                }
            }
            return true;
        }

        private int getMax(Collection<Integer> nums) {
            int max = 0;
            for (int i : nums) {
                if (i > max)
                    max = i;
            }
            return max;
        }
    }
}
