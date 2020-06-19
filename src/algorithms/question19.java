package algorithms;

public class question19 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode res = new ListNode(0);
            res.next = head;
            ListNode first = head;
            int count = 1;
            while (first.next != null) {
                count++;
                first = first.next;
            }
            count -= n;
            first = res;
            while (count > 0) {
                first = first.next;
                count--;
            }
            first.next = first.next.next;
            return res.next;
        }
    }

    static class BetterSolution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode res = new ListNode(0);
            res.next = head;
            ListNode frontPointer = res;
            ListNode behindPointer = res;
            for (int i = 0; i < n + 1; i++){
                frontPointer = frontPointer.next;
            }
            while(frontPointer != null){
                behindPointer=behindPointer.next;
                frontPointer = frontPointer.next;
            }
            behindPointer.next = behindPointer.next.next;
            return res.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        Solution solution = new Solution();
        BetterSolution betterSolution = new BetterSolution();
        betterSolution.removeNthFromEnd(head,2);
        System.out.println(solution.removeNthFromEnd(head, 2));
    }
}
