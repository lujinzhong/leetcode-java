package leetcode242;

import java.util.HashMap;

public class Test {

    public static void main(String[] args) {

    }

    public boolean isAnagram(String s, String t) {
        // 都是空字符串，通过
        if (s.equals("") && t.equals("")) return true;
        // 长度不同直接不通过
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (int i=0 ;i <s.length(); i++) {
            if (map1.get(s.charAt(i)) != null) {
                map1.put(s.charAt(i), map1.get(s.charAt(i)) + 1);
            }else {
                map1.put(s.charAt(i), 1);
            }
            if (map2.get(t.charAt(i)) != null) {
                map2.put(t.charAt(i), map2.get(t.charAt(i)) + 1);
            }else {
                map2.put(t.charAt(i), 1);
            }
        }
        return map1.equals(map2);
    }
}
