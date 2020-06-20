package algorithms;

import java.util.List;

public class question21 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    static class Solution {
        ListNode res = new ListNode(0);
        ListNode curr = res;
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null){
                return l2;
            }
            else if (l2 == null){
                return l1;
            }
            if (l1.val <= l2.val) {
                l1.next = mergeTwoLists(l1.next,l2);
                return l1;
            } else {
                l2.next = mergeTwoLists(l1, l2.next);
                return l2;
            }
        }
        static class BetterSolution {
            public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
                ListNode prehead = new ListNode(-1);

                ListNode prev = prehead;
                while (l1 != null && l2 != null) {
                    if (l1.val <= l2.val) {
                        prev.next = l1;
                        l1 = l1.next;
                    } else {
                        prev.next = l2;
                        l2 = l2.next;
                    }
                    prev = prev.next;
                }

                // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
                prev.next = l1 == null ? l2 : l1;

                return prehead.next;
            }
        }
    }
    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(5);
        Solution solution = new Solution();
        ListNode res = solution.mergeTwoLists(l1,l2);
        while (res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }
}
