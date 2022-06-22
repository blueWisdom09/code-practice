package algorithm.array;

/**
 * @author chenjianhua
 * @Description 有效的数独
 * @see <a href= https://leetcode.cn/leetbook/read/top-interview-questions-easy/x2f9gg/>题目</a>
 * @title IsValidSudokeArray
 * @date 2022/6/21
 */
public class IsValidSudokuArray {


    /**
     * 直接判断方法
     * 以下两行代码开始不懂其含义。
     * int num = board[i][j] - '0' - 1;
     * int k = i/3 * 3 + j/3;
     * @param board
     * @return boolean
     * @author chenjianhua
     * @date 2022/6/22 17:12
     */
    public boolean isValidSudokuOne(char[][] board) {
        int length = board.length;
        //行数组
        int[][] line = new int[length][length];
        //列数组
        int[][] column = new int[length][length];
        //块数组 以上数组标识该数字是否出现
        int[][] block = new int[length][length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.'){
                    continue;
                }
                //格子中的数字，将char类型数转为int数字: 减去'0'的ascii码48,
                int num = board[i][j] - '0' - 1;
                //k为第几块单元格,一行有三个3*3的单元格，先得出其在第几行的单元格中，再得出其在第几列的单元格中
                int k = i/3 * 3 + j/3;
                if (line[i][num] != 0 || column[j][num] != 0 || block[k][num] != 0){
                    return false;
                }
                line[i][num] = column[j][num] = block[k][num] = 1;
            }
        }
        return true;
    }

    /**
     * 位运算：利用9位上的1,在第几位, 通过&运算来判断是否出现。(按位与&:两位全为1,结果为1,否则为0)
     * 1、将1算术左移1~9位
     * 2、通过&运算来判断
     * 3、通过|运算将出现的数字记录
     * @param board
     * @return boolean
     * @author chenjianhua
     * @date 2022/6/22 17:43
     */
    public boolean isValidSudokuTwo(char[][] board){
        int[] line = new int[board.length];
        int[] column = new int[board.length];
        int[] block = new int[board.length];
        int shift = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.'){
                    continue;
                }
                //格子中的数字，将char类型数转为int数字: 减去'0'的ascii码48, 算术左移
                shift = 1 << (board[i][j] - '0');
                //k为第几块单元格,一行有三个3*3的单元格，先得出其在第几行的单元格中，再得出其在第几列的单元格中
                int k = i/3 * 3 + j/3;
                //按位与&判断
                if ((line[i] & shift) > 0 || (column[j] & shift) > 0 || (block[k] & shift) > 0){
                    return false;
                }
                //按位或| 两位有一个为1，结果为1，否则为0;
                line[i] |= shift;
                column[j] |= shift;
                block[k] |= shift;
            }
        }
        return true;
    }
}
