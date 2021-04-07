package April.seven;

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {

        if(s == null || t == null || s.length() == 0 || t.length() == 0) return "";
        // 窗口的左指针
        int left = 0;
        // 记录窗口中遍历了t中的几个元素
        int count = 0;
        // 记录窗口中出现元素的个数
        int[] nums = new int[128];

        // 记录窗口开始位置和长度
        int minstar = -1;
        int minlen = Integer.MAX_VALUE;
        // 记录t中的字符串出现的次数
        for (char c : t.toCharArray()) {
            nums[c]++;
        }

        // i是右指针
        for(int i = 0; i < s.length(); i++){
            // 减去右指针遇到的每个数，因为nums只包含t中的数，所以减去后>=0说明减去了t中的元素,更新count
            if(--nums[s.charAt(i)] >= 0) count++;
            // 窗口中已经包含了t中的所有元素
            while(count == t.length()){
                // 求长度,角标+1
                if(minlen > (i - left + 1)){
                    minlen = i - left + 1;
                    minstar = left;
                }
                // 左指针右移,移除包含元素,避免同一窗口中有重复元素
                if(++nums[s.charAt(left)] > 0) count--;
                left++;
            }

        }

        return minstar == -1 ? "" : s.substring(minstar, minstar + minlen);
    }
}
