package algorithm.array;

import java.util.*;

/**
 * @author chenjianhua
 * @Description 两个数组的交集II
 * @see <a href= https://leetcode.cn/leetbook/read/top-interview-questions-easy/x2y0c2/>题目</a>
 * @title IntersectArray
 * @date 2022/6/15
 */
public class IntersectArray {


    /**
     * 先排序再比较，双指针移动
     *
     * @param nums1
     * @param nums2
     * @return int[]
     * @author chenjianhua
     * @date 2022/6/15 16:25
     */
    public int[] intersectOne(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        List<Integer> list = new ArrayList<>();
        while (i < nums1.length && j < nums2.length) {
            //哪个值小，哪个指针就后移一位
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                //重复，同时后移
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        int index = 0;
        int[] resultArray = new int[list.size()];
        for (Integer integer : list) {
            resultArray[index] = integer;
            index++;
        }
        return resultArray;
    }

    /**
     * 利用map的特性
     *
     * @param nums1
     * @param nums2
     * @return int[]
     * @author chenjianhua
     * @date 2022/6/15 16:44
     */
    public int[] intersectTwo(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            //记录元素，以及在数组中出现的次数
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (map.getOrDefault(nums2[i], 0) > 0) {
                list.add(nums2[i]);
                //减少次数
                map.put(nums2[i], map.get(nums2[i]) - 1);
            }
        }
        int index = 0;
        int[] resultArray = new int[list.size()];
        for (Integer integer : list) {
            resultArray[index] = integer;
            index++;
        }
        Arrays.copyOfRange(resultArray, 0, index);
        return resultArray;
    }

    /**
     * 官方优化版本 map 减少了集合转化为数组的操作
     * @param nums1
     * @param nums2
     * @return int[]
     * @author chenjianhua
     * @date 2022/6/15 17:36
     */
    public int[] intersectThree(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersectThree(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            //记录元素，以及在数组中出现的次数
            int count = map.getOrDefault(nums1[i], 0) + 1;
            map.put(nums1[i], count);
        }
        int[] resultArray = new int[nums1.length];
        int index = 0;
        for (int i = 0; i < nums2.length; i++) {
            int count = map.getOrDefault(nums2[i], 0);
            if (count > 0) {
                resultArray[index++] = nums2[i];
                //减少次数
                count--;
                if (count > 0) {
                    map.put(nums2[i], count);
                } else {
                    //清除元素
                    map.remove(nums2[i]);
                }
            }
        }
        return Arrays.copyOfRange(resultArray, 0, index);
    }

}
