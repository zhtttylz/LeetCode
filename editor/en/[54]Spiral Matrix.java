//Given an m x n matrix, return all elements of the matrix in spiral order. 
//
// 
// Example 1: 
//
// 
//Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
//Output: [1,2,3,6,9,8,7,4,5]
// 
//
// Example 2: 
//
// 
//Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//Output: [1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
// Constraints: 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics Array 
// 👍 3847 👎 670


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new ArrayList<>();

        List<Integer> res = new ArrayList<>();

        int len = matrix[0].length > matrix.length ? (matrix.length + 1) / 2 : (matrix[0].length + 1) / 2;

        // 表示当前遍历环的高度和宽度，当此值为1的时候，说明只有一条，直接退出
        int p = matrix.length;
        int q = matrix[0].length;

        // 左顶点，每次环收缩2位
        // 遍历方式 123  69  87 4
        for (int i = 0; i < len; i++, p -=2, q -= 2 ) {

            for(int a = i; a < i + q; a++){

                res.add(matrix[i][a]);
            }

            for(int a = i + 1; a < i + p; a++){

                res.add(matrix[a][q + i - 1]);
            }

            // 如果如果当前剩余的是竖着的或者横着的一条 直接退出
            if(p == 1 || q == 1) break;

            // -1代表角标 再-1 代表最右边已经在上一次被遍历过了
            // +i 代表真正的右边界
            for(int a = q - 2 + i; a >= i; a--){

                res.add(matrix[p - 1 + i][a]);
            }

            for(int a = p - 2 + i; a > i; a--){

                res.add(matrix[a][i]);
            }

        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
