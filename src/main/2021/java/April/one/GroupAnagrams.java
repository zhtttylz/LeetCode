package April.one;

import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> res = new ArrayList<>();
        if(strs == null || strs.length == 0) return res;

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] c = str.toCharArray();
            Arrays.sort(c);

            String tmp = new String(c);
            if(!map.containsKey(tmp)){

                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(tmp,list);
            }else{

                map.get(tmp).add(str);
            }
        }

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {

            res.add(entry.getValue());
        }
        return res;
    }
}
