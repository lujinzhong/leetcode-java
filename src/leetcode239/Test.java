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
     *
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

    /**
     * 双向队列实现
     *
     * @param nums 数组
     * @param k    窗口大小
     * @return 最大数组
     */
    public int[] maxSlidingWindowTwo(int[] nums, int k) {
        int length = nums.length;
        if (length < 2) return nums;

        int[] maxArr = new int[length - k + 1];
        LinkedList<Integer> window = new LinkedList<>();// 双端队列

        for (int i = 0; i < length; i++) {
            // 每次新来一个元素，就干掉队列中又老又小的
            while (!window.isEmpty() && nums[i] >= nums[window.peekLast()]) {
                window.pollLast();
            }
            // 将当前的加进窗口中
            window.addLast(i);
            // 判断一下窗口是否超过了 k 大小, i-k 是窗口的左边索引，对头小于它说明，它已经是走过的了
            // 这里这么理解，假设 K = 3，那么 i =3 的时候 i-k=0, 我们可以知道窗口的左边最小也是从0 开始
            // 因此 小于 0 就不合法了，另外一种情况是，当 i = 5 的时候， i-k = 2,说明 我们已经遍历到
            // 第六个元素了，窗口最左边最小也是 5 - k = 5 -3 = 2,如果队列的下标还存在 比 2小的，那么这个窗口
            // 就炸了，这是为了避免后面的值一直比左边的小导致一直入队，炸窗口导致
            if (window.peek() <= i - k) {
                window.poll();
            }

            if (i + 1 >= k) { //这里是因为窗口满足了 k 个才有比较窗口最大值，
                // 当遍历次数 小于 3 的时候，窗口还没有 满，那这时候就不应该比较大小
                maxArr[i + 1 - k] = nums[window.peek()];
            }

        }
        return maxArr;
    }

}
