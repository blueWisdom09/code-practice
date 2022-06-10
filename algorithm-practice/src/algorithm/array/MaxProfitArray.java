package algorithm.array;

/**
 * @author chenjianhua
 * @Description 买卖股票的最佳时机 II （在任何时候 最多 只能持有 一股 股票）
 * @See https://leetcode.cn/leetbook/read/top-interview-questions-easy/x2zsx1/
 * @title MaxProfitArray
 * @date 2022/6/9
 */
public class MaxProfitArray {

    /**
     * 动态规划
     *
     * @param prices
     * @return int
     * @author chenjianhua
     * @date 2022/6/9 10:54
     */
    public int maxProfitOne(int[] prices) {
        //排除异常情况
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int[][] day = new int[prices.length][2];
        //当天未持有股票，利润:1、未发生任何交易，2、将股票卖出（昨天一定将购入股票） day[i][0] = max(day[i-1][0]，day[i-1][1]+prices[i]);
        //当天购入股票后，利润:1、未发生任何交易,2、买入股票（昨天一定将股票卖出） day[i][1] = max(day[i-1][1],day[i-1][0]-prices[i]);
        //最终结果一定是当天未持有股票的利润高
        //初始值
        day[0][0] = 0;
        day[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            day[i][0] = Integer.max(day[i - 1][0], day[i - 1][1] + prices[i]);
            day[i][1] = Integer.max(day[i - 1][1], day[i - 1][0] - prices[i]);
        }
        return day[prices.length][0];
    }

    /**
     * 动态规划优化版（二维数组转为变量）
     *
     * @param prices
     * @return int
     * @author chenjianhua
     * @date 2022/6/9 13:16
     */
    public int maxProfitTwo(int[] prices) {
        //排除异常情况
        if (prices == null || prices.length < 2) {
            return 0;
        }
        //当天未持有股票，利润:1、未发生任何交易，2、将股票卖出 day[i][0] = max(day[i-1][0]，day[i-1][1]+prices[i]);
        //当天购入股票后，利润:1、未发生任何交易,2、买入股票 day[i][1] = max(day[i-1][1],day[i-1][0]-prices[i]);
        //最终结果一定是当天未持有股票的利润高
        //初始值
        int hold = -prices[0];
        int throwHold = 0;
        for (int i = 1; i < prices.length; i++) {
            throwHold = Integer.max(throwHold, hold + prices[i]);
            hold = Integer.max(hold, throwHold - prices[i]);
        }
        return throwHold;
    }


    /**
     * 贪心算法 找到上涨前的最小值和上涨最大值，取差值
     *
     * @param prices
     * @return int
     * @author chenjianhua
     * @date 2022/6/9 13:42
     */
    public int maxProfitThree(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int index = 0;
        int total = 0;
        while (index < prices.length) {
            //上涨前最小值
            while (index < prices.length - 1 && prices[index] >= prices[index + 1]) {
                index++;
            }
            int min = prices[index];
            //上涨峰值
            while (index < prices.length - 1 && prices[index] <= prices[index + 1]) {
                index++;
            }
            total += prices[index++] - min;
        }
        return total;
    }

    /**
     * 贪心算法,直接收集正收入，求和，得到最终利润
     *
     * @param prices
     * @return int
     * @author chenjianhua
     * @date 2022/6/10 15:16
     */
    public int maxProfitFour(int[] prices) {
        int total = 0;
        for (int i = 1; i < prices.length; i++) {
            total += Math.max(0, prices[i] - prices[i - 1]);
        }
        return total;
    }
}
