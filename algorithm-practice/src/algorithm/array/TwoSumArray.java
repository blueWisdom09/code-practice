package algorithm.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenjianhua
 * @Description 两数之和
 * @see <a href= https://leetcode.cn/leetbook/read/top-interview-questions-easy/x2jrse/>题目</a>
 * @title TwoSumArray
 * @date 2022/6/17
 */
public class TwoSumArray {

    /**
     * 暴力破解(双层for循环)
     * @param nums
     * @param target
     * @return int[]
     * @author chenjianhua
     * @date 2022/6/17 10:58
     */
    public int[] twoSumOne(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }

    /**
     * 利用map处理
     * @param nums
     * @param target
     * @return int[]
     * @author chenjianhua
     * @date 2022/6/17 13:40
     */
    public int[] twoSumTwo(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(target - nums[i]) != null){
                return new int[]{map.get(target - nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }

    /**
     * 利用map处理(优化版本一：get方法换为containsKey方法)
     * @param nums
     * @param target
     * @return int[]
     * @author chenjianhua
     * @date 2022/6/17 13:44
     */
    public int[] twoSumThree(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }

    /**
     * 利用map处理(优化版本二：双指针处理)
     * @param nums
     * @param target
     * @return int[]
     * @author chenjianhua
     * @date 2022/6/17 13:57
     */
    public int[] twoSumFour(int[] nums, int target) {
        if (nums == null || nums.length < 2){
            return new int[]{};
        }
        Map<Integer, Integer> map = new HashMap<>();
        int start = 0;
        int end = nums.length - 1;
        while (start <= end){
            int startDeduction = target - nums[start];
            if (map.containsKey(startDeduction)){
                return new int[]{start,map.get(startDeduction)};
            }else{
                map.put(nums[start],start++);
            }

            int endDeduction = target - nums[end];
            if (map.containsKey(endDeduction)){
                return new int[]{end,map.get(endDeduction)};
            }else{
                map.put(nums[end],end--);
            }
        }
        return new int[]{};
    }



}
