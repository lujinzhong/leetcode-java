package leetcode1;

import java.util.Arrays;
import java.util.HashMap;

public class Test {

    public static void main(String[] args) throws Exception {
        int [] a = new int[]{1,2};
        System.out.println(a.toString());
        System.out.println((Arrays.toString((new Test()).twoSum(a,3))));

    }

    public int[] twoSum(int[] nums, int target) {
        // x + y = target,所以 x = target -y
        // 遍历 x,寻找 target -y 是否在 map 中存在,这里要注意的是把值当 key ,下标作为value，因为
        // hashmap 只能通过 key 获取 value
        // 或者使用暴力破解法，直接两个遍历
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target -nums[i]), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("没有匹配的");
    }
}
