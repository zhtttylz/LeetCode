package November.eleven;

/**
 * @author zhtttylz
 * @date 2019/11/11 22:45
 */
public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {


        if (nums1.length == 0 && nums2.length == 0) {

            return 0;
        }

        // 如果有一个数组为空的情况，直接在另一个数组中取中位数
        if (nums1.length == 0) {

            return (nums2[(nums2.length - 1) / 2] + nums2[nums2.length / 2]) / 2;
        }
        if (nums2.length == 0) {

            return (nums1[(nums1.length - 1) / 2] + nums1[nums1.length / 2]) / 2;
        }

        // 最简单的方式就是合并两个数组，归并排序的方式
        // 能否采用两个指针的方式不进行归并
        return (help(nums1, nums2, (nums1.length + nums2.length - 1) / 2)
                + help(nums1, nums2, (nums1.length + nums2.length) / 2)) / 2;
    }

    /**
     * target在nums1和nums2中的位置
     *
     * @param nums1
     * @param nums2
     * @param target
     * @return
     */
    private double help(int[] nums1, int[] nums2, int target) {

        int res = 0;

        int n1Index = 0;
        int n2Index = 0;

        while (target != 0) {

            if (nums1[n1Index] < nums2[n2Index]) {

                target--;
                // 这里要注意其中一个数组已经全部遍历完成的情况的情况
                if (n1Index < nums1.length) {
                    // 如果nums1还有接下来的元素，那么将n1Index++，否则将n2Index++
                    n1Index++;

                    // 记录最后指针移动的值的值
                    res = nums1[n1Index];
                } else {
                    n2Index++;
                    res = nums2[n2Index];
                }
            } else {

                target--;
                // 这里要注意其中一个数组已经全部遍历完成的情况的情况
                if (n2Index < nums2.length) {
                    // 如果nums1还有接下来的元素，那么将n1Index++，否则将n2Index++
                    n1Index++;
                    res = nums1[n1Index];
                } else {
                    n2Index++;
                    res = nums1[n1Index];
                }
            }
            System.out.println(res);
        }

        return res;
    }

    public static void main(String[] args) {

//        Solution s = new Solution();
//        double medianSortedArrays = s.findMedianSortedArrays(new int[]{1, 3}, new int[]{2});
//        System.out.println(medianSortedArrays);

        int a = 2;
        int b = 3;
        double aa = 5 * 1.0 / 2;
        System.out.println(aa);
    }
}
