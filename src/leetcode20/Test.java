package leetcode20;

import utils.LinkList;
import utils.ListNode;

import java.util.HashMap;
import java.util.Stack;

public class Test {
    /**
     * 入口
     */
    public static void main(String[] args) {
        String str1 = "()";
        System.out.println(new Test().isValid(str1));
        String str2 = "()[]{}";
        System.out.println(new Test().isValid(str2));
        String str3 = "(]";
        System.out.println(new Test().isValid(str3));
        String str4 = "([)]";
        System.out.println(new Test().isValid(str4));
        String str5 = "{[]}";
        System.out.println(new Test().isValid(str5));
    }

    /**
     * 括号匹配-有效的括号
     * @return boolean
     */
    public boolean isValid(String s) {
        HashMap<Character,Character> map = new HashMap<>();
        map.put(']', '[');
        map.put('}', '{');
        map.put(')', '(');
        // 创建一个栈
        Stack<Character> stack = new Stack<>();
        int length = s.length();
        if (s.equals("")) return true; // 空字符也是合法滴
        if (length == 1 ) return false;
        if (length % 2 != 0) return false;

        for (int i = 0; i < length ; i++){
            // 每次取出对应的字符
            // 1。如果是左边的符号，那么压进去，如果是右边的符号，匹配栈顶元素
            char c = s.charAt(i);
            // 如果栈的元素大于剩下未匹配的，直接挂
            if (stack.size() > length - i) return false;
            if (map.containsKey(c)){ // 说明是右边匹配符号
                if (stack.isEmpty()) return false;
                if (stack.pop() != map.get(c)) { // 弹出栈顶元素并且和右符号匹配
                    return false;
                }
            }else{ //左边
                stack.push(c);
            }
        }
        // 解析字符串
        if (stack.isEmpty()) {//栈为空才返回有效
            return true;
        }
        return false;
    }
}
