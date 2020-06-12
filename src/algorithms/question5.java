package algorithms;

public class question5 {
    static class Solution {
        public String longestPalindrome(String s) {
            String res = "";
            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j <= i; j++) {
                    String substring = s.substring(j, j + s.length() - i);
                    if (judge(substring) && (s.length() - i) > res.length())
                        res = substring;
                }
            }
            return res;
        }

        public boolean judge(String s) {
            StringBuilder temp = new StringBuilder(s);
            return temp.reverse().toString().equals(s);
        }
    }

    static class dpSolution {
        public String longestPalindrome(String s) {
            int len = s.length();
            boolean[][] dp = new boolean[len][len];
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    dp[i][j] = false;
                }
            }
            String ans = "";
            for (int l = 0; l < len; l++) {
                for (int i = 0; i + l < len; i++) {
                    int j = i + l;
                    if (l == 0)
                        dp[i][j] = true;
                    else {
                        boolean b = s.charAt(i) == s.charAt(j);
                        if (l == 1)
                            dp[i][j] = b;
                        else
                            dp[i][j] = (dp[i + 1][j - 1] && b);
                    }
                    if (dp[i][j] && l + 1 > ans.length())
                        ans = s.substring(i, j + 1);
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        dpSolution dpSolution = new dpSolution();
        System.out.println(solution.longestPalindrome("cyyoacmjwjubfkzrrbvquqkwhsxvmytmjvbborrtoiyotobzjmohpadfrvmxuagbdczsjuekjrmcwyaovpiogspbslcppxojgbfxhtsxmecgqjfuvahzpgprscjwwutwoiksegfreortttdotgxbfkisyakejihfjnrdngkwjxeituomuhmeiesctywhryqtjimwjadhhymydlsmcpycfdzrjhstxddvoqprrjufvihjcsoseltpyuaywgiocfodtylluuikkqkbrdxgjhrqiselmwnpdzdmpsvbfimnoulayqgdiavdgeiilayrafxlgxxtoqskmtixhbyjikfmsmxwribfzeffccczwdwukubopsoxliagenzwkbiveiajfirzvngverrbcwqmryvckvhpiioccmaqoxgmbwenyeyhzhliusupmrgmrcvwmdnniipvztmtklihobbekkgeopgwipihadswbqhzyxqsdgekazdtnamwzbitwfwezhhqznipalmomanbyezapgpxtjhudlcsfqondoiojkqadacnhcgwkhaxmttfebqelkjfigglxjfqegxpcawhpihrxydprdgavxjygfhgpcylpvsfcizkfbqzdnmxdgsjcekvrhesykldgptbeasktkasyuevtxrcrxmiylrlclocldmiwhuizhuaiophykxskufgjbmcmzpogpmyerzovzhqusxzrjcwgsdpcienkizutedcwrmowwolekockvyukyvmeidhjvbkoortjbemevrsquwnjoaikhbkycvvcscyamffbjyvkqkyeavtlkxyrrnsmqohyyqxzgtjdavgwpsgpjhqzttukynonbnnkuqfxgaatpilrrxhcqhfyyextrvqzktcrtrsbimuokxqtsbfkrgoiznhiysfhzspkpvrhtewthpbafmzgchqpgfsuiddjkhnwchpleibavgmuivfiorpteflholmnxdwewj"));
        System.out.println(dpSolution.longestPalindrome("babad"));
    }
}
