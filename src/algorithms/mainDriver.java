package algorithms;

import algorithms.*;

public class mainDriver {
    public static void main(String[] args) {
        var question38Solution = new question38.Solution();
        var question39Solution = new question39.Solution();
        var question39Answer = new question39.Answer();
        var question43Solution = new question43.Solution();
        var question42Solution = new question42.Solution();
        var dp = new DP();
        var coins = new int[]{1, 5, 11};
//        System.out.println(question38Solution.countAndSay(5));
        System.out.println(dp.coinChange(coins,17));
//        System.out.println(dp.makeChange(27000));
//        System.out.println(question39Answer.combinationSum2(new int[]{1},2));
//        System.out.println(question43Solution.multiply("123456789","987654321"));
//        System.out.println(question42Solution.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
