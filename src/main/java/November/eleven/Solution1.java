package November.eleven;

/**
 * @author zhtttylz
 * @date 2019/11/13 0:04
 */
public class Solution1 {

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
