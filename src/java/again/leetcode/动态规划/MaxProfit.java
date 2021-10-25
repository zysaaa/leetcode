package again.leetcode.动态规划;


public class MaxProfit {

    public int maxProfit(int[] prices) {

        if (prices == null || prices.length == 0) {
            return 0;
        }


        int result = 0;

        int buy = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > buy) {
                result = Math.max(prices[i] - buy, result);
            } else {
                buy = prices[i];
            }
        }
        return result;

    }
}
