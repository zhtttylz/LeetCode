package bak.两个有序数组中位数;

/**
 * 两个有序数组求中位数
 */
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if(nums1 == null && nums2 == null) return 0;

        int n = nums1.length;
        int m = nums2.length;

        // 两个数组长度和如果是奇数 则n + m + 1 / 2不变
        // 两个数组长度和如果是偶数，则n + m + 2 + n + m + 1 / 2正好为结果
        return (help(nums1, 0, nums2, 0, (n + m + 1) / 2)
                + help(nums1, 0, nums2, 0, (n + m + 2) / 2)) / 2.0;
    }

    private double help(int[] nums1, int i, int[] nums2, int j, int k) {

        // 如果数组1已经切完了，直接返回数组2指定位置的数
        if (i >= nums1.length) return nums2[j + k - 1];
        if (j >= nums2.length) return nums1[i + k - 1];
        if (k == 1) return Math.min(nums1[i], nums2[j]);

        int midVal1 = (i + k / 2 - 1 < nums1.length) ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int midVal2 = (j + k / 2 - 1 < nums2.length) ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;

        if (midVal1 < midVal2) {

            return help(nums1, i + k / 2, nums2, j, k - k / 2);
        } else {

            return help(nums1, i, nums2, j + k / 2, k - k / 2);
        }
    }
}
