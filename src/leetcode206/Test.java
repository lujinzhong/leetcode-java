package leetcode206;

public class Test {
    public static void main(String[] args) {
        LinkList list = new LinkList();
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        ListNode head = list.getHead();
        list.traversingLinkedList(head);
        ListNode newHead = list.reverseLinkedList();
        list.traversingLinkedList(newHead);


    }
}
