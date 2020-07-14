package leetcode15;

import java.util.*;

public class Test {

    public List<List<Integer>> threeSum(int[] nums) {
        //1.暴力破解，三重循环枚举，复杂度为 O(n3)
        //2.两重循环 a,b ;再判断 -(a+b) 是否存在，复杂度 为 O(n2)
        //3.双指针法，先排序，然后从 a 开始循环，a.next,和 last 作为两个指针
        // 如果 last + next = -a ，则成立一个，加进 容器中
        // 如果 last + next > -a,说明太大了，那就把 last 往前移动一位
        // 如果 last + next < -a ，说明太小了，那就把 next 前进一位
        // 如果 last ==  next,那就第一层结束了
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        if (length < 3) return result;
        // 先排序
        Arrays.sort(nums);
        //[1,3,3,4,5] length =5
        for (int i = 0; i < length - 2; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) continue;// 相同的值，算出来是一样的啊
            int left = i + 1;
            int right = length - 1;// 最右边
            //如果两个不相等
            while (left < right) {
                if (nums[left] + nums[right] + nums[i] > 0) {
                    right--;
                } else if (nums[left] + nums[right] + nums[i] < 0) {
                    left++;
                } else {
                    //符合条件，增加元素
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);
                    while (left < right && nums[left] == nums[left + 1]) {// 去重
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;

                }
            }
        }
        return result;
    }
}
