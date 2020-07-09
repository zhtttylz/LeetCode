package face;

import javax.management.QueryEval;
import java.util.PriorityQueue;

/**
 * Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * <p>
 * Your KthLargest class will have a constructor which accepts an integer k and an integer array nums, which contains initial elements from the stream. For each call to the method KthLargest.add, return the element representing the kth largest element in the stream.
 * <p>
 * Example:
 * <p>
 * int k = 3;
 * int[] arr = [4,5,8,2];
 * KthLargest kthLargest = new KthLargest(3, arr);
 * kthLargest.add(3);   // returns 4
 * kthLargest.add(5);   // returns 5
 * kthLargest.add(10);  // returns 5
 * kthLargest.add(9);   // returns 8
 * kthLargest.add(4);   // returns 8
 * Note:
 * You may assume that nums' length ≥ k-1 and k ≥ 1.
 * 每次加入一个数后，反馈第k大的数，使用优先队列进行处理
 * @author zhtttylz
 * @date 2020/7/10 0:20
 */
public class KthLargest {

    private PriorityQueue<Integer> queue = null;

    private int k = 0;

    public KthLargest(int k, int[] nums) {

        this.k = k;
        this.queue = new PriorityQueue(k);
        for(int a : nums) add(a);
    }

    public int add(int val) {

        // 如果数组中的数不足k个，则直接添加，否则需要判断
        if(queue.size() < k) {

            queue.offer(val);
        }else if(val > queue.peek()){ // 需要将小队顶中最小的数去掉，然后加入

            queue.poll();
            queue.offer(val);
        }

        return queue.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
