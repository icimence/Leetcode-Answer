package algorithms;

public class question8 {
    static class Solution {
        public int myAtoi(String str) {
            boolean negFlag = false;
            boolean numberBegin = false;
            int res = 0;
            boolean isNeg = false;
            for (char c: str.toCharArray()){
                if (c == ' ') {
                    if (numberBegin)
                        break;
                }
                else if (c == '-' || c == '+'){
                    if (numberBegin || negFlag)
                        break;
                    else if(c == '-')
                        isNeg = true;
                    negFlag = true;
                    numberBegin = true;
                }
                else if (c >= '0' && c<='9'){
                    if (res == Integer.MAX_VALUE / 10){
                        if (c > '7'){
                            if (isNeg)
                                return Integer.MIN_VALUE;
                            else
                                return Integer.MAX_VALUE;
                        }
                    }
                    if (res > Integer.MAX_VALUE/10){
                        if (isNeg)
                            return Integer.MIN_VALUE;
                        else
                            return Integer.MAX_VALUE;
                    }
                    res = res * 10 + Integer.parseInt(String.valueOf(c));
                    numberBegin = true;
                }
                else{
                    break;
                }
            }
            if (isNeg) {
                res = -res;
            }
            return res;
        }
    }
    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.myAtoi("2147483648\""));
    }
}

