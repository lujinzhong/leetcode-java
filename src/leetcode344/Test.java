package leetcode344;

public class Test {
    protected char[] s;

    public static void main(String[] args) {
        Test test = new Test();
        test.s = new char[] {'a', 'b', 'w'};
        test.reverseString(test.s);
        System.out.println(test.s);
    }

    /**
     * 反转字符串
     *
     * @param s 字符数组
     */
    public void reverseString(char[] s) {
        if (s.length == 0) {
            return;
        }
        // 对称交换
        // 偶数个，刚好两两交换，共交换 length /2 次
        // 奇数个，则是 rail(length /2)  个, 向上取整
        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[s.length - i -1];
            s[s.length - i -1] = temp;
        }

    }
}
