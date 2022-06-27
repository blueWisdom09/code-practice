package algorithm.string;

/**
 * @author chenjianhua
 * @see <a href= https://leetcode.cn/leetbook/read/top-interview-questions-easy/xnhbqj/>题目</a>
 * @Description 反转字符串
 * @title ReverseString
 * @date 2022/6/24
 */
public class ReverseString {

    /**
     *
     * @param s
     * @return void
     * @author chenjianhua
     * @date 2022/6/27 16:47
     */
    public void reverseStringOne(char[] s) {
        int length = s.length;
        int left = 0;
        int right = length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    public void reverseStringTwo(char[] s) {
        if (s == null || s.length == 0){
            return;
        }
        reverseStringRecursion(s, 0, s.length - 1);
    }

    private void reverseStringRecursion(char[] s, int left, int right) {
        if(left > right) {
            return;
        }
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
        reverseStringRecursion(s,++left,--right);
    }


}
