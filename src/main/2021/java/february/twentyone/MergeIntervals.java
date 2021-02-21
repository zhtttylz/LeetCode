package february.twentyone;

import java.util.*;

/**
 * @author zhtttylz
 * @date 2021/2/21 21:23
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {

        if(intervals == null || intervals.length == 0 || intervals.length == 1) return intervals;
        // 先按照start进行排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0]) return o1[1]-o2[1];
                return o1[0]-o2[0];
            }
        });

        // 对结果数组进行初始化
        List<int[][]> tmpRes = new ArrayList<>();
        tmpRes.add(new int[][]{{intervals[0][0],intervals[0][1]}});

        for(int i = 1; i < intervals.length; i++){

            int[][] tmp = tmpRes.get(tmpRes.size() - 1);

            // 因为已经排过序了,在有序情况下,当一个数组的右边界小于当前数组的左边界时,则说明没有交集
            if(tmp[0][1] < intervals[i][0]){

                tmpRes.add(new int[][]{{intervals[i][0],intervals[i][1]}});
            }else{

                // 如果有边界和左边界有交集,因为排过序,所以只需要计算最大的右边界即可
                tmp[0][1] = Math.max(tmp[0][1], intervals[i][1]);
            }
        }

        int[][] res = new int[tmpRes.size()][2];
        for(int i = 0 ; i < tmpRes.size(); i++){
            res[i] = tmpRes.get(i)[0];
        }

        return res;
    }

    public static void main(String[] args) {
        MergeIntervals m = new MergeIntervals();
        //[[1,3],[2,6],[8,10],[15,18]]
//        int[][] ints = new int[4][2];
//        ints[0][0] = 1;
//        ints[0][1] = 3;
//        ints[1][0] = 2;
//        ints[1][1] = 6;
//        ints[2][0] = 8;
//        ints[2][1] = 10;
//        ints[3][0] = 15;
//        ints[3][1] = 18;
        int[][] ints = new int[2][2];
        ints[0][0] = 1;
        ints[0][1] = 4;
        ints[1][0] = 0;
        ints[1][1] = 1;

        int[][] merge = m.merge(ints);
        System.out.println(merge);
    }
}
