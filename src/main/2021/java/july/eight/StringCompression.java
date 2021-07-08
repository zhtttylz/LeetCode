package july.eight;

public class StringCompression {

    public int compress(char[] chars) {

        if(chars == null || chars.length == 0) return 0;
        if(chars.length == 1) return 1;

        int res = 0;
        int start = 0;
        for(int i = 0; i < chars.length; i++){

            // 因为下面可能要对数组进行处理,所以先记录开始位置
            int count = 1;

            // 判断当前位置的数和后面的数是否相等,计算相等的个数
            while( (i + 1) < chars.length && chars[i] == chars[i + 1]){

                count++;
                i++;
            }

            // 判断重复数是否超过了2个,超过了两个,修改原数组,进行处理
            if(count >= 2){

                // 将原始数加上
                res++;
                chars[start++] = chars[i];
                String str = count + "";
                // 每一位顺序相加
                for(int a = 0; a < str.length(); a++){

                    chars[start++] = str.charAt(a);
                    res++;
                }
            }else{ // 只有一个数不进行处理

                res++;
                chars[start++] = chars[i];
            }
        }

        return res;
    }

}
