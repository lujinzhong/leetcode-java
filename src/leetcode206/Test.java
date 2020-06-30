package leetcode206;

import utils.LinkList;
import utils.ListNode;

public class Test {
    /**
     * 入口
     */
    public static void main(String[] args) {
        LinkList list = LinkList.getInstance();
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        ListNode head = list.getHead();
        list.traversingLinkedList(head);
        ListNode newHead = new Test().reverseLinkedList(head);
        list.traversingLinkedList(newHead);

    }

    /**
     * 反转链表
     * @return
     */
    public ListNode reverseLinkedList(ListNode head) {
        ListNode cur = head;
        ListNode pre= null;
        while (cur != null) {
            //保留节点，然后把上一个节点的 next 设置为 null,下一个的节点指向上一个节点
            // a->b->c->null
            ListNode tmp = cur.next; // 保留下一个节点，避免后面找不到了
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

}
