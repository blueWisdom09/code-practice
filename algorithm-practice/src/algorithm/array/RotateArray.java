package algorithm.array;

/**
 * @author chenjianhua
 * @Description 旋转数组
 * @see <a href= https://leetcode.cn/leetbook/read/top-interview-questions-easy/x2skh7/>题目</a>
 * @see <a href= https://leetcode.cn/problems/rotate-array/solution/xuan-zhuan-shu-zu-by-leetcode-solution-nipk/>题解</a>
 * @title RotateArray
 * @date 2022/6/13
 */
public class RotateArray {

    /**
     * 临时数组
     * @param nums
     * @param k
     * @return void
     * @author chenjianhua
     * @date 2022/6/13 15:20
     */
    public void rotateOne(int[] nums, int k) {
        int length = nums.length;
        int[] temp = new int[length];

        for (int i = 0; i < length; i++) {
            temp[i] = nums[i];
        }

        for (int i = 0; i < length; i++) {
            nums[(i + k) % length] = temp[i];
        }
    }

    public void rotateTwo(int[] nums, int k){
        int length = nums.length;
        k %= length;
        //反转全部
        reverse(nums, 0, length - 1);
        //反转前k个元素
        reverse(nums, 0, k - 1);
        //反转剩余元素
        reverse(nums, k, length - 1);

    }
    /**
     * 翻转数组
     * @param nums
     * @param start
     * @param end
     */
    private void reverse(int[] nums, int start, int end) {
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            start++;
            nums[end] = temp;
            end--;
        }
    }

    /**
     * 环形数组，每个元素向后移动k位
     * {1,2,3,4,5,6,7}为例，n=7,k=3,循环下标：3,6,2,5,1,4,0. 交换值：1,4,7,6,3,2,5
     * @param nums
     * @param k
     * @return void
     * @author chenjianhua
     * @date 2022/6/13 16:42
     */
    public void rotateThree(int[] nums, int k){
        int hold = nums[0];
        int index = 0;
        int length = nums.length;
        boolean[] visited = new boolean[length];
        for (int i = 0; i < length; i++) {
            index = (index + k) % length;
            //防止”原地打转”,当前元素已交换，就交换下一个元素
            if (visited[index]){
                index = (index + 1)%length;
                hold = nums[index];
                i--;
            }else{
                visited[index] = true;
                int temp = nums[index];
                nums[index] = hold;
                hold = temp;
            }

        }

    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int hold = nums[0];
        int index = 0;
        int length = nums.length;
        boolean[] visited = new boolean[length];
        int count = 0;
        for (int i = 0; i < length; i++) {
            index = (index + 3) % length;
            if (visited[index]){
             index = (index + 1)%length;
             hold = nums[index];
             i--;
            }else{
                visited[index] = true;
                int temp = nums[index];
                nums[index] = hold;
                hold = temp;
            }
            count++;

        }
        for (int i = 0; i < length; i++) {
            System.out.println(nums[i]);
        }
        System.out.println(count);
        System.out.println("--------------------------------------");
/*        rotate(nums,3);*/
    }


    /**
     * 官方题解
     * @param nums
     * @param k
     * @return void
     * @author chenjianhua
     * @date 2022/6/14 14:11
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int count = gcd(k, n);
        for (int start = 0; start < count; ++start) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
            } while (start != current);
        }
    }

    /**
     * 找出最大公约数
     * @param x
     * @param y
     * @return
     */
    public int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }


}
