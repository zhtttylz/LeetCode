package may.eleven;

public class RotateImage {

    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length <= 1) return;

        int len = matrix.length - 1;
        // 指对matrix的一半进行旋转，如果matrix为奇数：中间不做操作 为偶数：/2没有小数，正好对一半进行操作
        // i为列
        for(int i = 0; i < matrix.length / 2; i++){

            // j为行
            for(int j = i; j < len - i; j++){
                System.out.println("aaaaaa");
                // 记录左上角的节点
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[len - j][i];
                matrix[len - j][i] = matrix[len - i][len - j];
                matrix[len - i][len - j] = matrix[j][len - i];
                matrix[j][len - i] = tmp;

            }
        }
    }

    public static void main(String[] args) {

        System.out.println(Math.log(1300) * 20);
        RotateImage r = new RotateImage();
        int[][] ints = {{1,2,3}, {4,5,6}, {7,8,9}};
        r.rotate(ints);
        System.out.println(ints);
    }
}
