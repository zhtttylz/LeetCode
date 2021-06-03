package June.three;

/**
 * 确定版本号是否匹配
 * 关键在于可以使用integer.parseInt将字符串转成int进行比较处理 如000001 -> 1
 */
public class CompareVersionNumbers {

    public int compareVersion(String version1, String version2) {

        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        // 最长的为基准 确保可以遍历每个.切分出来的string数组
        int len = Math.max(v1.length, v2.length);

        for(int i = 0; i < len; i++){

            // 如果有一个数组的长度为0了,直接返回0 和另一个数组中剩余的部分进行比较
            Integer a = i >= v1.length ? 0 : Integer.parseInt(v1[i]);
            Integer b = i >= v2.length ? 0 : Integer.parseInt(v2[i]);

            int res = a.compareTo(b);
            if(res != 0) return res;
        }
        return 0;
    }


    public static void main(String[] args) {

        Integer a = 10;
        Integer b = 11;

        System.out.println(a.compareTo(b));
    }
}
