package algorithms;

public class question43 {
    static class Solution {
        public String multiply(String num1, String num2) {
            if (num1.equals("0") || num2.equals("0"))
                return "0";
            int len1 = num1.length();
            int len2 = num2.length();
            String ans = "0";
            for (int i = len2 - 1; i >= 0; i--) {
                int current = 0;
                int add = 0;
                StringBuilder tempRes = new StringBuilder();
                for (int j = len2 - 1; j > i; j--) {
                    tempRes.append('0');
                }
                for (int j = len1 - 1; j >= 0; j--) {
                    int tempNum1 = num1.charAt(j) - '0';
                    int tempNum2 = num2.charAt(i) - '0';
                    int temp = tempNum1 * tempNum2;
                    current = add;
                    current += temp;
                    tempRes.append(current % 10);
                    add = current / 10;
                }
                if (add != 0)
                    tempRes.append(add);
                ans = stringAdd(ans, tempRes.reverse().toString());
            }
            return ans;
        }

        public String stringAdd(String num1, String num2) {
            int len1 = num1.length() - 1;
            int len2 = num2.length() - 1;
            StringBuilder res = new StringBuilder();
            int add = 0;
            while (len1 >= 0 || len2 >= 0) {
                int temp = add;
                if (len1 < 0){
                    temp += num2.charAt(len2) - '0';
                }
                else if (len2 < 0){
                    temp += num1.charAt(len1) - '0';
                }
                else
                    temp += num1.charAt(len1) - '0'+ num2.charAt(len2) - '0';
                res.append(temp % 10);
                add = temp / 10;
                len1--;
                len2--;
            }
            if (add != 0){
                res.append(add);
            }
            return res.reverse().toString();
        }
    }
}
