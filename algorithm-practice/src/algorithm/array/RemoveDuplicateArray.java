package algorithm.array;

/**
 * @author chenjianhua
 * @Description 删除排序数组中的重复项
 * @see <a href= https://leetcode.cn/leetbook/read/top-interview-questions-easy/x2gy9m/>题目</a>
 * @title RemoveDuplicateArray
 * @date 2022/6/6
 */
public class RemoveDuplicateArray {

    /**
     * 双指针思路
     * @param nums
     * @return int
     * @author chenjianhua
     * @date 2022/6/9 10:54
     */
    public int removeDuplicatesOne(int[] nums) {
        //空数组校验
        if (nums == null || nums.length == 0){
            return 0;
        }
        //前提：排序数组.
        //思路：双指针处理：left指向第一个元素，right指向第二个元素。
        // 1,若两者指向元素不同,right指向的元素赋值给left指向元素的下一个元素,left+1
        // 2,若两者指向元素相等，left不变，right+1，指向下一个元素，再进行比较操作。
        // 这样交换可实现O(1)复杂度的算法
        int left = 0;
        for(int right = 1; right < nums.length; right++ ){
            if (nums[left] != nums[right]){
                nums[++left] = nums[right];
            }
        }
        return ++left;
    }

    /**
     * 直接交换位置思路
     * @param nums
     * @return int
     * @author chenjianhua
     * @date 2022/6/9 10:54
     */
    public int removeDuplicatesTwo(int[] nums) {
        //空数组校验
        if (nums == null || nums.length == 0){
            return 0;
        }
        //前提：排序数组.
        //思路：直接交换位置：将重复数量记录，不重复时，将第一个重复的数和当前数交换
        //重复的数一次次的后移
        int count = 0;
        for(int right = 1; right < nums.length; right++ ){
            if (nums[right] == nums[right - 1]){
                count++;
            } else{
                nums[right - count] = nums[right];
            }
        }
        return nums.length - count;
    }
}
