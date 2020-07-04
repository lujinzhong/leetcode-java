package leetcode703;

public class Test {
    public static void main(String[] args) {
        // 测试用例
        int[] test = new int[] {0};
        KthLargest k = new KthLargest(2, test);
        System.out.println(k.add(-1));
        System.out.println(k.add(1));
        System.out.println(k.add(-2));
        System.out.println(k.add(-4));
        System.out.println(k.add(3));
        // null, -1, 0, 0, 0, 1
    }
}
