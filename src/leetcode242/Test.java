package leetcode242;

import java.util.HashMap;

public class Test {

    public static void main(String[] args) {

    }

    /**
     * 哈希表实现
     * @param s 字符串1
     * @param t 字符串 2
     * @return true false
     */
    public boolean isAnagram1(String s, String t) {
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

    /**
     * 数组-抵消计数法
     * @param s 字符串s
     * @param t 字符串 t
     * @return true false
     */
    public boolean isAnagram2(String s, String t) {
        // 都是空字符串，通过
        if (s.equals("") && t.equals("")) return true;
        // 长度不同直接不通过
        if (s.length() != t.length()) return false;
        int[] count = new int[26]; // 26 个字母
        // 思路是，根据 26 字母的 ascll 值来求差索引
        // 如果某个字母两个字符拥有的个数相同，则累加值可以相互抵消 变为 0
        for (char c: s.toCharArray()
             ) {
            count[c - 'a'] +=1;
        }
        for (char c: t.toCharArray()
        ) {
            count[c - 'a'] -=1; // 相同的字母会变为0
        }
        for (int i=0 ;i < 26; i++) {
            if(count[i] != 0) return false;
        }
        return true;
    }
}
