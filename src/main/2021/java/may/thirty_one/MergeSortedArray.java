package may.thirty_one;

public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        if(nums1 == null || nums2 == null || m + n != nums1.length) return;

        // m n 分别转换为角标
        int i = m -1;
        int j = n - 1;
        int len = nums1.length - 1;

        while(i >=0 && j >=0){

            if(nums1[i] > nums2[j]){

                nums1[len--] = nums1[i--];
            }else{

                nums1[len--] = nums2[j--];
            }
        }

        // 如果nums2中还有数，则需要继续进行处理，否则nums1中原本的数不进行处理
        while (j >= 0) nums1[len--] = nums2[i--];
    }

    public static void main(String[] args) {

        MergeSortedArray ma = new MergeSortedArray();
        ma.merge(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3);
        System.out.println("aaaaaa");
    }
}
