package leetcode142;

import utils.LinkList;
import utils.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Test {
    /**
     * 入口
     */
    public static void main(String[] args) {
        LinkList list = LinkList.getInstance();
        int[] arr = {1, 4, 5, 6, 7};
        list.LoopList(arr,2);
        ListNode head = list.getHead();
        list.traversingLinkedList(head);
        ListNode hasCycle = new Test().detectCycle(head);
        System.out.println(hasCycle);
    }


    /**
     * 环在哪里啊！（集合大法，有点垃圾但是简单易懂）
     * @param head
     * @return boolean
     */
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode cur = head;
        while(cur !=null && cur.next != null) {
            if (set.contains(cur)) {
                return cur;
            }
            set.add(cur);
            cur = cur.next;
        }

        return null;
    }
}
