package leetcode24;

import utils.LinkList;
import utils.ListNode;

public class Test {
    /**
     * 入口
     */
    public static void main(String[] args) {
        LinkList list = LinkList.getInstance();
        int[] arr = {1, 4, 5, 6, 7};
        list.addSomeNode(arr);
        ListNode head = list.getHead();
        ListNode newHead = new Test().swap(head);
        list.traversingLinkedList(newHead);

    }

    /**
     * 两两交换节点
     * @param ListNode head
     * @return ListNode
     */
    public ListNode swap(ListNode head) {
        if (head == null ||head.next == null ) { //递归结束条件
            return head;
        }
        // a(head)->b(next)->处理好的
        // b(next)->a(head)->处理好的
        ListNode next = head.next;
        head.next = swap(next.next); //每次都接上递归处理好的
        next.next = head;
        return next;//返回新的头节点
    }
}
