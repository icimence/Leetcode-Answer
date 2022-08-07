package algorithms;

public class question25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode res = new ListNode(0, head);
        ListNode p = res;
        while (head != null) {
            ListNode tail = p;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null)
                    return res.next;
            }
            ListNode next = tail.next;
            ListNode[] temp = reverseListNode(head, tail);
            head = temp[0];
            tail = temp[1];
            p.next = head;
            tail.next = next;
            head = tail.next;
            p = tail;
        }
        return res.next;
    }

    private ListNode[] reverseListNode(ListNode head, ListNode tail) {
        ListNode tailNext = tail.next;
        ListNode p = head;
        while (tailNext != tail) {
            ListNode next = p.next;
            p.next = tailNext;
            tailNext = p;
            p = next;
        }
        return new ListNode[]{tail, head};
    }
}
