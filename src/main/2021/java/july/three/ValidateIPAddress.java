package july.three;

/**
 * IPv4
 * 有三个点
 * 三个点把IP地址分成了四段
 * 每一段地址长度不超过4
 * 每一段是一个介于0 - 255之间的纯数字，不包含leading zero (使用string转int再equals的方式判断)
 * IPv6
 *
 * 有七个冒号
 * 七个冒号把IP地址分成了八段
 * 每一段地址长度不超过4
 * 每一段可以由数字和字母的组合构成，数字的范围是在0 - 9，字母的范围是在a - f和A - F之间
 *
 */
public class ValidateIPAddress {

    public String validIPAddress(String IP) {

        if(IP == null || IP.length() == 0) return "Neither";

        if(helpIpv4(IP)) return "IPv4";

        if(helpIpv6(IP)) return "IPv6";

        return "Neither";
    }

    private boolean helpIpv6(String ip) {
        if(ip.length() < 15) return false;
        // 判断‘:’的个数是否大于3个
        int count = 0;
        for(int i = 0; i < ip.length(); i++){

            if(ip.charAt(i) == ':') count++;
        }
        if(count  != 7) return false;

        // 验证经过.切割后,是否有4个segment
        String[] strs = ip.split(":");
        if(strs.length != 8) return false;

        for (String str : strs) {

            if(str.length() == 0 || str.length() > 4 ) return false;
            for (char c : str.toCharArray()) {

                if( !((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F')) ) return false;
            }
        }

        return true;
    }

    private boolean helpIpv4(String ip) {
        // 判断‘.’的个数是否大于3个
        int count = 0;
        for(int i = 0; i < ip.length(); i++){

            if(ip.charAt(i) == '.') count++;
        }
        if(count  != 3) return false;

        // 验证经过.切割后,是否有4个segment
        String[] strs = ip.split("\\.");
        if(strs.length != 4) return false;

        // 验证每个字符串是否合法
        for (String str : strs) {

            // 判断空字符串
            // 验证是否超过了长度,这里先验证,避免下面的转换验证
            if(str.length() == 0 || str.length() > 3) return false;

            // 验证每个字符串是否合法
            for (char c : str.toCharArray()) {
                if(c < '0' || c > '9') return false;
            }

            int num = Integer.parseInt(str);
            // 排除大于255或者前导零的情况
            if(num > 255 || num < 0 || !str.equals(String.valueOf(num))) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidateIPAddress a = new ValidateIPAddress();
        System.out.println(a.validIPAddress("12..33.4"));
    }
}
