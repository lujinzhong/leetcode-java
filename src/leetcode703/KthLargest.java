package leetcode703;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargest {
    protected Queue<Integer> queue;
    protected int limit;

    public KthLargest(int k, int[] nums) {
        //用最小堆，然后比较堆顶元素，如果来的数字比堆顶小，则忽略，如果大，则替换并且重新
        // java 中可以通过优先级队列来使用堆，因为 Java 的优先级队列就是用堆实现的
        // 每次维护的堆大小应该是 k 大小
        this.queue = new PriorityQueue<>(k);
        this.limit = k;
        // 遍历添加所有元素
        for (int num : nums
        ) {
          add(num);
        }
    }

    /**
     * 维护一个 limit 大小的最小堆
     */
    public int add(int val) {
        if (queue.size() < limit ) { // 维护这个堆大小为 limit
            queue.add(val);
        } else if (val > queue.peek()) { // 新来的比堆顶大，说明要替换，因为比堆顶小的话，就比整个数据流都小
            // 大的话替换堆顶元素
            queue.poll();
            queue.add(val);
        }
        return queue.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
