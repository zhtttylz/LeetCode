package march.twenty_six;

import java.util.*;

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {

        if(nums == null || nums.length == 0 || k == 0) return nums;

        // 三次循环  1.求出每个数出现了多少次  2.对出现了多少次进行排序 3.拿出前k个数

        Map<Integer, Integer> map = new HashMap<>();
        //按照出现次数进行排序
        Queue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        // 记录每个数及他们的出现次数
        for(int i = 0; i < nums.length; i++){

            map.put(nums[i], map.getOrDefault(new Integer(nums[i]), 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.offer(entry);
        }

        int[] res = new int[k];

        for(int i = 0; i < k; i++){

            res[i] = queue.poll().getKey();
        }

        return res;
    }
}
