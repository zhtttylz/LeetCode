package April.twenty_seven;

import java.util.Arrays;
import java.util.Stack;

/**
 * 数组中每个数字为宽度为1的矩形的长度，求数组能够组成的最大矩形
 */
public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {

        if(heights == null || heights.length == 0) return 0;

        // 单调递增栈，可以保证左边的矩形可以和其右边的矩形组成高度为当前矩形高度的矩形 存放每个矩形的角标
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int res = 0;

        // 对每个数进行递归
        for(int i = 1; i < heights.length; i++){

            // 如果stack为空，或者当前是单调递增的，直接将其放入stack
            if(stack.isEmpty() || heights[stack.peek()] < heights[i]){

                stack.push(i);
            }else{

                // 拿出每一个大于当前位置的矩形，拿出来的矩形能组成的最大矩形的高是它本身(因为栈内元素是单调递增)
                // 长度是从stack顶端到当前位置 - 1(为什么是顶端:因为当前位置和栈顶端可能有被pop出去的矩形,要加上他们的长度)
                Integer cur = stack.pop();
                res = Math.max(res, heights[cur] * (stack.isEmpty() ? i : (i - stack.peek() - 1)));
                // 要持续对当前位置进行计算,直到能放入到数组中位置
                i--;
            }
        }

        // 如果stack不为空,说明都是递增的情况,因为数组已经遍历完了,所以以heights作为最右边的进行处理
        while(!stack.isEmpty()){

            Integer cur = stack.pop();
            res = Math.max(res, heights[cur] * (stack.isEmpty() ? heights.length : heights.length - 1 - stack.peek()));
        }

        return res;
    }

    public static void main(String[] args) {

        LargestRectangleInHistogram l = new LargestRectangleInHistogram();
        System.out.println(l.largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }
}
