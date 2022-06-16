package algorithm.array;

/**
 * @author chenjianhua
 * @Description 移动零
 * @see <a href="https://leetcode.cn/leetbook/read/top-interview-questions-easy/x2ba4i/"></a>
 * @title MoveZeroesArray
 * @date 2022/6/16
 */
public class MoveZeroesArray {

    /**
     * 先将非0元素都移动到前面，在将交换过的元素置0
     * @param nums
     * @return void
     * @author chenjianhua
     * @date 2022/6/16 11:05
     */
    public void moveZeroesOne(int[] nums) {
        if (nums == null || nums.length == 0){
            return;
        }
        //index为0元素的指针
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            //元素为不为0时，将元素赋值到0所在的元素位置
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        //将移动后的元素置0
        while(index < nums.length){
            nums[index++] = 0;
        }
    }

    public void moveZeroesTwo(int[] nums) {
        //index统计0元素的个数
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0){
                //0元素个数+1
                index++;
            } else if (index != 0) {
                //index!=0,即没有0元素时，不做任何操作
                //当前元素为不为0时，将当前元素赋值到相应的元素位置,i -index为第一个0的位置
                nums[i - index] = nums[i];
                nums[i] = 0;
            }
        }
    }



}
