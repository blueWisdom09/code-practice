package algorithm.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author chenjianhua
 * @Description 只出现一次数字
 * @see <a href= https://leetcode.cn/leetbook/read/top-interview-questions-easy/x21ib6/>题目</a>
 * @title SingleNumberArray
 * @date 2022/6/14
 */
public class SingleNumberArray {

    /**
     * 利用set集合
     * @param nums
     * @return int
     * @author chenjianhua
     * @date 2022/6/14 15:25
     */
    public int singleNumberOne(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                set.remove(num);
            }
        }
        return (int)set.toArray()[0];
    }

    /**
     * 利用位运算：异或
     *
     * a^a=0；自己和自己异或等于0
     * a^0=a；任何数字和0异或还等于他自己
     * a^b^c=a^c^b；异或运算具有交换律
     *
     * @param nums
     * @return int
     * @author chenjianhua
     * @date 2022/6/14 16:49
     */
    public int singleNumberTwo(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = result^nums[i];
        }
        return result;
    }


}
