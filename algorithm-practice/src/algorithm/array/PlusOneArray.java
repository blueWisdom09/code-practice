package algorithm.array;

/**
 * @author chenjianhua
 * @Description 数组加一
 * @see <a href= https://leetcode.cn/leetbook/read/top-interview-questions-easy/x2cv1c/>题目</a>
 * @title PlusOneArray
 * @date 2022/6/16
 */
public class PlusOneArray {

    /**
     * 判断最后元素是否为9，处理特殊情况：全为9.
     * @param digits
     * @return int[]
     * @author chenjianhua
     * @date 2022/6/16 10:48
     */
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            //先判断是否为9，不为9直接+1，返回
            if (digits[i] != 9){
                digits[i]++;
                return digits;
            }else{
                //若为9,则当前置0，下一位+1
                digits[i] = 0;
            }
        }
        //只有所有元素都是9，才会走到这里
        int[] temp = new int[digits.length + 1];
        temp[0] = 1;
        return temp;
    }
}
