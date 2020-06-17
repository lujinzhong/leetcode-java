package leetcode206;

public class LinkList {
    protected ListNode head = null;

    /**
     * 创建链表
     * @param data
     */
    public void addNode(int data) {
        if (this.head == null) { // 没有头节点先创建
            this.head = new ListNode(data);
            return;
        }
        ListNode cur = this.head;
        while (cur.next != null) { //找到最后一个节点
            cur = cur.next;
        }
        cur.next = new ListNode(data);
    }

    /**
     * 遍历链表
     */
    public void traversingLinkedList(ListNode head) {
        ListNode cur = head;
        while (cur!= null) {
            System.out.print(cur.val + "->");
            cur = cur.next;
        }
        System.out.println("null");
    }

    public ListNode getHead() {
        return this.head;
    }

    /**
     * 反转链表
     * @return
     */
    public ListNode reverseLinkedList() {
        ListNode cur = this.head;
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
