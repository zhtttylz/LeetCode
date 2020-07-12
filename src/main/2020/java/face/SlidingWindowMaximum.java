package face;

import java.sql.SQLOutput;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.
 *
 * Follow up:
 * Could you solve it in linear time?
 *
 * Example:
 *
 * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * @author zhtttylz
 * @date 2020/7/12 14:13
 *
 *
 * 说明：queue先进先出，first就是最先放进去的元素，last就是最后的元素
 */
public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {

        if(nums == null || nums.length ==0 || nums.length < k) return nums;

        // 存放数组中元素的角标
        Deque<Integer> q = new ArrayDeque<Integer>();
        // 内容结果集，因为可以确定返回结果集的长度，所以使用数组
        int[] res = new int[nums.length - k + 1];

        for(int i = 0; i < nums.length; i++){

            // 删除队列中超过窗口大小的数组角标
            // 要避免初始化的情况
            if((i >= k) && (q.peek() < (i - k + 1))) q.remove();
            // 如果新加入的数大于窗口中的最右边的数,则直接将窗口最右边的数移除
            while(!q.isEmpty() && nums[q.peekLast()] < nums[i]) q.removeLast();

            q.add(i);
            // 如果窗口初始化完成,滑动窗口中最左边的数放入数组
            if(i - k + 1 >= 0){

                res[i- k + 1] = nums[q.peek()];
            }

        }
        return res;
    }


    public static void main(String[] args) {


        // 测试queue的各种方法
        Deque<Integer> queue = new ArrayDeque<Integer>();
        queue.add(10);
        queue.add(15);
        System.out.println(queue.peek());
        System.out.println(queue.peekLast());
        System.out.println(queue.peekFirst());
        System.out.println(queue.removeLast());
    }
}
