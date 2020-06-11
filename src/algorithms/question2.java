package algorithms;

public class question2 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }

    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummyHead = new ListNode(0);
            ListNode firstNode = l1, secondNode = l2, curr = dummyHead;
            int carry = 0;
            while (firstNode != null || secondNode != null) {
                int x = (firstNode != null) ? firstNode.val : 0;
                int y = (secondNode != null) ? secondNode.val : 0;
                int sum = carry + x + y;
                carry = sum / 10;
                curr.next = new ListNode(sum % 10);
                curr = curr.next;
                if (firstNode != null) firstNode = firstNode.next;
                if (secondNode != null) secondNode = secondNode.next;
            }
            if (carry > 0) {
                curr.next = new ListNode(carry);
            }
            return dummyHead.next;
        }
    }
}
