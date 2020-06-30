package utils;

/**
 * 链表
 */
public class LinkList {
    private static LinkList instance;
    // 头节点
    protected ListNode head = null;

    private void LinkList() { }


    public static LinkList getInstance() {
        if (instance == null) {
            instance = new LinkList();
        }
        return instance;
    }

    /**
     * 创建链表
     *
     * @param
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
     * 增加多个节点
     */
    public void addSomeNode(int[] data) {
        int start = 0;
        if (this.head == null) {
            this.head = new ListNode(data[0]);
            start = 1;
        }
        ListNode cur = this.head;
        while (cur.next != null) { //找到最后一个节点
            cur = cur.next;
        }
        for (int a = start; a < data.length; a++) {
            // 找到最后一个节点，再一个一个给接上
            cur.next = new ListNode(data[a]);
            cur = cur.next;
        }


    }

    /**
     * 遍历链表
     */
    public void traversingLinkedList(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + "->");
            cur = cur.next;
        }
        System.out.println("null");
    }

    /**
     * 获取链表的头节点
     *
     * @return ListNode
     */
    public ListNode getHead() {
        return this.head;
    }

    /**
     * 创建有环的链表
     * @param data
     * @param  pos
     * @return ListNode
     */
    public ListNode LoopList(int[] data, int pos) {
      addSomeNode(data);
      //找到最后一个节点，让他连接上第 pos 个节点
        ListNode cur = this.head;
        for (int i=0; i<=pos; i++) {
            cur = cur.next;
        }
        //保存节点
        ListNode posNode = cur;
        //用最后一个节点来处理
        while(cur.next != null) {
            cur = cur.next;
        }
        cur.next = posNode;
        return head;
    }


}
