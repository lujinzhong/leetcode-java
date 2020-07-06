package leetcode239;

import java.util.*;

public class Test {

    protected Queue<Integer> queue;

    public static void main(String[] args) {
        int[] test = new int[]{2, 4, 7, 3, 8, 6, 3, 2};
        int[] maxArr = new Test().maxSlidingWindowOne(test, 3);
        System.out.println(Arrays.toString(maxArr));
    }

    /**
     * 滑动窗口最大值 （最大堆解法，但是在leetcode 第 17 个用例 会超时)
     * @param nums 数组
     * @param k    窗口大小
     * @return 最大值数组
     */
    public int[] maxSlidingWindowOne(int[] nums, int k) {
        // eg : 2,4,7,3,8,6,3,2  k= 3  length = 8
        // 1. [2,4,7] leftIndex = 0; max= 7
        // 2. [4,7,3] leftIndex = 1; max= 7
        // 3. [7,3,8] leftIndex = 2; max= 8
        // 4. [3,8,6] leftIndex = 3; max= 8
        // 5. [8,6,3] leftIndex = 4; max= 8
        // 6. [6,3,2] leftIndex = 5; max= 6  leftIndex = length - k, result.length = length -k + 1
        // result: 7,7,8,8,8,6 (6个）
        // eg : 2,4,7,3,8,6,3,2  k= 2
        // result: 4,7,7,8,6,3
        // 使用优先级队列来维护一个最大堆，每次窗口移动后，去除窗口最左边的数，让新来的来
        if (nums.length == 0) return nums;

        this.queue = new PriorityQueue<>(k, new Comparator<>() { // 重写 compare 实现最大堆
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int length = nums.length;
        int[] maxArr = new int[length - k + 1];
        int leftIndex = 0;// 第一次窗口的最左边，应该是 0 索引
        // 生成一个 k 大小的堆
        for (int num : nums
        ) {
            if (queue.size() < k) { // 初始化堆
                queue.add(num);
            } else if (queue.size() == k) { //开始取最大数， 此时 堆长 为 k
                maxArr[leftIndex] = queue.peek();
                queue.remove(nums[leftIndex]);//移除最左边的值
                leftIndex++;// 索引 + 1
                queue.add(num);
            }
        }
        maxArr[length - k] = queue.peek();// 添加最大值
        return maxArr;
    }

}
