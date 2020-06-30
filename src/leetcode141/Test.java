package leetcode141;

import utils.LinkList;
import utils.ListNode;

public class Test {
    /**
     * 入口
     */
    public static void main(String[] args) {
        LinkList list = LinkList.getInstance();
        int[] arr = {1, 4, 5, 6, 7};
        list.LoopList(arr,2);
        ListNode head = list.getHead();
        System.out.println("开始判断链表是否有环");
        list.traversingLinkedList(head);
        boolean hasCycle = new Test().hasCycle(head);
        System.out.println(hasCycle);
    }


    /**
     * 是否有环
     * @param head
     * @return boolean
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null ) {//少于两个节点就不用考虑了
            return false;
        }
        // 两个节点并且相互指定
        if (head.next.next !=null && head.next.next.val == head.val) {
            return true;
        }
        // 快慢指针
        ListNode fast = head;
        ListNode slow = head;
        //遍历
        while(fast.next != null && fast.next.next != null) {
            if (fast != head && slow.val == fast.val) {
                //慢指针追上了快指针
                return true;
            }
            fast = fast.next.next;//快指针两步
            slow = slow.next; // 慢指针一步

        }
        return false; // 没有环

    }
}
