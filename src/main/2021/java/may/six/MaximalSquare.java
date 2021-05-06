package may.six;

/**
 * [LeetCode] 221. Maximal Square 最大正方形
 * 全部由1组成的最大正方形，返回其面积
 * 确定左顶点，通过直方图原理进行扩散和排查是否有0的存在
 */
public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {

        if(matrix == null || matrix.length == 0) return 0;
        int res = 0;

        // 左上顶点
        for(int i = 0; i < matrix.length; i++){

            // 计算每一行从i到j的列的1的和
            int[] tmp = new int[matrix[i].length];

            // 左下顶点，这里确定高度j
            for(int j = i; j< matrix.length; j++){

                // 计算从j行每一列的1的个数
                for(int a = 0; a < matrix[j].length; a++){
                    if(matrix[j][a] == '1') tmp[a] += 1;
                }

                // 计算当前列组成的直方图中的最大的正方形
                res = Math.max(res, help(tmp, j - i + 1));
            }
        }

        return res;
    }

    private int help(int[] tmp, int i) {

        // 计算是否有连续的高度为k的列
        int count = 0;

        for(int a = 0; a < tmp.length; a++){

            // 如果某一列1的综合不等于高度，将count变为0
            if(tmp[a] != i) count = 0;
            else count++;

            // 如果在j - i + 1为高 的直方图中，存在连续的高为j - i + 1的列，将值返回
            if(count == i) return count * count;
        }

        return 0;
    }
}
