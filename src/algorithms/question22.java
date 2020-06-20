package algorithms;
import java.net.Socket;
import java.util.List;
import java.util.ArrayList;
public class question22 {
    static class Solution {
        ArrayList<String> res = new ArrayList<>();
        public List<String> generateParenthesis(int n) {
            dfs("",n,n);
            return res;
        }
        public void dfs(String curr,int left,int right){
            if (left == 0 && right == 0){
                res.add(curr);
                return;
            }
            if (left>right)
                return;
            if (left>0){
                dfs(curr+"(",left-1,right);
            }
            if (right>0)
                dfs(curr+")",left,right-1);
        }
    }
    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.generateParenthesis(2));
    }
}
