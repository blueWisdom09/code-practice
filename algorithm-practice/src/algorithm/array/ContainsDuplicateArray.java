package algorithm.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author chenjianhua
 * @Description 存在重复元素
 * @see <a href= https://leetcode.cn/leetbook/read/top-interview-questions-easy/x248f5/>题目</a>
 * @title ContainsDuplicate
 * @date 2022/6/14
 */
public class ContainsDuplicateArray {

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        boolean b = containsDuplicateOne(nums);
        System.out.println(b);
    }

    /**
     * 暴力求解
     * 提交结果超时
     * @param nums
     * @return boolean
     * @author chenjianhua
     * @date 2022/6/14 14:34
     */
    public static boolean containsDuplicateOne(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[i] == nums[j]){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 先排序在比较
     * @param nums
     * @return boolean
     * @author chenjianhua
     * @date 2022/6/14 14:44
     */
    public  boolean containsDuplicateTwo(int[] nums) {
        Arrays.sort(nums);
        //i=1,防止下标越界
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i - 1]){
                return true;
            }
        }
        return false;
    }

    /**
     * 利用set的add方法判断是否重复
     * @param nums
     * @return boolean
     * @author chenjianhua
     * @date 2022/6/14 14:47
     */
    public  boolean containsDuplicateThree(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)){
                return true;
            }
        }
        return false;
    }
}
