package algorithm.string;

/**
 * @author chenjianhua
 * @see <a href= https://leetcode.cn/leetbook/read/top-interview-questions-easy/xnx13t/>题目</a>
 * @Description 整数反转
 * @title ReverseInteger
 * @date 2022/6/27
 */
public class ReverseInteger {

    /**
     * 直接取出数后，除10判断是否与原数是否相同
     * @param x
     * @return int
     * @author chenjianhua
     * @date 2022/6/27 17:38
     */
    public int reverseOne(int x) {
        int res = 0;
        while(x != 0){
            int t = x % 10;
            int newRes = res * 10 + t;
            //判断是否数字溢出
            if ((newRes - t) / 10 != res){
                return 0;
            }


            res = newRes;
            x = x/10;
        }
        return res;
    }

    /**
     * 取模与求余的区别
     *
     * a对b取余（取模）的过程
     * 1. c = a/b (对a/b的值取整)
     * 2. r = a - b*c （r为取余或取模的结果）
     * ※取余和取模的差别就在于取整的方法，取余是向0的方向舍入，取模的时候向无穷小的方向舍入。
     * 因此
     * ①当a和b符号相同时，a/b为正数，0与无穷小为同一方向。取模与取余相同。
     *
     * 如9/5 = 1.8 向0的方向舍入为1（即c = 1），取余结果为4。向无穷小的方向舍入为1（即c = 1），取模结果为4。
     *
     * ②当a和b符号不同时，a/b为负数，0与无穷小为不同方向。取模与取余不同。
     *
     * 如-9/5 = -1.8 向0的方向舍入为-1（即c = -1），取余结果为4。向无穷小的方向舍入为-2（即c = -2），取模结果为4。
     * ————————————————
     * 版权声明：本文为CSDN博主「DurableHumor」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
     * 原文链接：https://blog.csdn.net/my_clear_mind/article/details/70255550
     */

    /**
     * 通过公式推导得出边界条件，判断是否数字溢出（取模与求余的区别）
     * @see <a href= https://leetcode.cn/problems/reverse-integer/solution/zheng-shu-fan-zhuan-by-leetcode-solution-bccn/>官方题解</a>
     * @param x
     * @return int
     * @author chenjianhua
     * @date 2022/6/27 17:38
     */
    public int reverseTwo(int x) {
        int res = 0;
        while(x != 0){
            //判断是否数字溢出
            if (res > Integer.MAX_VALUE/10 || res < Integer.MIN_VALUE/10) {
                return 0;
            }
            int t = x % 10;
            res = res * 10 + t;
            x = x/10;
        }
        return res;
    }
}
