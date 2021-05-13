package may.thirteen;

/**
 * 无重复最长字串
 * 考虑使用字典来进行处理(无法使用字典，因为该数组)
 */
public class LongestSubstringWithoutRepeatingCharacter {

    public int lengthOfLongestSubstring(String s) {

        if(s == null || s.length() == 0) return 0;

        int res = 1;
        // 左指针
        int left = 0;
        // 右指针 初始化窗口大小为1
        int right = 1;

        // 不停遍历右边界
        for(; right < s.length(); right++){

            // 判断index是否在left和right之间
            int index = help(s, left, right);

            // 如果窗口中有相同的值，则更新左指针的值
            if(index != -1){

                res = Math.max(res, right - left);
                left = index + 1;
            }
        }

        return Math.max(res, s.length() - left);
    }

    private int help(String s, int left, int right) {

        for(int i = left; i < right; i++){

            if(s.charAt(i) == s.charAt(right)) return i;
        }

        return -1;
    }

    public static void main(String[] args) {

        LongestSubstringWithoutRepeatingCharacter l = new LongestSubstringWithoutRepeatingCharacter();
        System.out.println(l.lengthOfLongestSubstring("bbbbbbbb"));
    }
}
