package backup;

/**
 * 复盘两个有序数组求中位数 复盘一次 主要是什么时候使用k-1和看不明白
 * @author zhtttylz
 * @date 2020/6/6 13:26
 */
public class MedianofTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if(nums1 == null & nums2 == null) return 0;

        if(nums1 == null) return (nums2[nums2.length / 2]  + nums2[(nums2.length - 1) / 2]) / 2;

        if(nums2 == null) return (nums1[nums1.length / 2]  + nums1[(nums1.length - 1) / 2]) / 2;

        int len1 = nums1.length;
        int len2 = nums2.length;

        // 中位数规则 nums[len / 2] + nums[(len - 1) / 2]
        return (help(0, nums1, 0, nums2, (len1 + len2 + 1) / 2)
                + help(0, nums1, 0, nums2, (len1 + len2 + 2) / 2 )) / 2;

    }

    /**
     *
     * @param nums1Start 切分后 nums1的开始位置
     * @param nums1
     * @param nums2Start
     * @param nums2
     * @param k 需要找到的第k个数（不是角标，如果要把k带入求和，要-1）也可以理解为指针右移几位
     * @return
     */
    private double help(int nums1Start, int[] nums1, int nums2Start, int[] nums2, int k) {

        // 说明nums1切不出来 直接在nums2中切
        if(nums1Start >=  nums1.length) return nums2[nums2Start + k - 1];
        if(nums2Start >= nums2.length) return nums1[nums1Start + k - 1];
        if(k == 1) return Math.min(nums1[nums1Start], nums2[nums2Start]);

        // 先切 k / 2大小, 如果一个数组切不出来，则直接不考虑这个数组了，将n变为最大，
        int n1 = ((nums1Start + k / 2)  > nums1.length) ? Integer.MAX_VALUE : nums1[nums1Start + k / 2 - 1];
        int n2 = ((nums2Start + k / 2) > nums2.length) ? Integer.MAX_VALUE : nums2[nums2Start + k / 2 - 1];

        // 直接抛弃n1 k + start后面的数字，因为其<k/2这个数,所以直接舍弃
        if(n2 > n1){

            // 这里为什么不是 + k /2 -1 呢,因为k /2 -1已经比较过了,下次比较远不用再带上他了,直接切掉
            return help(nums1Start + k / 2, nums1, nums2Start, nums2, k - k / 2);
        }else{

            return help(nums1Start, nums1, nums2Start + k / 2, nums2, k - k / 2);
        }
    }
}
