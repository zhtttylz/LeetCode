package top100;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * You may assume nums1 and nums2 cannot be both empty.
 *
 * Example 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * The median is 2.0
 * Example 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * The median is (2 + 3)/2 = 2.5
 * 使用二分的方式进行排序
 * 两个排序数组的中位数
 * @author zhtttylz
 * @date 2020/5/14 22:25
 */
public class MedianofTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if(nums1 == null && nums2 == null) return 0;

        if(nums1.length == 0) return (nums2[(nums2.length - 1) / 2] + nums2[(nums2.length) / 2]) * 1.0 / 2;

        if(nums2.length == 0) return (nums1[(nums1.length - 1) / 2] + nums1[(nums1.length) / 2]) * 1.0 / 2;

        int n1L = nums1.length;
        int n2L = nums2.length;

        // 两个数组求中位数 tip = ((n1 + n2 + 1) / 2  + (n1 + n2 + 2)/2) / 2
        return ( help(nums1, nums2, 0, 0, (n1L + n2L + 1) / 2) + help(nums1, nums2, 0, 0, (n1L + n2L + 2) / 2) ) * 1.0 / 2.0;
    }

    /**
     *
     * @param nums1
     * @param nums2
     * @param n1L 切分nums1的指针
     * @param n2L 切分nums2的指针
     * @param k 第几个数 移动标志位
     * @return
     */
    private double help(int[] nums1, int[] nums2, int n1L, int n2L, int k) {

        // 如果某个指针已经到达了数组的边缘
        if(n1L >= nums1.length) return nums2[n2L + k - 1];
        if(n2L >= nums2.length) return nums1[n1L + k - 1];
        // 返回两个数组的最左边的数
        if(k == 1) return Math.min(nums1[n1L], nums2[n2L]);

        // 判断是否越界 如果当前数组切不出来 k/2了，则直接返回一个int的最大值
        int n1Mid = (n1L + k / 2 > nums1.length) ? Integer.MAX_VALUE : nums1[n1L + k / 2 - 1];
        int n2Mid = (n2L + k / 2 > nums2.length) ? Integer.MAX_VALUE : nums2[n2L + k / 2 - 1];

        // 舍弃n2mid之前的所有数
        if(n1Mid > n2Mid){

            //派出了k/2个数，不能直接k/2 考虑奇数情况 5/2=2 排除两个数， k还剩下3个
            return help(nums1, nums2, n1L, n2L + k / 2, k - k / 2);

        }

        return help(nums1, nums2, n1L + k / 2, n2L, k - k / 2);
    }

}






/**
 * 之前的解法，可以作为参考
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) {

            return 0;
        }

        int nums1Len = nums1.length;
        int nums2Len = nums2.length;

        // 如果有一个数组为空的情况，直接在另一个数组中取中位数
        if (nums1.length == 0) {

            return (nums2[(nums2Len - 1) / 2] + nums2[nums2Len / 2]) * 1.0 / 2;
        }
        if (nums2.length == 0) {

            return (nums1[(nums1Len - 1) / 2] + nums1[nums1Len / 2]) * 1.0 / 2;
        }

        // tips + 1 + 2  odd-event length be in common used
        return (help(nums1, nums2, 0, 0, (nums1Len + nums2Len + 1) / 2)
                + help(nums1, nums2, 0, 0, (nums1Len + nums2Len + 2) / 2))/2;
    }

    /**
     * 使用二分法进行处理，将k不停的二分，然后在nums2和nums1去掉k的一半最后当k只剩下一个的时候
     * 直接返回两个指针指向的最小的那个
     * @param nums1
     * @param nums2
     * @param nums1Len
     * @param nums2Len
     * @param k
     * @return
     */
    private double help(int[] nums1, int[] nums2, int nums1Len, int nums2Len, int k) {

        // 如果数组已经遍历完成了，则直接在剩下的数组中寻找即可
        if(nums1Len >= nums1.length) return nums2[nums2Len + k - 1];
        if(nums2Len >= nums2.length) return nums1[nums1Len + k - 1];

        // 如果k为1，说明二分结束，取最小值,这里直接返回
        if(k == 1) return Math.min(nums1[nums1Len], nums2[nums2Len]);

        // 如果数组中不足以取出k/2长度的数列了，设置为最大值
        int midNum1 = ((nums1Len + k / 2) > nums1.length) ? Integer.MAX_VALUE : nums1[nums1Len + k / 2 - 1];
        int midNum2 = ((nums2Len + k / 2) > nums2.length) ? Integer.MAX_VALUE : nums2[nums2Len + k / 2 - 1];

        // 如果midNum1小，就要舍弃nums1中在midNum1之前的数
        if(midNum1 < midNum2){

            // 注意，因为k的奇偶性，所以要k-k/2，代表已经排除了k/2个数
            return help(nums1, nums2, nums1Len + k / 2, nums2Len, k - k/ 2);
        }else{

            return help(nums1, nums2, nums1Len, nums2Len + k / 2, k - k / 2);
        }

    }
}