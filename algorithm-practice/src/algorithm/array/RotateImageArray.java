package algorithm.array;

/**
 * @author chenjianhua
 * @Description 旋转图像
 * @title RotateImageArray
 * @date 2022/6/23
 */
public class RotateImageArray {

    /**
     * 1、上下反转
     * 2、对角线反转
     * @param matrix
     * @return void
     * @author chenjianhua
     * @date 2022/6/23 15:17
     */
    public void rotateImageOne(int[][] matrix) {
        int length = matrix.length;
        //先整体上下交换
        for(int i = 0; i < matrix.length / 2; i++){
            int[] temp = matrix[i];
            matrix[i] = matrix[length - i - 1];
            matrix[length - i - 1] = temp;
        }
        //再对角线交换
        for (int i = 0; i < length; i++) {
            for(int j = i + 1; j < length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

    }

    /**
     * 旋转九十度的元素交换
     * @param matrix
     * @return void
     * @author chenjianhua
     * @date 2022/6/23 15:30
     */
    public void rotateImageTwo(int[][] matrix) {
        int length = matrix.length;
        //直接循环，数组对称，则循环对角线的一半元素即可，全部循环为旋转180°
        for (int i = 0; i < length / 2; i++) {
            for(int j = i; j < length - i - 1; j++){
                //交换旋转90°后的四个元素，直到将一层的四边全部交换，
                int temp = matrix[i][j];
                matrix[i][j] = matrix[length - j - 1][i];
                matrix[length - j - 1][i] = matrix[length - i - 1][length - j - 1];
                matrix[length - i - 1][length - j - 1] = matrix[j][length - i - 1];
                matrix[j][length - i - 1] = temp;
            }
        }

    }

}
